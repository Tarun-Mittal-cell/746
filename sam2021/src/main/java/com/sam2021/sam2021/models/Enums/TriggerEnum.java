package com.sam2021.sam2021.models.Enums;

public enum TriggerEnum {
    StartofDay("Start of Day"),
    StartofWeek("StartofWeek"),
    Weekdays("Weekdays"),
    Onaction("On action"),
    Manual("Manual");

    private String trigger;
    private TriggerEnum(String trigger) {
        this.trigger = trigger;
    }
    @Override
    public String toString(){
        return trigger;
    }
}
