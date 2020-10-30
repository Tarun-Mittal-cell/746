package com.sam2021.sam2021.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//import com.sam2021.sam2021.validation.ValidPassword;


@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    @NotEmpty(message = "Password can not be empty")
    //@ValidPassword
    private String password;

    @NotNull(message = "Select a role")
    @Enumerated(EnumType.STRING)
    private AccountTypeEnum accountType;

    public User(){

    }

    public User(String ftname, String ltname, String email, String phonenumber, String affiliation, String password, AccountTypeEnum accountType) {
        this.ftname = ftname;
        this.ltname = ltname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.affiliation = affiliation;
        this.password = password;
        this.accountType = accountType;
    }

    //Getters

    public Long getId() {
        return id;
    }
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


    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }
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

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public boolean auth(String password){
        return this.password.equals(password);
    }
}

