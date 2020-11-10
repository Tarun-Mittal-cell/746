package com.sam2021.sam2021.models.Enums;

public enum userinterestEnum {
    Member("Member"),
    Chairman("Chairman"),
    Author("Author"),
    Onaction("on action"),
    Onupload("On upload"),
    Manual("Manual");

    private String userinter;
    private userinterestEnum(String userinter) {
        this.userinter = userinter;
    }
    @Override
    public String toString(){
        return userinter;
    }
}
