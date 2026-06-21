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
        
        // --- CASOS LUNES (Placas 1 y 2) ---
        "ABC-1231, 2026-06-22, 07:30, false", // Auto termina en 1 (hora pico mañana) -> NO circula
        "XYZ-9872, 2026-06-22, 17:30, false", // Auto termina en 2 (hora pico tarde) -> NO circula
        "AA-121C, 2026-06-22, 08:00, false",  // MOTO termina en 1 (hora pico) -> NO circula
        "ABC-1233, 2026-06-22, 07:30, true",  // Auto termina en 3 (le toca martes) -> SÍ circula
        
        // --- CASOS DE LÍMITES EXACTOS DE TIEMPO (Edge Cases) ---
        "ABC-1234, 2026-06-23, 05:59, true",  // Martes, placa 4. Un minuto antes -> SÍ circula
        "ABC-1234, 2026-06-23, 06:00, false", // Martes, placa 4. Exactamente al inicio -> NO circula
        "ABC-1234, 2026-06-23, 09:30, false", // Martes, placa 4. Exactamente al final -> NO circula
        "ABC-1234, 2026-06-23, 09:31, true",  // Martes, placa 4. Un minuto después -> SÍ circula
        "ABC-1234, 2026-06-23, 16:00, false", // Martes, placa 4. Exactamente inicio tarde -> NO circula
        "ABC-1234, 2026-06-23, 20:00, false", // Martes, placa 4. Exactamente fin tarde -> NO circula
        "ABC-1234, 2026-06-23, 20:01, true",  // Martes, placa 4. Un minuto después tarde -> SÍ circula
        
        // --- OTROS DÍAS PARA COBERTURA TOTAL ---
        "QWE-1235, 2026-06-24, 08:00, false", // Miércoles, placa 5 -> NO circula
        "RTY-4568, 2026-06-25, 18:00, false", // Jueves, placa 8 -> NO circula
        "UBN-9010, 2026-06-26, 08:00, false"  // Viernes, placa 0 -> NO circula
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
