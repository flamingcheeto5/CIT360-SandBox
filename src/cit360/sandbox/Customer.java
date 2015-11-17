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
public class Customer {
      private long id;
    private String firstName;
    private String lastName;

    @JsonCreator
    public Customer(@JsonProperty("id")long id, @JsonProperty("firstName")String fn, @JsonProperty("lastName")String ln) {
        this.firstName = fn;
        this.lastName = ln;
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
            return this.firstName + " " + this.lastName;
    }
}
