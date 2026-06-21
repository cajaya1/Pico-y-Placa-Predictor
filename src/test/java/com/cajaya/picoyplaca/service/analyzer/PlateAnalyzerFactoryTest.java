/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
/**
 *
 * @author cajh1
 */
public class PlateAnalyzerFactoryTest {
    
    @Test
    public void shouldReturnCarAnalyzerWhenPlateHasValidFormat() {
    
    // Arrange  
    PlateAnalyzerFactory factory = new PlateAnalyzerFactory ();
    String validCarPlate = "ABC-1234";
    
    // Act
            
    PlateAnalyzer result = factory.createAnalyzer(validCarPlate);
    
    //Assert: I'm Making sure that the returned object is an instance of CarPlateAnalyzer
    assertInstanceOf(CarPlateAnalyzer.class, result, "Should return a CarPlateAnalyzer with the format CC-1234");
    
    }
    
    @Test
    public void shouldReturnMotorcycleAnalyzerWhenPlateHasValidFormat() {
    
    // Arrange  
    PlateAnalyzerFactory factory = new PlateAnalyzerFactory ();
    String validMotorcyclePlate = "AB-123C";
    
    // Act
            
    PlateAnalyzer result = factory.createAnalyzer(validMotorcyclePlate);
    
    //Assert: I'm Making sure that the returned object is an instance of CarPlateAnalyzer
    assertInstanceOf(MotorcyclePlateAnalyzer.class, result, "Should return a MotorcyclePlateAnalyzer with the format AB-123C");
    
    }
    
    
    @ParameterizedTest
    @ValueSource(strings = {
        "ABCD-123-1",   // Wrong Format
        "A-1234",       // Just 1 letter
        "ABC-12",       // Just 2 numbers
        "ABC-12345",    // Too much numbers
        "123-ABC",      // Inverted
        "texto-invalido"  // Random text
    })
    public void shouldThrowExceptionWhenPlateFormatIsInvalid(String invalidPlate) {
        // Arrange
        PlateAnalyzerFactory factory = new PlateAnalyzerFactory();
        
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createAnalyzer(invalidPlate);
        }, "Should throw an exception for invalid plate formats");
    }
}
