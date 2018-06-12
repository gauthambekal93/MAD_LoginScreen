package com.example.gauth.mad_loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayResults extends AppCompatActivity {

    static TextView name;
    static TextView email;
    static TextView department;
    static TextView mood;

    TextView NAME;
    TextView EMAIL;
    TextView DEPARTMENT;
    TextView MOOD;
    StudentInfo studentInfo;
    static String temp="";
    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        studentInfo=(StudentInfo) getIntent().getExtras().getSerializable("Pass Value");
        Toast.makeText(this,studentInfo.toString(),Toast.LENGTH_LONG).show();

        NAME=(TextView)findViewById(R.id.NAME);
        EMAIL=(TextView)findViewById(R.id.EMAIL);
        DEPARTMENT=(TextView)findViewById(R.id.DEPARTMENT);
        MOOD=(TextView)findViewById(R.id.MOOD);

        name= (TextView) findViewById(R.id.Name);
       name.setText(studentInfo.name);

        email= (TextView) findViewById(R.id.Email);
        email.setText(studentInfo.email);

        department= (TextView) findViewById(R.id.Department);
        department.setText(studentInfo.radioValue);

        mood=(TextView)findViewById(R.id.Mood);
        mood.setText(Integer.toString(studentInfo.seekBar));

    }
    public void edit1(View view)
    {
        Log.i("EDIT1","CLICKED");
        Intent intent = new Intent(DisplayResults.this, FinalDisplay.class);
        FinalDisplay.temp=name.getText().toString();
      intent.putExtra("Edit Value",1);
        startActivity(intent);

    }
    public void Edit2(View view)
    {
        Log.i("EDIT2","CLICKED");
        Intent intent = new Intent(DisplayResults.this, FinalDisplay.class);
        FinalDisplay.temp=email.getText().toString();
        intent.putExtra("Edit Value",2);
        startActivity(intent);
    }
    public void Edit3 (View view)
    {
        Log.i("EDIT3","CLICKED");
        Intent intent = new Intent(DisplayResults.this, FinalDisplay.class);
        FinalDisplay.temp=department.getText().toString();
        intent.putExtra("Edit Value",3);
        startActivity(intent);
    }
    public void Edit4 (View view)
    {
        Log.i("EDIT4","CLICKED");
        Intent intent = new Intent(DisplayResults.this, FinalDisplay.class);
        FinalDisplay.temp=mood.getText().toString();
        intent.putExtra("Edit Value",4);
        startActivity(intent);
    }
}
