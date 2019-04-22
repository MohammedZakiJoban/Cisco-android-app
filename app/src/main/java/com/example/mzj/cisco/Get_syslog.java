package com.example.mzj.cisco;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.mzj.cisco.Connection.s;

/**
 * Created by MZJ on 11/22/2016.
 */

public class Get_syslog extends AsyncTask <String,Integer,String> {



   Context context;

    public Get_syslog(Context context){
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        Intent intent = new Intent(context, DisplayStatus.class);
        context.startActivity(intent);
        ((Activity) context).finish();
    }

    @Override
    protected String doInBackground(String... strings) {

         String full = null;
      try {
      ChannelSftp sftpChannel = (ChannelSftp) s.openChannel("sftp");
      sftpChannel.connect();

       sftpChannel.cd("/cygdrive/C/Program Files (x86)/Syslogd/Logs");

         InputStream out = sftpChannel.get("SyslogCatchAll-2016-11-22.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(out));
              String line;
                while ((line = br.readLine()) != null) {
                 full = full + "\n" + line;

                  }
                  br.close();
                    }
                     catch (JSchException | IOException | SftpException e){

                        full = "File not found";

                          }
                       return full;

                          }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
