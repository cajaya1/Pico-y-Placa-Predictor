/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.time;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 *
 * @author cajh1
 */
public class DefaultHolidayProviderTest {

    @ParameterizedTest
    @CsvSource({
        "2026, 12, 25, true",   // Navidad (Feriado)
        "2026, 5, 1, true",     // Día del Trabajo (Feriado)
        "2026, 11, 2, true",    // Día de los Difuntos (Feriado)
        "2026, 6, 22, false",   // Día normal en junio (No feriado)
        "2026, 10, 15, false"   // Día normal en octubre (No feriado)
    })
    
    public void shouldIdentifyHolidays(int year, int month, int day, boolean expectedResult){
    //arrange
    DefaultHolidayProvider holidayProvider = new DefaultHolidayProvider();
    LocalDate testDate = LocalDate.of(year, month, day);
    //act
    boolean outputHolidayProvider = holidayProvider.isHoliday(testDate);
    //assert
    assertEquals(expectedResult, outputHolidayProvider, 
            "Fallo al evaluar la fecha: " + testDate);
    }
}
