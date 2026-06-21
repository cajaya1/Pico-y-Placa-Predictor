/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.controller;

import com.cajaya.picoyplaca.service.PicoYPlacaEvaluator;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author cajh1
 */
public class PredictorController {
    private final PicoYPlacaEvaluator evaluator;
    public PredictorController(PicoYPlacaEvaluator evaluator){
        this.evaluator = evaluator;
    }
    
    public String checkCirculation(String plate, String dateStr, String timeStr){
    try {
    
        LocalDate date = LocalDate.parse(dateStr);
        LocalTime time = LocalTime.parse(timeStr);
        
        boolean canCirculate = evaluator.canCirculate(plate, date, time);
        
        if(canCirculate){
            return "The vehicle with the plate "+plate+" CAN circulate at the selected date";
            
        }else {
            return "The vehicle with the plate "+plate+" CAN'T circulate at the selected date";
        }
    
    }catch(DateTimeParseException e){
        return "Formate error, make sure you are using the fformat: YYYY-MM-DD for the date and HH:MM for the time";
    }catch(IllegalArgumentException e){
        return "Wrong Plate Format";
    }catch(Exception e){
        return "unspected error" + e.getMessage();}   
    }
}
        
    
    


