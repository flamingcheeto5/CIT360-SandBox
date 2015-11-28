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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
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
      public static final void smtpExample() {
// declaration section:
// smtpClient: our client socket
// os: output stream
// is: input stream
        Socket smtpSocket = null;  
        DataOutputStream os = null;
        DataInputStream is = null;
// Initialization section:
// Try to open a socket on port 25
// Try to open input and output streams
        try {
            smtpSocket = new Socket("localhost", 25);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Did not recognize server: localhost");
        } catch (IOException e) {
            System.err.println("Was not able to open I/O connection to: localhost");
        }
// If everything has been initialized then we want to write some data
// to the socket we have opened a connection to on port 25
    if (smtpSocket != null && os != null && is != null) {
            try {
// The capital string before each colon has a special meaning to SMTP
// you may want to read the SMTP specification, RFC1822/3
        os.writeBytes("HELO\n");    
                os.writeBytes("MAIL From: david.banks0889@gmail.com\n");
                os.writeBytes("RCPT To: david.banks0889@gmail.com\n");
                os.writeBytes("DATA\n");
                os.writeBytes("From: david.banks0889@gmail.com\n");
                os.writeBytes("Subject: TEST\n");
                os.writeBytes("Hi there\n"); // message body
                os.writeBytes("\n.\n");
        os.writeBytes("QUIT");
// keep on reading from/to the socket till we receive the "Ok" from SMTP,
// once we received that then we want to break.
                String responseLine;
                while ((responseLine = is.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.contains("Ok")) {
                      break;
                    }
                }
// clean up:
// close the output stream
// close the input stream
// close the socket
        os.close();
                is.close();
                smtpSocket.close();   
            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
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

