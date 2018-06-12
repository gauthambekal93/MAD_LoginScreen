package com.example.gauth.mad_loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class FinalDisplay extends AppCompatActivity {

    TextView NAME;
    EditText Name;
    TextView EMAIL;
TextView DEPARTMENT;
    EditText Email;
    RadioGroup rg;
RadioButton r1,r2,r3,r4;
    TextView MOOD;
    TextView Mood;
    SeekBar seeker;
  static String temp="";
    int x;
    //NEED TO EDIT THIS LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_display);

        NAME=(TextView)findViewById(R.id.NAME1);
        EMAIL=(TextView)findViewById(R.id.EMAIL1);
        DEPARTMENT=(TextView)findViewById(R.id.DEPARTMENT1);
        rg=(RadioGroup) findViewById(R.id.radioGroup1);
        MOOD=(TextView)findViewById(R.id.MOOD1);
        NAME.setVisibility(View.INVISIBLE);
        EMAIL.setVisibility(View.INVISIBLE);
        DEPARTMENT.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);
        MOOD.setVisibility(View.INVISIBLE);

        Name=(EditText)findViewById(R.id.Name1);
        Email=(EditText)findViewById(R.id.Email1);

        Mood=(TextView) findViewById(R.id.Mood1);
        Name.setVisibility(View.INVISIBLE);
        Email.setVisibility(View.INVISIBLE);

        Mood.setVisibility(View.INVISIBLE);
        seeker = (SeekBar) findViewById(R.id.seekBar2);
      seeker.setVisibility(View.INVISIBLE);
        r1=(RadioButton)findViewById(R.id.radioButton11);
        r2=(RadioButton)findViewById(R.id.radioButton21);
        r3=(RadioButton)findViewById(R.id.radioButton31);
        r4=(RadioButton)findViewById(R.id.radioButton41);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public  void onCheckedChanged(RadioGroup radioGroup,int checkedId)
            {
                RadioButton rb=(RadioButton)findViewById(checkedId);
                DisplayResults.department.setText(rb.getText().toString());
            }
        });

        seeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Mood.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        x= getIntent().getIntExtra("Edit Value",0);

        if(x==1)
        {
            Log.i("Hi","1");
            NAME.setVisibility(View.VISIBLE);
            Name.setVisibility(View.VISIBLE);
            Name.setText(temp);
        }
        else if(x==2)
        {
            Log.i("Hi","2");

            EMAIL.setVisibility(View.VISIBLE);
            Email.setVisibility(View.VISIBLE);
            Email.setText(temp);
        }
        else if(x==3)
        {
            Log.i("Hi","3");
            DEPARTMENT.setVisibility(View.VISIBLE);
            rg.setVisibility(View.VISIBLE);
            if(temp.equals("SIS")){r1.setChecked(true);}
           if(temp.equals("CS")){r2.setChecked(true);}
            if(temp.equals("BIO")){r3.setChecked(true);}
            if(temp.equals("Others")){r4.setChecked(true);}
        }
        else{
            Log.i("Hi","4");
            MOOD.setVisibility(View.VISIBLE);
            Mood.setVisibility(View.VISIBLE);
            Mood.setText(temp);
            seeker.setVisibility(View.VISIBLE);
        }
    }
public  void saveValues(View view)
{
   if(x==1){
       DisplayResults.name.setText(Name.getText().toString());
       }
    else if(x==2){
       DisplayResults.email.setText(Email.getText().toString());
        Log.i("email edited",Email.getText().toString());
       }
    else{
        DisplayResults.mood.setText(Mood.getText().toString());
        Log.i("mood edited",Mood.getText().toString());
   }
finish();
}
}
