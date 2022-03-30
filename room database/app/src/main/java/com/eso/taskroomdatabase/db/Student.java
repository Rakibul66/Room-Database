package com.eso.taskroomdatabase.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {

    @ColumnInfo(name = "studentId")
    @PrimaryKey(autoGenerate = true)
    private int studentId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "country")
    private String country;
    @ColumnInfo(name = "registeredTime")
    private String registeredTime;

    @Ignore
    public Student() {
    }

    public Student(int studentId, String name, String email, String country, String registeredTime) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.country = country;
        this.registeredTime = registeredTime;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }
}
