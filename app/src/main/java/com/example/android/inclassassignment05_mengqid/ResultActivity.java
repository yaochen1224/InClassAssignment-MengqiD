package com.example.android.inclassassignment05_mengqid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        ArrayList<Student> output = (ArrayList<Student>) intent.getSerializableExtra("Student Records");

        String displayMessage = "";
        for (Student student : output){
            displayMessage += student.toString();
        }

        TextView resultView = (TextView) findViewById(R.id.result_view);
//        String displayMessage = output.toString().replace("[","");
//        displayMessage = displayMessage.replace("]","");
//        displayMessage = displayMessage.replace(", ","");
        resultView.setText(displayMessage);


    }

    public void back(View view)
    {
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);

    }

}

