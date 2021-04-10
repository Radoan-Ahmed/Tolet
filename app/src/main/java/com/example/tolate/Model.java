package com.example.tolate;

public class Model {

    String location,phoneNum,price,rFValue,rSValue;

    public Model() {
    }

    public Model(String location, String phoneNum, String price, String rFValue, String rSValue) {
        this.location = location;
        this.phoneNum = phoneNum;
        this.price = price;
        this.rFValue = rFValue;
        this.rSValue = rSValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getrFValue() {
        return rFValue;
    }

    public void setrFValue(String rFValue) {
        this.rFValue = rFValue;
    }

    public String getrSValue() {
        return rSValue;
    }

    public void setrSValue(String rSValue) {
        this.rSValue = rSValue;
    }
}
