/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.time;
import java.time.MonthDay;
import java.time.Month;

/**
 *
 * @author cajh1
 */
public enum HolidayList {
    ANIO_NUEVO(Month.JANUARY, 1),
    DIA_TRABAJADOR(Month.MAY, 1),
    BATALLA_PICHINCHA(Month.MAY, 24),
    DIA_INDEPENDENCIA(Month.AUGUST, 10),
    INDEPENDENCIA_GUAYAQUIL(Month.OCTOBER, 9),
    DIA_DIFUNTOS(Month.NOVEMBER, 2),
    INDEPENDENCIA_CUENCA(Month.NOVEMBER, 3),
    FUNDACION_QUITO(Month.DECEMBER, 6),
    NAVIDAD(Month.DECEMBER, 25);

    private final MonthDay monthDay;

    HolidayList(Month month, int day) {
        this.monthDay = MonthDay.of(month, day);
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }    
    
}
