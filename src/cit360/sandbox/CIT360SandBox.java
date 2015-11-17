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
    public static String firstName; 
    static Iterable<String[]> Selections; 
    public final static Sql_Connect Sql_Connect = new Sql_Connect(); 
    public final static Menu App = new Menu(); 

	public static void main(String[] args) throws Exception {
                
            Scanner input = new Scanner (System.in); 
            System.out.println("What is your name?");
            CIT360SandBox.firstName = input.next(); 
            
            System.out.println("Welcome " + firstName + "!");
            
            CIT360SandBox.App.mainMenu();

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
