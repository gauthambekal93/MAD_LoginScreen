package com.example.gauth.mad_loginscreen;

import java.io.Serializable;

/**
 * Created by gauth on 6/5/2018.
 */

public class StudentInfo implements Serializable
{
    String name;
    String email;
    String radioValue;
    int seekBar;
    StudentInfo(String name,String email,String radioValue,int seekBar)
    {
        this.name=name;
        this.email=email;
        this.radioValue=radioValue;
        this.seekBar=seekBar;
    }

    public String values()
    {
        return (name+" "+email+ "  "+radioValue+" "+Integer.toString(seekBar));
    }
}
