package com.rpap.taskmaster.activities;

import static com.rpap.taskmaster.activities.UserSettingsActivity.USERNAME_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rpap.taskmaster.R;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView settingsButton = (ImageView) findViewById(R.id.mainActivitySettingsImageView);
        settingsButton.setOnClickListener(v -> {
            Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
            startActivity(goToUserSettingsIntent);
        });

        Button addTaskIntentButton = (Button) findViewById(R.id.mainActivityAddTaskButton);
        addTaskIntentButton.setOnClickListener(v -> {
            Intent goToAddTaskIntent = new Intent(this, AddTaskActivity.class);
            startActivity(goToAddTaskIntent);
        });

        Button allTaskIntentButton = (Button) findViewById(R.id.mainActivityAllTasksButton);
        allTaskIntentButton.setOnClickListener(v -> {
            Intent goToAllTaskIntent = new Intent(this, AllTasksActivity.class);
            startActivity(goToAllTaskIntent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = preferences.getString(USERNAME_TAG, "no username");
        ((TextView)findViewById(R.id.mainActivityUsernameTextView)).setText(username);
    }
}