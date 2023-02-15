package com.rpap.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.rpap.taskmaster.R;

public class UserSettingsActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String Username_TAG = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = preferences.getString(Username_TAG, "");
        EditText usernameEditText = (EditText) findViewById(R.id.userSettingsActivityUsernameEditTextView);

        Button saveButton = findViewById(R.id.userSettingsActivitySaveButton);
        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor preferencesEditor = preferences.edit();
            EditText usernameEditText = (EditText) findViewById(R.id.userSettingsActivityUsernameEditTextView);
            String usernameString = usernameEditText.getText().toString();

            preferencesEditor.putString(Username_TAG, usernameString);
            preferencesEditor.apply();

//            Snackbar.make(findViewById(R.id.userSettingsActivity), "Settings Saved!", Snackbar.LENGTH_SHORT).show();
            Toast.makeText(this, "Settings Saved!", Toast.LENGTH_SHORT).show();
        });
    }
}