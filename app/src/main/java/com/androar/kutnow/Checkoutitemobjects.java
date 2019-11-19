package com.androar.kutnow;

import java.io.Serializable;

public class Checkoutitemobjects implements Serializable {

    public String checkoutShopName;
    public String checkoutServicePrice;
    public String checkoutServiceName;

    public Checkoutitemobjects() {
    }

    public Checkoutitemobjects(String checkoutShopName, String checkoutServicePrice, String checkoutServiceName) {
        this.checkoutShopName = checkoutShopName;
        this.checkoutServicePrice = checkoutServicePrice;
        this.checkoutServiceName = checkoutServiceName;
    }

    public String getCheckoutShopName() {
        return checkoutShopName;
    }

    public void setCheckoutShopName(String checkoutShopName) {
        this.checkoutShopName = checkoutShopName;
    }

    public String getCheckoutServicePrice() {
        return checkoutServicePrice;
    }

    public void setCheckoutServicePrice(String checkoutServicePrice) {
        this.checkoutServicePrice = checkoutServicePrice;
    }

    public String getCheckoutServiceName() {
        return checkoutServiceName;
    }

    public void setCheckoutServiceName(String checkoutServiceName) {
        this.checkoutServiceName = checkoutServiceName;
    }
}
