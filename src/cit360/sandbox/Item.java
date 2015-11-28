/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.sandbox;

import JSONExample.Categories;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author dbanks
 */
public class Item {
    private long id;
    private String name;
    private Categories cat;
    private double price;

    @JsonCreator
    public Item (@JsonProperty("id")long id, @JsonProperty("name")String n, @JsonProperty("cat")Categories c, @JsonProperty("price")double p){
        this.id = id;
        this.name = n;
        this.cat = c;
        this.price = p;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categories getCat() {
        return this.cat;
    }

    public void setCat(Categories cat) {
        this.cat = cat;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return this.name + " (Unit Price: " + this.price + " - Category: " + this.cat + ")" ;
    }
}
