/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author cajh1
 */
public class MotorcyclePlateAnalyzerTest {
    
    @ParameterizedTest
    @CsvSource({
        "AB-123C, 3",
        "XY-987Z, 7",
        "QQ-000A, 0"
    })
    public void shouldReturnLastDigit(String testPlate, int expectedLastDigit){
        
        //Arrange
        MotorcyclePlateAnalyzer motorcyclePlateAnalyzer = new MotorcyclePlateAnalyzer();
                
        //Act
        
        int outputDigit = motorcyclePlateAnalyzer.getLastDigit(testPlate);
         
        //Assert
        
        assertEquals (expectedLastDigit, outputDigit);
    }
    
    @ParameterizedTest
    @CsvSource({
        "AB-123C, false",
        "CD-123C, false" // even if it starts with CD (which is an exempt case in cars
                         // it should not be exempt since it is a cycle
    })
    public void shouldExempt(String testPlate, boolean expectedIsExempt){
        
        //Arrange
        MotorcyclePlateAnalyzer motorcyclePlateAnalyzer = new MotorcyclePlateAnalyzer();
        //Act
        
        boolean outputIsExempt = motorcyclePlateAnalyzer.isExempt(testPlate);
         
        //Assert
        
        assertEquals (expectedIsExempt, outputIsExempt);
    }
    
    
}

