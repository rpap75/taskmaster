package com.rpap.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rpap.taskmaster.R;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addTaskButton = (Button) findViewById(R.id.addTaskActivityAddTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView submittedTextView = (TextView) findViewById(R.id.addTaskActivitySubmittedText);
                submittedTextView.setVisibility(View.VISIBLE);
            }
        });
    }
}