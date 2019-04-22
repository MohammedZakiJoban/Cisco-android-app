package com.example.mzj.cisco;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import static com.example.mzj.cisco.Connection.s;

/**
 * Created by MZJ on 11/9/2016.
 */

public class ConfigCommand extends AsyncTask <String,Integer,String> {



    String full;
    private Context context;
    static Channel channel;
    static PrintStream ps;

    public ConfigCommand(Context context){
        this.context=context;
    }



    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();


    }

    @Override
    protected String doInBackground(String... strings) {

        try {

                channel = s.openChannel("shell");
                OutputStream ops = channel.getOutputStream();
              ps = new PrintStream(ops, true);

                channel.connect();



                full = "entered configure mode";

            }catch(JSchException | IOException e)

            {
                full = "not sent";
            }



        return full;
    }
}






