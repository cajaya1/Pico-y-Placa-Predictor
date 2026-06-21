/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.time;

import java.time.LocalDate;

/**
 *
 * @author cajh1
 */
public interface HolidayProvider {
    boolean isHoliday (LocalDate date);
}
