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
public class CarPlateAnalyzer implements PlateAnalyzer{

    @Override
    public int getLastDigit(String plate) {
        char lastDigitStr = plate.charAt(plate.length()-1);
        int lastDigit = Character.getNumericValue(lastDigitStr);
        return lastDigit;
    }

    @Override
    public boolean isExempt(String plateNumber) {
        return plateNumber.startsWith("CD-")||
               plateNumber.startsWith("CC-")||
               plateNumber.startsWith("OI-")||
               plateNumber.startsWith("AT-")||
               plateNumber.startsWith("IT-");
                   
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
    
}
