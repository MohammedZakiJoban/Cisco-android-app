package com.example.mzj.cisco;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jcraft.jsch.Session;


public class MainActivity extends Activity   {






    public static String ip;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }





    public void login(View view) {


        RadioGroup Rg = (RadioGroup) findViewById(R.id.radio);
        RadioButton r1 = (RadioButton) findViewById(Rg.getCheckedRadioButtonId());

String device = r1.getText().toString();


        switch (device){

            case "R1" : ip = "192.168.1.1";
                break;
            case "R2" : ip = "192.168.1.3";
                break;
            default: ip = "10.0.2.2";
                break;
        }




        new Connection(this).execute(ip);



    }


}


