package cit360.sandbox;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    private long id;
    private Customer customer;
    private List<OrderItem> itemList;
    private double total;
    private Date placedDate;

    @JsonCreator
    public Order(@JsonProperty("id")long id, @JsonProperty("customer")Customer cust, @JsonProperty("itemList")List<OrderItem> li, @JsonProperty("placedDate")Date pDate, @JsonProperty("total")double total) {
        this.id = id;
        this.customer = cust;
        this.itemList = li;
        this.placedDate = pDate;
        this.total = total;
    }

    public Order(long id, Customer cust, List<OrderItem> li, Date pDate) {
        this.id = id;
        this.customer = cust;
        this.placedDate = pDate;

        // this.itemList = li;
        // this.total = this.total;
        for (OrderItem oi : li) {
            this.addItemToOrder(oi);
        }
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer cust) {
        this.customer = cust;
    }

    public List<OrderItem> getItemList() {
        return this.itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public void addItemToOrder(OrderItem oi) {
        if (this.itemList == null) {
            this.itemList = new ArrayList<>();
        }
        this.itemList.add(oi);
        this.total += oi.getPrice();
    }

    public Date getPlacedDate() {
        return this.placedDate;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("ORDER ID: ").append(this.id).append("\n");
        ret.append("ORDER DATE: ").append(this.placedDate).append("\n");
        ret.append("CUSTOMER: ").append(this.customer).append("\n");
        ret.append("ITEMS:\n");
        for (OrderItem oi : this.itemList) {
            ret.append("\t").append(oi).append("\n");
        }
        ret.append("TOTAL: ").append(this.total).append("\n");
        return ret.toString();
    }

}