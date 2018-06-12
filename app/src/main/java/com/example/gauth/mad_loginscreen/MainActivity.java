package com.example.gauth.mad_loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    int seekProgress=0;
    String radioValue="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar mood = (SeekBar) findViewById(R.id.seekBar);
        RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup);

        //RADIO BUTTON LISTNER
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
         public  void onCheckedChanged(RadioGroup radioGroup,int checkedId)
        {
            RadioButton rb=(RadioButton)findViewById(checkedId);
            //Log.i("Radio button is",rb.getText().toString());
            radioValue=rb.getText().toString();
        }
        });

//SEEK BAR LISTNER
            mood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //Log.i("Seek Bar value",Integer.toString(progress));
            seekProgress=progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

    }
    //Submitting the values
    public void Submit(View view)
    {
        Log.i("Value is","Submit");
        name= (EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        Log.i("Name",name.getText().toString());
        Log.i("Email",email.getText().toString());
        Log.i("Radio value is",radioValue);
        Log.i("Seek value is",Integer.toString(seekProgress));

        //Creates an object and stores result of Student
        StudentInfo student=new StudentInfo(name.getText().toString(),email.getText().toString(),radioValue,seekProgress);

        Intent intent = new Intent(MainActivity.this, DisplayResults.class);
        //Sending the serialized Student object
        intent.putExtra("Pass Value",student);
        startActivity(intent);
    }
}
