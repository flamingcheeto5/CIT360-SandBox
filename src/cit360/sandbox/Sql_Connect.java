/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DBanks
 */
public class Sql_Connect {

  public final static void connect(){
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
            String query = "select * from movies ;";
        //movies is the table name
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getObject(2).toString();
                String Start_Time = rs.getObject(3).toString();
                System.out.println(name + ": " + Start_Time);
        //movies table has name and price columns

        }
    } 
    catch (SQLException e) {
        for(Throwable ex : e) {
            System.err.println("Error occurred " + ex);
        }
            System.out.println("Error in fetching data");
    }
  }       
}

