package com.androar.kutnow;

import java.io.Serializable;

public class Salons implements Serializable {

    public String servicename;
    public String price;

    public Salons() {
    }

    public Salons(String servicename, String price) {
        this.servicename = servicename;
        this.price = price;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
