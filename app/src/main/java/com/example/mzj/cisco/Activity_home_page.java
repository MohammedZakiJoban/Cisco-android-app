package com.example.mzj.cisco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }


    public void currentConfig(View view) {

        Intent intent = new Intent(Activity_home_page.this,current_config.class);
        startActivity(intent);
    }

    public void changeConfig(View view) {

        Intent intent = new Intent(Activity_home_page.this,Config.class);
        startActivity(intent);
        new ConfigCommand(this).execute();
    }

    public void condtion(View view) {


        Intent intent = new Intent(Activity_home_page.this,router.class);
        startActivity(intent);

    }
}
