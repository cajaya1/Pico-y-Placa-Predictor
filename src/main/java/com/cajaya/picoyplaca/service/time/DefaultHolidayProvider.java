/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.time;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 *
 * @author cajh1
 */
public class DefaultHolidayProvider implements HolidayProvider {
    
    
    
    @Override
    public boolean isHoliday(LocalDate date) {
        
        MonthDay mdDate = MonthDay.from(date);
               
        for (HolidayList holidays : HolidayList.values()){
            
            if (holidays.getMonthDay().equals(mdDate)){
                return true;
            }
        
        }
        return false;
    }
    
}
