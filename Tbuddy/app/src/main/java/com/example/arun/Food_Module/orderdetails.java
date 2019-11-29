package com.example.arun.Food_Module;

public class orderdetails {
    String item,orderprice,noq,email;

        public int opprice;

    public orderdetails() {

    }

    public orderdetails(String item, String orderprice, String noq, String email)
    {
        this.item = item;
        this.orderprice = orderprice;
        this.noq = noq;
        this.email=email;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getNoq() {
        return noq;
    }

    public void setNoq(String noq) {
        this.noq = noq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
