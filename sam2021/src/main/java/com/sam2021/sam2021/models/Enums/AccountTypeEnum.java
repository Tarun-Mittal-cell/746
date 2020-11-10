package com.sam2021.sam2021.models.Enums;

public enum AccountTypeEnum{
    Chairman("Chairman"),
    Member("Member"),
    Author("Author");

    private String accotype;
    private AccountTypeEnum(String acctype) {
        this.accotype = acctype;
    }
    @Override
    public String toString(){
        return accotype;
    }
}
