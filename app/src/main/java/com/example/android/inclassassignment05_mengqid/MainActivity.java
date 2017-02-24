package com.example.android.inclassassignment05_mengqid;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void save(View view)
        {
            Intent intent = new Intent(this, ResultActivity.class);

            EditText name = (EditText) findViewById(R.id.name);
            String studentName = name.getText().toString();

            EditText uni = (EditText) findViewById(R.id.uni);
            String studentUni = name.getText().toString();

            RadioButton female = (RadioButton) findViewById(R.id.female);
            boolean isFemale = female.isChecked();

            RadioButton male = (RadioButton) findViewById(R.id.male);
            boolean isMale = male.isChecked();

            RadioButton other = (RadioButton) findViewById(R.id.other);
            boolean isOther = other.isChecked();
            String gender;

            if (isFemale) {
                gender = "female";
            } else if (isMale) {
                gender = "male";
            } else {
                gender = "other";
            }

            boolean graduateStatus=false;
            RadioButton graduate = (RadioButton) findViewById(R.id.graduate);
            if (graduate.isChecked()) {
                graduateStatus = true;
            }


            //Build a com.example.android.inclassassignment05_mengqid.Student ArrayList
            ArrayList<Student> students = new ArrayList<Student>();
            Student newStudent = new Student(studentName,studentUni,gender,graduateStatus);
            students.add(newStudent);

            // Clear the data
            studentName="";
            name.setText(studentName);

            studentUni="";
            uni.setText(studentUni);

            female.setSelected(false);
            male.setSelected(false);
            other.setSelected(false);
            graduate.setSelected(false);
            RadioButton notGraduate = (RadioButton)findViewById(R.id.not_graduate);
            notGraduate.setSelected(false);

            //Put the arraylist in the intent
            intent.putExtra("Student Object",students);

        }



}
