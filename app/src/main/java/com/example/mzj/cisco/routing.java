package com.example.mzj.cisco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class routing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routing);
    }





    public void onClick(View view) {

        Intent intent = new Intent(routing.this,Static_route.class);
        startActivity(intent);
    }

    public void onClick2(View view) {

        Intent intent = new Intent(routing.this,rip.class);
        startActivity(intent);
    }
}
