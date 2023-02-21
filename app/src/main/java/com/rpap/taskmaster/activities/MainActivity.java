package com.rpap.taskmaster.activities;

import static com.rpap.taskmaster.activities.UserSettingsActivity.USERNAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rpap.taskmaster.R;
import com.rpap.taskmaster.adapter.taskRecyclerViewAdapter;
import com.rpap.taskmaster.database.taskMasterDatabase;
import com.rpap.taskmaster.model.task;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    taskMasterDatabase taskMasterDatabase;
    public static final String DATABASE_NAME = "task_master";

    public static final String TASKS_EXTRA_TAG = "userTask";

    List<task> taskList;
    taskRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskMasterDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        taskMasterDatabase.class,
                        DATABASE_NAME)
                .fallbackToDestructiveMigration() //DO NOT USE IN PRODUCTION
                .allowMainThreadQueries()
                .build();

        taskList = taskMasterDatabase.taskDao().findAll();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setupButtons();
        setUpRecyclerView();

    }


        @Override
        protected void onResume () {
            super.onResume();
            taskList.clear();
            taskList.addAll(taskMasterDatabase.taskDao().findAll());
            adapter.notifyDataSetChanged();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = preferences.getString(USERNAME_TAG, "no username");

        ((TextView) findViewById(R.id.mainActivityUsernameTextView)).setText(username + "'s");

        }

        public void setUpRecyclerView () {

            RecyclerView tasksRecyclerView = findViewById(R.id.mainActivityRecyclerViewTasks);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            tasksRecyclerView.setLayoutManager(layoutManager);

            adapter = new taskRecyclerViewAdapter(taskList, this);
            tasksRecyclerView.setAdapter(adapter);
        }

        public void setupButtons () {

            Button addTaskIntentButton = (Button) findViewById(R.id.mainActivityAddTaskButton);
            addTaskIntentButton.setOnClickListener(v -> {
                Intent goToAddTaskIntent = new Intent(this, AddTaskActivity.class);
                startActivity(goToAddTaskIntent);
            });
            Button allTasksIntentButton = (Button) findViewById(R.id.mainActivityAllTasksButton);
            allTasksIntentButton.setOnClickListener(v -> {
                Intent goToAllTasksIntent = new Intent(this, AllTasksActivity.class);
                startActivity(goToAllTasksIntent);
            });

            ImageView settingsButton = (ImageView) findViewById(R.id.mainActivitySettingsImageView);
            settingsButton.setOnClickListener(v -> {
                Intent goToSettingsIntent = new Intent(this, UserSettingsActivity.class);
                startActivity(goToSettingsIntent);
            });
        }
    }