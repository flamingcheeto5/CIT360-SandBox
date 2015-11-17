/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author dbanks
 */
public class HTTPConnection {
    
    public static final void urltest() {
  URL url;
    HttpURLConnection urlConnection = null;
    try {
        url = new URL("http://marvelcomicsuniverse.com/index1.php");

        urlConnection = (HttpURLConnection) url
                .openConnection();

        InputStream in = urlConnection.getInputStream();

        InputStreamReader isw = new InputStreamReader(in);

        int data = isw.read();
        while (data != -1) {
            char current = (char) data;
            data = isw.read();
            System.out.print(current);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace(); //If you want further info on failure...
        }
    }
  }  
}
