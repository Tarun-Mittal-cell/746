package com.sam2021.sam2021.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {
    @NotNull
    @NotEmpty(message = "First name can not be empty")
    private String ftname;

    @NotNull
    @NotEmpty(message = "Last name can not be empty")
    private String ltname;

    @NotNull
    @Email(message = "Email can not be empty")
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @NotNull
    @NotEmpty(message = "Phone Number can not be empty")
    private String phonenumber;

    @NotNull
    @NotEmpty(message = "Affliliation can not be empty")
    private String affiliation;

    @NotNull
    @Size(min = 8, max = 20)
    @NotEmpty(message = "Password can not be empty")
    private String password;

    @NotNull
    @NotEmpty(message = "Confirm Password can not be empty")
    private String confirmpassword;

    @NotNull(message = "Select a role")
    private AccountType accountType;

    public User(){

    }

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