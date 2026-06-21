/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service;

import com.cajaya.picoyplaca.service.analyzer.PlateAnalyzer;
import com.cajaya.picoyplaca.service.analyzer.PlateAnalyzerFactory;
import com.cajaya.picoyplaca.service.time.DefaultHolidayProvider;
import com.cajaya.picoyplaca.service.time.HolidayProvider;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.MONDAY;

/**
 *
 * @author cajh1
 */
public class PicoYPlacaEvaluator {
    
    private final PlateAnalyzerFactory plateFactory;
    private final HolidayProvider holidayProvider;

    PicoYPlacaEvaluator(PlateAnalyzerFactory factory, HolidayProvider holidayProvider) {
        this.plateFactory = factory;
        this.holidayProvider = holidayProvider;
    }
    
    
    private boolean isRestrictedTime(LocalTime time){
    
        LocalTime morningStart = LocalTime.of(6, 0);
        LocalTime morningEnd = LocalTime.of(9, 30);
        LocalTime afternoonStart = LocalTime.of(16, 0);
        LocalTime afternoonEnd = LocalTime.of(20, 0);
    
        
        boolean isMorningBusyHours = !time.isBefore(morningStart) && !time.isAfter(morningEnd);
        boolean isAfternoonBusyHours = !time.isBefore(afternoonStart) && !time.isAfter(afternoonEnd);
        return isMorningBusyHours || isAfternoonBusyHours;
    }
    
    private boolean isRestrictedDayByDigit (int lastDigit, DayOfWeek day){
        return switch (day) {
            case MONDAY -> lastDigit == 1 || lastDigit ==2;
            case TUESDAY -> lastDigit == 3 || lastDigit ==4;
            case WEDNESDAY -> lastDigit == 5 || lastDigit ==6;
            case THURSDAY -> lastDigit == 7 || lastDigit ==8;
            case FRIDAY -> lastDigit == 9 || lastDigit ==0;
            default -> false;
        };
        
    
    
    
    }

    boolean canCirculate(String testPlate, LocalDate testDate, LocalTime testTime) {
        PlateAnalyzer analyzer = plateFactory.createAnalyzer(testPlate);
        int lastDigit = analyzer.getLastDigit(testPlate);
        DayOfWeek day = testDate.getDayOfWeek();
        if ((day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) || holidayProvider.isHoliday(testDate)){
            return true;
        
        }
        
        if (analyzer.isExempt(testPlate)){
            return true;
        }
        
        if (!isRestrictedTime(testTime)||!isRestrictedDayByDigit(lastDigit, day)){
        
            return true;
        }
        
        return false;
    }
    
    
    
}
