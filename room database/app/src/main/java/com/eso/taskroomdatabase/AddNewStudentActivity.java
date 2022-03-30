package com.eso.taskroomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewStudentActivity extends AppCompatActivity {

    Button mBtnSubmit;
    EditText mEtName,mEtEmail,mEtCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        mBtnSubmit = findViewById(R.id.btnSubmit);
        mEtName = findViewById(R.id.et_name);
        mEtEmail = findViewById(R.id.et_email);
        mEtCountry = findViewById(R.id.et_country);
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEtEmail.getText().toString()))
                    Toast.makeText(AddNewStudentActivity.this, "Name field cannot be empty", Toast.LENGTH_SHORT).show();

                else {
                    String name = mEtName.getText().toString();
                    String email = mEtEmail.getText().toString();
                    String country = mEtCountry.getText().toString();

                    Intent intent = new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("email",email);
                    intent.putExtra("country",country);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}
