package com.eso.taskroomdatabase.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    void insert(Student student);

    @Query("SELECT * FROM student_table")
    List<Student> getAllStudent();

    @Delete
    void delete(Student student);
}
