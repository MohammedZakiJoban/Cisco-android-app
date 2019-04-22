package com.example.mzj.cisco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class DisplayStatus extends AppCompatActivity {


    public static TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_status);
         t1 = (TextView) findViewById(R.id.textView5);

    }
}
