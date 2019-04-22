package com.example.mzj.cisco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class current_config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_config);
    }

    String Command;








    public void accessList(View view) {
        Command = "show access-lists";

        new ExecCommand(this).execute(Command);
    }

    public void ipInterface(View view) {

        Command = "show ip interface brief";
        new ExecCommand(this).execute(Command);
    }

    public void ipRoute(View view) {
        Command = "show ip route";
        new ExecCommand(this).execute(Command);
    }

    public void interfaces(View view) {

        Intent intent = new Intent(this, interface_health.class);
        startActivity(intent);

    }
}
