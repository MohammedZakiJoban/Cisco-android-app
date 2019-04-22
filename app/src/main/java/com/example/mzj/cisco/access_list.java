package com.example.mzj.cisco;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.mzj.cisco.ConfigCommand.ps;

public class access_list extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_list);
    }

    public void access(View view) {



        String command;
        EditText t1 = (EditText) findViewById(R.id.editText13);
        EditText t2 = (EditText) findViewById(R.id.editText14);
        EditText t3 = (EditText) findViewById(R.id.editText15);
        EditText t4 = (EditText) findViewById(R.id.editText16);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio);
        RadioButton R1 = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox4);
        ExecChannel ex = new  ExecChannel();





        if (checkBox.isChecked()){

            if (ex.validIP(t2.getText().toString()) && ex.validIP(t3.getText().toString()) && ex.validIP(t4.getText().toString())){
                if(t1.getText() != null){
                    command  = "no access-list "+t1.getText()+ " "+R1.getText()+" " +t2.getText()+" "+t3.getText()+" "+ t4.getText()+"\n exit";
                    ps.println("conf t\n"+command);
                    Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "Enter a vaild access list", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this, "Enter a vaild ip address", Toast.LENGTH_LONG).show();
            }

    }
        else {
            if (ex.validIP(t2.getText().toString()) && ex.validIP(t3.getText().toString()) && ex.validIP(t4.getText().toString())){
                if(t1.getText() != null){
                    command  = "access-list "+t1.getText()+ " "+R1.getText()+" " +t2.getText()+" "+t3.getText()+" "+ t4.getText()+"\n exit";
                    ps.println("conf t\n"+command);
                    Toast.makeText(this, "sent", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "Enter a vaild access list", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this, "Enter a vaild ip address", Toast.LENGTH_LONG).show();
            }
        }


        }

}
