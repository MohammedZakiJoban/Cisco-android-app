package com.example.mzj.cisco;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class router extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);
    }

    public void health(View view) {

        Intent intent = new Intent(this, interface_health.class);
        startActivity(intent);



    }

    public void hardware(View view) {

        new ExecCommand(this).execute("show environment");


    }
}
