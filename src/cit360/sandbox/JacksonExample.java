/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonExample {

    public static void jsonExample() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        mapper.setDateFormat(sdf);

        Customer c1 = new Customer(1,"Davis", "Molinari");

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
}

