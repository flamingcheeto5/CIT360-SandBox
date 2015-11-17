/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author dbanks
 */
public class OrderItem {
     private int quantity;
    private Item it;
    private double price;

    @JsonCreator
    public OrderItem(@JsonProperty("quantity")int q, @JsonProperty("it")Item it){
        this.quantity = q;
        this.it = it;
        this.price = q*it.getPrice();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getIt() {
        return this.it;
    }

    public void setIt(Item it) {
        this.it = it;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "n° " + this.quantity + " " + this.it + ": " + this.price;
    }
}
