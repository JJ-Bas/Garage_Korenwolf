package com.novi.garage_korenwolf.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("WORK")
public class WorkPerformed extends JobItem {

    private double workTimeInMinutes;
    private String notes;
    private boolean warranty;


    // getter & setters

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

