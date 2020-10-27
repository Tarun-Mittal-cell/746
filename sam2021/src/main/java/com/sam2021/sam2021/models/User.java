package com.sam2021.sam2021.models;

import javax.security.auth.login.AccountExpiredException;

public class User {
    private String ftname;
    private String ltname;
    private String email;
    private String phonenumber;
    private String affiliation;
    private String password;
    private AccountType accountType;

    public User(String ftname, String ltname, String email, String phonenumber, String affiliation, String password, AccountType accountType){
        
    }
}

enum AccountType{
    Chairman,
    Member,
    Author
}