/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.service.analyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 *
 * @author cajh1
 */
public class CarPlateAnalyzerTest {
    
    @ParameterizedTest
    @CsvSource({
        "ABC-1234, 4",
        "PBX-123, 3",
        "CC-001, 1" // Placa de 2 letras y 3 números
    })
    public void shouldReturnLastDigit(String testPlate, int expectedLastDigit){
        
        //Arrange
        CarPlateAnalyzer carPlateAnalyzer = new CarPlateAnalyzer();
                
        //Act
        
        int outputDigit = carPlateAnalyzer.getLastDigit(testPlate);
         
        //Assert
        
        assertEquals (expectedLastDigit, outputDigit);
    }
    
    @ParameterizedTest
    @CsvSource({
        "CD-1234, true",   // Cuerpo Diplomático
        "CC-987, true",    // Cuerpo Consular
        "ATA-1234, false", // Empieza con AT pero no tiene el guion (Particular)
        "PBX-1234, false"  // Particular normal
    })
    public void shouldExempt(String testPlate, boolean expectedIsExempt){
        
        //Arrange
        CarPlateAnalyzer carPlateAnalyzer = new CarPlateAnalyzer();
                
        //Act
        
        boolean outputIsExempt = carPlateAnalyzer.isExempt(testPlate);
         
        //Assert
        
        assertEquals (expectedIsExempt, outputIsExempt);
    }
    
    
}
