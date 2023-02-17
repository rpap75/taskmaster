package com.rpap.taskmaster.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.rpap.taskmaster.dao.taskDao;
import com.rpap.taskmaster.model.task;

@Database(entities = {task.class}, version = 1)
public abstract class taskMasterDatabase extends RoomDatabase {

    public abstract taskDao taskDao();
}
