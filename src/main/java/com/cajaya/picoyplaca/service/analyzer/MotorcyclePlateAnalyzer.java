/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.analyzer;

import com.cajaya.picoyplaca.model.VehicleType;

/**
 *
 * @author cajh1
 */
public class MotorcyclePlateAnalyzer implements PlateAnalyzer{

    @Override
    public int getLastDigit(String plate) {
        char lastDigitStr = plate.charAt(plate.length()-2);
        int lastDigit = Character.getNumericValue(lastDigitStr);
        return lastDigit;
    }

    @Override
    public boolean isExempt(String plateNumber) {
        return false;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MOTORCYCLE;
    }
    
}
