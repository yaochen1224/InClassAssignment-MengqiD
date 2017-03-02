package com.example.android.inclassassignment05_mengqid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String gender;
    String graduateStatus;

    public void genderSelect(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.female:
                if(checked)
                    gender = "female";
                break;
            case R.id.male:
                if(checked)
                    gender = "male";
                break;
            case R.id.other:
                if(checked)
                    gender = "other";
                break;
        }
    }

    public void graduateCheck(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.graduate:
                if(checked)
                    graduateStatus = "Graduated";
                break;
            case R.id.not_graduate:
                if(checked)
                    graduateStatus = "Not Graduated";
                break;
        }
    }



    public void save(View view)
        {
            EditText name = (EditText) findViewById(R.id.name);
            String studentName = name.getText().toString();

            EditText uni = (EditText) findViewById(R.id.uni);
            String studentUni = uni.getText().toString();


            //Build an ArrayList
            Student newStudent = new Student(studentName,studentUni,gender,graduateStatus);
            students.add(newStudent);

            // Clear the data
            name.setText("");

            uni.setText("");

            ((RadioButton) findViewById(R.id.female)).setChecked(false);
            ((RadioButton) findViewById(R.id.male)).setChecked(false);
            ((RadioButton) findViewById(R.id.other)).setChecked(false);

            ((RadioButton) findViewById(R.id.graduate)).setChecked(false);
            ((RadioButton) findViewById(R.id.not_graduate)).setChecked(false);

            Toast.makeText(this,"Record is saved!", Toast.LENGTH_SHORT).show();

        }

    public void results (View view)
    {
        //Put the arraylist in the intent
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Student Records",students);
        students = new ArrayList<>();
        startActivity(intent);
    }



}
