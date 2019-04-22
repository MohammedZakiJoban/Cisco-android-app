package com.example.mzj.cisco;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import android.widget.Toast;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


import java.util.Properties;

/**
 * Created by MZJ on 7/10/2016.
 */



public class Connection extends AsyncTask<String,Integer,String> {




    String full = null;
   public static Session s;

    private Context context;

    public Connection(Context context){
        this.context=context;
    }


    @Override
    protected void onPostExecute(String s) {

        if (s.equals("not connected")) {
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

        }
        else if (s.equals("connected to the server") ) {
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, Syslog.class);
            context.startActivity(intent);
            ((Activity) context).finish();
        }
        else{
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, Activity_home_page.class);
            context.startActivity(intent);
            ((Activity) context).finish();
        }


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            JSch jsch = new JSch();
           s = jsch.getSession("cisco",strings[0],22);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
           s.setConfig(config);
            s.setPassword("cisco");

            s.connect();

            switch (strings[0]){
                case "10.0.2.2": full = "connected to the server";
                    break;
                case "192.168.1.1": full = "connected to R1";
                    break;
                default: full = "connected to R2";
                    break;
            }
        }
        catch (JSchException  e) {
           full = "not connected";
        }
        return full;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



}
