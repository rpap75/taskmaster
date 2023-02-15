package com.rpap.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.rpap.taskmaster.R;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        Intent callingIntent = getIntent();
        String userTaskString = null;
        if (callingIntent != null) {
            userTaskString = callingIntent.getStringExtra(MainActivity.TASKS_EXTRA_TAG);
            TextView userTasksTextView = (TextView) findViewById(R.id.taskDetailActivityTitle);
            if (userTaskString != null) {
                userTasksTextView.setText(userTaskString);
            } else {
                userTasksTextView.setText("No Input");
            }
        }
    }
}