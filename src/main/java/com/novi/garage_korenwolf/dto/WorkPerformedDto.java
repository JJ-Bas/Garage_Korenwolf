package com.novi.garage_korenwolf.dto;

public class WorkPerformedDto extends JobItemDto {

    private double workTimeInMinutes;
    private String notes;
    private boolean warranty;

    // getters & setters

    public double getWorkTimeInMinutes() {
        return workTimeInMinutes;
    }

    public void setWorkTimeInMinutes(double workTimeInMinutes) {
        this.workTimeInMinutes = workTimeInMinutes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
}
