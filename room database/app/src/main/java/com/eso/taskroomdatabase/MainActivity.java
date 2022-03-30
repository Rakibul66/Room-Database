package com.eso.taskroomdatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.eso.taskroomdatabase.db.Student;
import com.eso.taskroomdatabase.db.StudentDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StudentDatabase studentDatabase;
    StudentAdapter studentAdapter;
    List<Student> studentList = new ArrayList<>();
    RecyclerView mRvStudent;
    FloatingActionButton mFloatAction;
    public static final int NEW_STUDENT_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDatabase = Room.databaseBuilder(getApplicationContext(), StudentDatabase.class, "StudentDB")
                .allowMainThreadQueries().build();

        loadData();
        mRvStudent = findViewById(R.id.rvStudent);
        mRvStudent.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRvStudent.setItemAnimator(new DefaultItemAnimator());
        studentAdapter = new StudentAdapter(this, studentList);
        mRvStudent.setAdapter(studentAdapter);
        mFloatAction = findViewById(R.id.float_action);
        mFloatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddNewStudentActivity.class);
                startActivityForResult(intent,NEW_STUDENT_ACTIVITY);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Student studentToDelete = studentList.get(viewHolder.getAdapterPosition());
                deleteStudent(studentToDelete);
            }
        }).attachToRecyclerView(mRvStudent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_STUDENT_ACTIVITY && resultCode == RESULT_OK){
            String name = data.getStringExtra("name");
            String email = data.getStringExtra("email");
            String country = data.getStringExtra("country");
            @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
            String currentDate = simpleDateFormat.format(new Date());
            Student student = new Student();
            student.setName(name);
            student.setEmail(email);
            student.setCountry(country);
            student.setRegisteredTime(currentDate);
            AddNewStudent(student);
        }
    }

    private void AddNewStudent(Student student) {
        new AddNewStudents().execute(student);
    }

    private void deleteStudent(Student student) {
        new DeleteStudents().execute(student);
    }

    private void addNewStudent(Student student) {
        new AddNewStudents().execute(student);
    }

    private void loadData() {
        new GetAllStudents().execute();
    }

    @SuppressLint("StaticFieldLeak")
    public class GetAllStudents extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            studentList = studentDatabase.getStudentDAO().getAllStudent();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            studentAdapter.setData(studentList);
        }
    }

    @SuppressLint("StaticFieldLeak")
    public class DeleteStudents extends AsyncTask<Student, Void, Void> {
        @Override
        protected Void doInBackground(Student... students) {
            studentDatabase.getStudentDAO().delete(students[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            loadData();
        }
    }

    @SuppressLint("StaticFieldLeak")
    public class AddNewStudents extends AsyncTask<Student, Void, Void> {
        @Override
        protected Void doInBackground(Student... students) {
            studentDatabase.getStudentDAO().insert(students[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            loadData();
        }
    }
}
