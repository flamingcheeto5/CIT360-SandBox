package com.example.detectinternetconnection;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class DownloadWebpageExample {
 
  public static void main(String[] args) {
    try {
      URL url = new URL("http://www.vogella.com");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      String readStream = readStream(con.getInputStream());
      // Give output for the command line
      System.out.println(readStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
}

  private static String readStream(InputStream in) {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
      
      String nextLine = "";
      while ((nextLine = reader.readLine()) != null) {
        sb.append(nextLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
  
    public boolean isNetworkAvailable() {
    ConnectivityManager cm = (ConnectivityManager) 
      getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
    // if no network is available networkInfo will be null
    // otherwise check if we are connected
    if (networkInfo != null && networkInfo.isConnected()) {
        return true;
    }
    return false;
} 
} 