package com.rpap.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rpap.taskmaster.R;
import com.rpap.taskmaster.database.taskMasterDatabase;
import com.rpap.taskmaster.model.task;

public class AddTaskActivity extends AppCompatActivity {
    taskMasterDatabase taskMasterDatabase;

    Spinner taskStatusSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskStatusSpinner = findViewById(R.id.taskStatusSpinner);
        taskMasterDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        taskMasterDatabase.class,
                        MainActivity.DATABASE_NAME)
                .fallbackToDestructiveMigration() //DO NOT USE IN PRODUCTION
                .allowMainThreadQueries()
                .build();

        setUpStatusSpinner();
        setUpSaveButton();

//        Button addTaskButton = (Button) findViewById(R.id.addTaskActivityAddTaskButton);
//        addTaskButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView submittedTextView = (TextView) findViewById(R.id.addTaskActivitySubmittedText);
//                submittedTextView.setVisibility(View.VISIBLE);
//            }
//        });
    }

    public void setUpStatusSpinner() {
        taskStatusSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                task.taskStatusEnum.values()
        ));
    }

    public void setUpSaveButton() {
        findViewById(R.id.addTaskActivityAddTaskButton).setOnClickListener(v -> {
            task newTask = new task(
                    ((EditText)findViewById(R.id.addTaskActivityTaskTitleInput)).getText().toString(),
                    ((EditText)findViewById(R.id.addTaskActivityTaskDescriptionInput)).getText().toString(),
                    task.taskStatusEnum.fromString(taskStatusSpinner.getSelectedItem().toString())
                    );
            taskMasterDatabase.taskDao().insertATask(newTask);
            Toast.makeText(this, "Status Saved!", Toast.LENGTH_SHORT).show();
        });
    }

}