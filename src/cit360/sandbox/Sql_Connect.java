/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.Context;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;


/**
 *
 * @author DBanks
 */
public class Sql_Connect {

        public static final void jsonExample() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        mapper.setDateFormat(sdf);

        Customer c1 = new Customer(1,"David", "Banks");

        Item i1 = new Item(1, "Tablet XYZ", Categories.HARDWARE, 199.0);
        Item i2 = new Item(2, "Jackson Tutorial", Categories.BOOK, 19.00);
        Item i3 = new Item(3, "Running shoes", Categories.SPORT, 65.50);

        OrderItem oi1 = new OrderItem(2,i1);
        OrderItem oi2 = new OrderItem(3,i2);
        OrderItem oi3 = new OrderItem(1,i3);

        Order o = new Order(1000, c1, new ArrayList<OrderItem>(), new Date());
        o.addItemToOrder(oi1);
        o.addItemToOrder(oi2);
        o.addItemToOrder(oi3);

        System.out.println(o);
        System.out.println("------------");

        String s = null;
        try {
            s = mapper.writeValueAsString(o);
        }
        catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(s);
        System.out.println("------------");

        Order o2 = null;
        try {
            o2 = mapper.readValue(s, Order.class);
        }
        catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(o2);


    }
    public static final void urltest() {
  URL url;
    HttpURLConnection urlConnection = null;
    try {
        url = new URL("http://marvelcomicsuniverse.com");

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

