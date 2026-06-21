/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.model;

/**
 *
 * @author cajh1
 */
public class Plate {
    private final String number;
    private final VehicleType type;
    private final int lastDigit;

    public String getNumber() {
        return number;
    }

    public VehicleType getType() {
        return type;
    }

    public int getLastDigit() {
        return lastDigit;
    }

    @Override
    public String toString() {
        return "Plate{" + "number=" + number + ", type=" + type + ", lastDigit=" + lastDigit + '}';
    }

    public Plate(String number, VehicleType type, int lastDigit) {
        this.number = number;
        this.type = type;
        this.lastDigit = lastDigit;
    }
    
    
    
}
