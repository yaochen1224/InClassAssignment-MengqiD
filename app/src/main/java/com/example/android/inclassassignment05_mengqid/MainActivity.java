package com.example.android.inclassassignment05_mengqid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students = new ArrayList<>();
    String gender;
    String graduateStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);
        int size = sharedPreference.getInt("size", 0);
        for (int i = 0; i < size; ++ i) {
            String gender = sharedPreference.getString("gender"+i, "");
            String graduate = sharedPreference.getString("graduate"+i, "");
            String name = sharedPreference.getString("name"+i, "");
            String uni = sharedPreference.getString("uni"+i, "");
            students.add(new Student(name, uni, gender, graduate));
        }
        /*
        gender = sharedPreference.getString("gender", "");
        graduateStatus = sharedPreference.getString("graduate", "");
        String name = sharedPreference.getString("name", "");
        String uni = sharedPreference.getString("uni", "");

        if (gender.equals("female")) {
            ((RadioButton) findViewById(R.id.female)).setChecked(true);
        } else if (gender.equals("male")) {
            ((RadioButton) findViewById(R.id.male)).setChecked(true);
        } else if (gender.equals("other")) {
            ((RadioButton) findViewById(R.id.other)).setChecked(true);
        }
        if (graduateStatus.equals("Graduated")) {
            ((RadioButton) findViewById(R.id.graduate)).setChecked(true);
        } else if (graduateStatus.equals("Not Graduated")) {
            ((RadioButton) findViewById(R.id.not_graduate)).setChecked(true);
        }

        ((EditText)findViewById(R.id.name)).setText(name);
        ((EditText)findViewById(R.id.uni)).setText(uni);*/
    }

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



    public void save(View view) {
            EditText name = (EditText) findViewById(R.id.name);
            String studentName = name.getText().toString();

            EditText uni = (EditText) findViewById(R.id.uni);
            String studentUni = uni.getText().toString();


            //Build an ArrayList
            int index = students.size();
            Student newStudent = new Student(studentName,studentUni,gender,graduateStatus);
            students.add(newStudent);

            // Store to preference
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name" + index, studentName);
            editor.putString("uni" + index, studentUni);
            editor.putString("gender" + index, gender);
            editor.putString("graduate" + index, graduateStatus);
            editor.putInt("size", students.size());
            editor.commit();

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
