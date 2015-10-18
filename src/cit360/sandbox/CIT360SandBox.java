/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DBanks
 */
public class CIT360SandBox {
    /**
     * @param args the command line arguments
     */
  public static void main(String[] args){
        Connection conn = null;
try {
    conn =
       DriverManager.getConnection("jdbc:mysql://localhost/cit361-sandbox?" +
                                   "user=root&password=");

    // Do something with the Connection

} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

if (null != conn) {
    System.out.println("Connected to database!");
} else {
    System.out.println("Failed to make connection!");
}

    try {
        Statement stmt = conn.createStatement();
        String query = "select * from products ;";
    //person is the table name
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getObject(2).toString();
            String price = rs.getObject(5).toString();
            System.out.println("Your favorite comic is " + name + " and it costs $" + price);
    //Person table has name and gender column

        }
    } catch (SQLException e) {
        for(Throwable ex : e) {
            System.err.println("Error occurred " + ex);
        }
        System.out.println("Error in fetching data");
    }
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
