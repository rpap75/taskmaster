package com.rpap.taskmaster.activities;

import static com.rpap.taskmaster.activities.UserSettingsActivity.USERNAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rpap.taskmaster.R;
import com.rpap.taskmaster.adapter.taskRecyclerViewAdapter;
import com.rpap.taskmaster.model.task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TASKS_EXTRA_TAG = "userTask";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecyclerView();

//        TextView taskDetailButtonOne = (TextView) findViewById(R.id.mainActivityTaskOneTextViewBtn);
//        taskDetailButtonOne.setOnClickListener(v -> {
//            String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskOneTextViewBtn)).getText().toString();
//            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
//            goToTaskDetailIntent.putExtra(TASKS_EXTRA_TAG, taskDetail);
//            startActivity(goToTaskDetailIntent);
//        });
//
//        TextView taskDetailButtonTwo = (TextView) findViewById(R.id.mainActivityTaskTwoTextViewBtn);
//        taskDetailButtonTwo.setOnClickListener(v -> {
//            String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskTwoTextViewBtn)).getText().toString();
//            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
//            goToTaskDetailIntent.putExtra(TASKS_EXTRA_TAG, taskDetail);
//            startActivity(goToTaskDetailIntent);
//        });
//
//        TextView taskDetailButtonThree = (TextView) findViewById(R.id.mainActivityTaskThreeTextViewBtn);
//        taskDetailButtonThree.setOnClickListener(v -> {
//            String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskThreeTextViewBtn)).getText().toString();
//            Intent goToTaskDetailIntent = new Intent(this, TaskDetailActivity.class);
//            goToTaskDetailIntent.putExtra(TASKS_EXTRA_TAG, taskDetail);
//            startActivity(goToTaskDetailIntent);
//        });

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
        ((TextView) findViewById(R.id.mainActivityUsernameTextView)).setText(username);
    }

    public void setUpRecyclerView() {
        List<task> taskList = new ArrayList<>();
        task task1 = new task("a", "1");
        task task2 = new task("b", "2");
        task task3 = new task("c", "3");
        task task4 = new task("d", "4");
        task task5 = new task("e", "5");
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);

        RecyclerView tasksRecyclerView = findViewById(R.id.tasksActivityRecyclerViewTasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        tasksRecyclerView.setLayoutManager(layoutManager);

        taskRecyclerViewAdapter adapter = new taskRecyclerViewAdapter(taskList, this);
        tasksRecyclerView.setAdapter(adapter);
    }
}