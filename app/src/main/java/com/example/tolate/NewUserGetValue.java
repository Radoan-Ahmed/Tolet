package com.example.tolate;

public class NewUserGetValue {

    String price,phoneNum,location,rFValue,rSValue;

    public NewUserGetValue() {
    }

    public NewUserGetValue(String price, String phoneNum, String location, String rFValue, String rSValue) {
        this.price = price;
        this.phoneNum = phoneNum;
        this.location = location;
        this.rFValue = rFValue;
        this.rSValue = rSValue;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
