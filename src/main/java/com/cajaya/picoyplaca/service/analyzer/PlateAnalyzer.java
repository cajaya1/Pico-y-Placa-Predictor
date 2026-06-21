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
public interface PlateAnalyzer {
    int getLastDigit(String plate);
    boolean isExempt (String plateNumber);
    VehicleType getVehicleType();
    
}
