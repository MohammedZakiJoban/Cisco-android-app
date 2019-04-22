package com.example.mzj.cisco;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.example.mzj.cisco.MainActivity.ip;

/**
 * Created by MZJ on 11/23/2016.
 */

public class ExecChannel {


    public  boolean validIP (String ip) {
        try {
            if ( ip == null || ip.isEmpty() ) {
                return false;
            }

            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }

            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            if ( ip.endsWith(".") ) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }


    public String connect(String command) {
       String full = ""  ;

try {
    JSch jsch = new JSch();
    Session s;
    s = jsch.getSession("cisco",ip, 22);
    s.setPassword("cisco");
    Properties config = new Properties();
    config.put("StrictHostKeyChecking", "no");
    s.setConfig(config);

    s.connect();

        Channel c;
        c = s.openChannel("exec");
        ChannelExec ce = (ChannelExec) c;

        ce.setCommand(command);
        ce.setErrStream(System.err);
        ce.connect();
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(ce.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            full = full + "\n" + line;

        }
    if (command.contains("  ")) {

        String[] ss = full.split("(,)|(  )");


        full = "";
        for (int i = 0; i < 19; i++) {


            full = full + ss[i].trim()+"\n";
        }

    }
    ce.disconnect();
    s.disconnect();


    }

    catch(JSchException|IOException e)

    {
        full = "not found";
    }
        return full;
}
}
