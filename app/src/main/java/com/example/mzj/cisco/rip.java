package com.example.mzj.cisco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.mzj.cisco.ConfigCommand.ps;

public class rip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rip);
    }

    public void rip(View view) {


        String command;
        EditText t1 = (EditText) findViewById(R.id.editText10);

        ExecChannel ex = new  ExecChannel();
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox2);




        if (checkBox.isChecked()){

            if(ex.validIP(t1.getText().toString())){
                command =  "ip route rip\nno network"+t1.getText()+"\n exit";
                ps.println("conf t\n"+command);
                Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this, "Enter a vaild network address", Toast.LENGTH_LONG).show();
        }




        else {


            if(ex.validIP(t1.getText().toString())){
                command =  "ip route rip\n network"+t1.getText()+"\n exit";
                ps.println("conf t\n"+command);
                Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this, "Enter a vaild network address", Toast.LENGTH_LONG).show();
        }





    }
}
