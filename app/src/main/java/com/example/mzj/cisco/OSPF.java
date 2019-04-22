package com.example.mzj.cisco;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.mzj.cisco.ConfigCommand.ps;

public class OSPF extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ospf);
    }

    public void ospf(View view) {


        String command;
        EditText t1 = (EditText) findViewById(R.id.editText);
        EditText t2 = (EditText) findViewById(R.id.editText2);
        EditText t3 = (EditText) findViewById(R.id.editText3);
        EditText t4 = (EditText) findViewById(R.id.editText12);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox3);
        ExecChannel ex = new  ExecChannel();




        if (checkBox.isChecked()){
              if (ex.validIP(t2.getText().toString()) && ex.validIP(t3.getText().toString())){
                  if (t4.getText() != null && t1.getText() !=null){
                      command  = "router ospf "+t1.getText()+"\nno network "+t2.getText()+" "+t3.getText()+" "+ t4.getText()+"\n exit";
                      ps.println("conf t\n"+command);
                      Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();

                  }
                  else
                      Toast.makeText(this, "Enter a vaild ID and area", Toast.LENGTH_LONG).show();
              }
            Toast.makeText(this, "Enter a vaild IP address", Toast.LENGTH_LONG).show();
        }

               else {
            if (ex.validIP(t2.getText().toString()) && ex.validIP(t3.getText().toString())){
                if (t4.getText() != null && t1.getText() !=null){
                    command  = "router ospf "+t1.getText()+"\n network "+t2.getText()+" "+t3.getText()+" "+ t4.getText()+"\n exit";
                    ps.println("conf t\n"+command);
                    Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(this, "Enter a vaild ID and area", Toast.LENGTH_LONG).show();
            }
            Toast.makeText(this, "Enter a vaild IP address", Toast.LENGTH_LONG).show();



        }
    }
}
