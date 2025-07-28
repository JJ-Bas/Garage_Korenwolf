package com.novi.garage_korenwolf.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("WORK")
public class WorkPerformed extends JobItem {

    private double workTime;

}
