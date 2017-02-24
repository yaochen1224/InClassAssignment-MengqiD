package com.example.android.inclassassignment05_mengqid;

import java.io.Serializable;

/**
 * Created by Maureen_Ding on 2/23/17.
 */

public class Student implements Serializable {
    private String name;
    private String uni;
    private String gender;
    private String graduate;

    public Student(String name,String uni,String gender, String graduate){
        this.name = name;
        this.uni = uni;
        this.gender = gender;
        this.graduate = graduate;
    }

    public String toString()
    {
        String output = "Name: " + name + "\n" + "UNI: " + uni+ "\n" + "Gender: " + gender + "\n" + "Graduate Status: " + graduate +"\n" + "\n";
        return output;
    }

}
