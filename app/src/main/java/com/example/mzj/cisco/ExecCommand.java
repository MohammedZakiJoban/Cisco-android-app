package com.example.mzj.cisco;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.example.mzj.cisco.Connection.s;


/**
 * Created by MZJ on 10/26/2016.
 */

public class ExecCommand extends AsyncTask<String,Integer,String>

{

    private Context context;


    public ExecCommand(Context context){
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        Intent intent = new Intent(context, DisplayStatus.class);
        context.startActivity(intent);
        ((Activity) context).finish();
    }

    @Override
    protected void onPostExecute(String s) {
        DisplayStatus.t1.setText(s);




    }

    @Override
    protected String doInBackground(String... strings) {

        ExecChannel exc = new ExecChannel();
        String full = null;
       full= exc.connect(strings[0]);





        return full;
    }
}
