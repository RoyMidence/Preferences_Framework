package com.example.preferencesframework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference);

        // Create fragment and display in the FrameLayout.
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_a_container, new UserPreferenceFragment())
                .commit();

    }
}