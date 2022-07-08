package com.example.preferencesframework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.InetSocketAddress;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    Button buttonTextSize;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.registerOnSharedPreferenceChangeListener(this);

        buttonTextSize = findViewById(R.id.buttonTextSize);
        textViewMessage = findViewById(R.id.textViewMessage);

        buttonTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp =
                        PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String fontSize = sp.getString("text_size_preference", "14");
                Toast.makeText(MainActivity.this,"Text Size = " + fontSize,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_settings:
                Intent intent = new Intent(MainActivity.this, UserPreferenceActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // Code that should run when a preference is updated
        float textSize = Float.parseFloat(sharedPreferences.getString(key, "14"));
        Toast.makeText(this, "Text Size Updated", Toast.LENGTH_SHORT).show();
        textViewMessage.setTextSize(textSize);
    }
}