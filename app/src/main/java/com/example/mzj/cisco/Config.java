package com.example.mzj.cisco;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Config extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }


    public void onClick(View view) {

        Intent intent = new Intent(Config.this, Interface_config.class);
        startActivity(intent);
    }

    public void onClick2(View view) {

        Intent intent = new Intent(Config.this, routing.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(Config.this, access_list.class);
        startActivity(intent);
    }
}

