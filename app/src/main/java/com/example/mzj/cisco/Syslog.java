package com.example.mzj.cisco;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Syslog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syslog);





    }

    public void viewMessages(View view) {

        new Get_syslog(this).execute();

    }
}
