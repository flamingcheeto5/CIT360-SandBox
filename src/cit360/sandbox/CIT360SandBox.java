/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;

import static java.lang.Compiler.command;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import java.net.URL; 
import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection; 
import java.net.URL; 
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;




/**
 *
 * @author DBanks
 */
public class CIT360SandBox {
    
private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		CIT360SandBox http = new CIT360SandBox();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://www.google.com";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	
	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "http://apple.com";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}
  

}
        
            /*Scanner input = new Scanner(System.in);   // gets input using scanner and puts it into variable firstName
            System.out.println("What is your name?");
            CIT360SandBox.firstName = input.next();
            
            System.out.println("Welcome " + firstName + "!");
            
            CIT360SandBox.App.mainMenu();
    }
   }    
    /**public static void main(String[] args) {     
      List moses = new ArrayList();  // A List contains instances of Object. Upcast ArrayList to List
      moses.add("Genesis");            // add() takes Object. String upcast to Object implicitly
      moses.add("Exodus");
      moses.add("Leviticus");
      moses.add("Numbers");
      moses.add("Deuteronomy");
      System.out.println(moses);     // prints the list of the first 5 books in the Old Testament
 
      // Get a "iterator" instance from List to iterate thru all the elements of the List
      Iterator iter = moses.iterator();
      while (iter.hasNext()) {      // any more element
         // Retrieve the next element, explicitly downcast from Object back to String
         String str = (String)iter.next();
         System.out.println(str);
        }
    }
  */
