package com.example.tolate;

public class GetValue {

    String txtValue,firstValue,secondValue,phone;

    public GetValue() {
    }

    public GetValue(String txtValue, String firstValue, String secondValue, String phone) {
        this.txtValue = txtValue;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.phone = phone;
    }

    public String getTxtValue() {
        return txtValue;
    }

    public void setTxtValue(String txtValue) {
        this.txtValue = txtValue;
    }

    public String getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
