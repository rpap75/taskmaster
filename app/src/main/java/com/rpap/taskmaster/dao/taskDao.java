package com.rpap.taskmaster.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rpap.taskmaster.model.task;

import java.util.List;

//import kotlinx.coroutines.scheduling.Task;

@Dao
public interface taskDao {
    @Insert
    public void insertATask(task task);

    @Query("SELECT * FROM task")
    public List<task> findAll();

    @Query("SELECT * FROM task WHERE id = :id")
    public task findById(Long id);

    @Query("SELECT * FROM task WHERE status = :status")
    public List<task> findAllByStatus(task.taskStatusEnum status);

    @Delete
    public void delete(task task);

    @Update
    public void update(task task);
}
