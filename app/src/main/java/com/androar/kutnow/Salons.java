package com.androar.kutnow;

import java.io.Serializable;

public class Salons implements Serializable {

    public String advancedstyling;
    public String colouring;
    public String detans;
    public String facials;
    public String haircuts;
    public String logo;
    public String makeovers;
    public String manicure;
    public String salonName;
    public String pedicure;
    public String shopId;
    public String threading;
    public String waxing;

    public Salons() {
    }

    public Salons(String advancedstyling, String colouring, String detans, String facials, String haircuts, String logo, String makeovers, String manicure, String salonName, String pedicure, String shopId, String threading, String waxing) {
        this.advancedstyling = advancedstyling;
        this.colouring = colouring;
        this.detans = detans;
        this.facials = facials;
        this.haircuts = haircuts;
        this.logo = logo;
        this.makeovers = makeovers;
        this.manicure = manicure;
        this.salonName = salonName;
        this.pedicure = pedicure;
        this.shopId = shopId;
        this.threading = threading;
        this.waxing = waxing;
    }

    public String getAdvancedstyling() {
        return advancedstyling;
    }

    public void setAdvancedstyling(String advancedstyling) {
        this.advancedstyling = advancedstyling;
    }

    public String getColouring() {
        return colouring;
    }

    public void setColouring(String colouring) {
        this.colouring = colouring;
    }

    public String getDetans() {
        return detans;
    }

    public void setDetans(String detans) {
        this.detans = detans;
    }

    public String getFacials() {
        return facials;
    }

    public void setFacials(String facials) {
        this.facials = facials;
    }

    public String getHaircuts() {
        return haircuts;
    }

    public void setHaircuts(String haircuts) {
        this.haircuts = haircuts;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMakeovers() {
        return makeovers;
    }

    public void setMakeovers(String makeovers) {
        this.makeovers = makeovers;
    }

    public String getManicure() {
        return manicure;
    }

    public void setManicure(String manicure) {
        this.manicure = manicure;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public String getPedicure() {
        return pedicure;
    }

    public void setPedicure(String pedicure) {
        this.pedicure = pedicure;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getThreading() {
        return threading;
    }

    public void setThreading(String threading) {
        this.threading = threading;
    }

    public String getWaxing() {
        return waxing;
    }

    public void setWaxing(String waxing) {
        this.waxing = waxing;
    }
}
