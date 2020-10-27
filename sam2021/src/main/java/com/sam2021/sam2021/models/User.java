package com.sam2021.sam2021.models;

public class User {
    private String ftname;
    private String ltname;
    private String email;
    private String phonenumber;
    private String affiliation;
    private String password;
    private String confirmpassword;
    private AccountType accountType;

    public User(String ftname, String ltname, String email, String phonenumber, String affiliation, String password, String confirmpassword,
            AccountType accountType) {
        this.ftname = ftname;
        this.ltname = ltname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.affiliation = affiliation;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.accountType = accountType;
    }

    //Getters
    public String getFtname() {
        return ftname;
    }

    public String getLtname() {
        return ltname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    //Setters
    public void setFtname(String ftname) {
        this.ftname = ftname;
    }

    public void setLtname(String ltname) {
        this.ltname = ltname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}

enum AccountType{
    Chairman,
    Member,
    Author
}