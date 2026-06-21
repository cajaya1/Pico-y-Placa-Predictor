/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.analyzer;

/**
 *
 * @author cajh1
 */
public class PlateAnalyzerFactory {
    private static final String regexCar = "^[a-zA-Z]{2,3}-\\d{3,4}$";
    private static final String regexMotorcycle = "^[a-zA-Z]{2}-\\d{3}[a-zA-Z]$";
    
    public PlateAnalyzer createAnalyzer(String plateNumber){
    
        if (plateNumber.matches(regexCar)){
            
            return new CarPlateAnalyzer();
        } else if(plateNumber.matches(regexMotorcycle)){
            
            return new MotorcyclePlateAnalyzer();
        }
        throw new IllegalArgumentException("The plate format is not a valid format");     
    }
    
}
