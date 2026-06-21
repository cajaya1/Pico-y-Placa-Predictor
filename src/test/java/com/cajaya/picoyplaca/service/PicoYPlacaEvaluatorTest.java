/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service;

import com.cajaya.picoyplaca.service.analyzer.PlateAnalyzerFactory;
import com.cajaya.picoyplaca.service.time.DefaultHolidayProvider;
import com.cajaya.picoyplaca.service.time.HolidayProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author cajh1
 */
public class PicoYPlacaEvaluatorTest {
    
    @ParameterizedTest
    @CsvSource({
        //Plate, Date, Time, Expected Result
        
        // --- MONDAY CASES (Plates ending in 1 and 2) ---
        "ABC-1231, 2026-06-22, 07:30, false", // Car ends in 1 (morning peak hour) -> CANNOT circulate
        "XYZ-9872, 2026-06-22, 17:30, false", // Car ends in 2 (afternoon peak hour) -> CANNOT circulate
        "AA-121C, 2026-06-22, 08:00, false",  // MOTORCYCLE ends in 1 (morning peak hour) -> CANNOT circulate
        "ABC-1233, 2026-06-22, 07:30, true",  // Car ends in 3 (restricted on Tuesday) -> CAN circulate
        
        // --- EDGE CASES FOR EXACT TIME LIMITS (Updated Schedule) ---
        "ABC-1234, 2026-06-23, 06:59, true",  // Tuesday, plate 4. One minute before morning restriction -> CAN circulate
        "ABC-1234, 2026-06-23, 07:00, false", // Tuesday, plate 4. Exactly at morning start time -> CANNOT circulate
        "ABC-1234, 2026-06-23, 09:30, false", // Tuesday, plate 4. Exactly at morning end time -> CANNOT circulate
        "ABC-1234, 2026-06-23, 09:31, true",  // Tuesday, plate 4. One minute after morning restriction -> CAN circulate
        "ABC-1234, 2026-06-23, 16:00, false", // Tuesday, plate 4. Exactly at afternoon start time -> CANNOT circulate
        "ABC-1234, 2026-06-23, 19:30, false", // Tuesday, plate 4. Exactly at afternoon end time -> CANNOT circulate
        "ABC-1234, 2026-06-23, 19:31, true",  // Tuesday, plate 4. One minute after afternoon restriction -> CAN circulate
        
        // --- OTHER DAYS FOR FULL COVERAGE ---
        "QWE-1235, 2026-06-24, 08:00, false", // Wednesday, plate 5 -> CANNOT circulate
        "RTY-4568, 2026-06-25, 18:00, false", // Thursday, plate 8 -> CANNOT circulate
        "UBN-9010, 2026-06-26, 08:00, false"  // Friday, plate 0 -> CANNOT circulate
    })
    public void shouldReturnTrueWhenTheVehicleCanCirculate(String testPlate, LocalDate testDate, LocalTime testTime, boolean expectedCanCirculate){
        
    //arrange
    PlateAnalyzerFactory factory = new PlateAnalyzerFactory();
    HolidayProvider holidayProvider = new DefaultHolidayProvider();
    PicoYPlacaEvaluator evaluator = new PicoYPlacaEvaluator (factory, holidayProvider); 
    
    //act
    boolean actualResult = evaluator.canCirculate (testPlate, testDate, testTime);
    
    
    
    //assert
    assertEquals (expectedCanCirculate, actualResult,
            "Fallo al evaluar la regla regular de Pico y Placa para la placa: " + testPlate + " a las " + testTime); 
     
    }
}
