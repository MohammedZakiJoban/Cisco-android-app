package com.example.mzj.cisco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.PrintStream;

import static com.example.mzj.cisco.ConfigCommand.ps;

public class Interface_config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_config);
    }




    public void onClick(View view) {

        EditText t1 = (EditText) findViewById(R.id.editText4);
        EditText t2 = (EditText) findViewById(R.id.editText5);
        EditText t3 = (EditText) findViewById(R.id.editText6);

        RadioGroup Rg = (RadioGroup) findViewById(R.id.radio);
        RadioButton r1 = (RadioButton) findViewById(Rg.getCheckedRadioButtonId());
        RadioGroup Rg2 = (RadioGroup) findViewById(R.id.radio4);
        RadioButton r2 = (RadioButton) findViewById(Rg2.getCheckedRadioButtonId());
        RadioGroup Rg3 = (RadioGroup) findViewById(R.id.radio7);
        RadioButton r3 = (RadioButton) findViewById(Rg3.getCheckedRadioButtonId());

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);


        ExecChannel ex = new ExecChannel();

        String command = null;





        if (checkBox.isChecked()){

            if (t1.getText() != null) {
                command = "interface " + r1.getText() + " " + t1.getText() + "\nno ip address\n " + "shut" + "\nexit";
                ps.println("conf t\n" + command);
                Toast.makeText(this, "sent", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Please enter interface number", Toast.LENGTH_SHORT).show();
        }

        else {

            if (ex.validIP(t2.getText().toString()) && ex.validIP(t3.getText().toString())) {

                if(t1.getText() != null) {
                    command = "interface " + r1.getText() + " " + t1.getText() + "\nip address " + t2.getText() + " " + t3.getText() + "\n" + r2.getText() +"\n"+ "duplx "+r3.getText()+ "\nexit";
                    ps.println("conf t\n" + command);
                    Toast.makeText(this, "sent", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, "Please enter interface number", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Please enter vaild ip address", Toast.LENGTH_SHORT).show();
        }




            }

        }










