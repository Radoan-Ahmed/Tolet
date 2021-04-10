package com.example.tolate;

public class User {

    public String fullName,lastName,phoneNumber,email,password,conPassword;

    public User() {
    }

    public User(String fullName, String lastName, String phoneNumber, String email, String password, String conPassword) {
        this.fullName = fullName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.conPassword = conPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConPassword() {
        return conPassword;
    }

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }
}
