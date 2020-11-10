package com.sam2021.sam2021.models.Enums;

public enum NotificationTypeEnum {
    Event("Event"),
    Notification("Notification");

    private String notiftype;
    private NotificationTypeEnum(String notiftype) {
        this.notiftype = notiftype;
    }
    @Override
    public String toString(){
        return notiftype;
    }
}
