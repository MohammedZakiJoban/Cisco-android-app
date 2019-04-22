package com.example.mzj.cisco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.mzj.cisco.ConfigCommand.ps;

public class Static_route extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_route);
    }




    public void onClick(View view) {
        EditText t1 = (EditText) findViewById(R.id.editText7);
        EditText t2 = (EditText) findViewById(R.id.editText8);
        EditText t3 = (EditText) findViewById(R.id.editText9);
        CheckBox checkBox = (CheckBox)  findViewById(R.id.checkBox5);

        String command = null;

        ExecChannel ex = new  ExecChannel();


         if (checkBox.isChecked()) {

             if (ex.validIP(t1.getText().toString()) && ex.validIP(t2.getText().toString()) && ex.validIP(t3.getText().toString())) {

                 command = "no ip route " + t1.getText() + " " + t2.getText() + " " + t3.getText() + "\n exit";
                 ps.println("conf t\n" + command);

                 Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();
             }
         }
        else {
             if (ex.validIP(t1.getText().toString()) && ex.validIP(t2.getText().toString()) && ex.validIP(t3.getText().toString())) {

                 command = "ip route " + t1.getText() + " " + t2.getText() + " " + t3.getText() + "\n exit";
                 ps.println("conf t\n" + command);

                 Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();
         }
    }

}}
