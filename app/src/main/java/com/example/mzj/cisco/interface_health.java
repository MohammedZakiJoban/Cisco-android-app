package com.example.mzj.cisco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class interface_health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_health);
    }




 String result ;



    public void health(View view) {
        EditText t1 = (EditText) findViewById(R.id.editText11);

        RadioGroup Rg = (RadioGroup) findViewById(R.id.radio);
        RadioButton r1 = (RadioButton) findViewById(Rg.getCheckedRadioButtonId());

        String command = "show interface "+r1.getText()+"  "+t1.getText();
        new ExecCommand(this).execute(command);
    }
}
