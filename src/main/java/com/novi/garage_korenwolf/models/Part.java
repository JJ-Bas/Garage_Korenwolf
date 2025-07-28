package com.novi.garage_korenwolf.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PART")
public class Part extends JobItem{

    private int quantity;

}
