/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajaya.picoyplaca.view;

import com.cajaya.picoyplaca.controller.PredictorController;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cajh1
 */
public class PredictorForm extends JFrame {

    private final PredictorController controller;
    
    private JTextField plateField;
    private JTextField dateField;
    private JTextField timeField;
    private JButton checkButton;
    private JButton clearButton; // Nuevo botón agregado

    public PredictorForm(PredictorController controller) {
        this.controller = controller;
        setupUI();
    }

    private void setupUI() {
        setTitle("Pico y Placa Predictor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null); //Center
        setLayout(new GridLayout(4, 2, 10, 15)); //4 by 2 grid

        //first row
        add(new JLabel("  Plate (e.g., ABC-1234):"));
        plateField = new JTextField();
        add(plateField);

        //second row
        add(new JLabel("  Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        add(dateField);

        //third row
        add(new JLabel("  Time (HH:MM):"));
        timeField = new JTextField();
        add(timeField);

        //fourth row
        clearButton = new JButton("Clear Fields"); // Reemplazamos el espacio en blanco por el botón secundario
        add(clearButton);
        
        checkButton = new JButton("Check Circulation");
        add(checkButton);

        // Asignación de acciones a los botones
        checkButton.addActionListener(e -> processPrediction());
        clearButton.addActionListener(e -> clearFields());
    }

    private void processPrediction() {
        String plate = plateField.getText().trim();
        String date = dateField.getText().trim();
        String time = timeField.getText().trim();

        // 1. VALIDACIÓN DE INTERFAZ (Front-end)
        if (plate.isEmpty() || date.isEmpty() || time.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "⚠️ Please fill in all fields before checking.", 
                    "Missing Information", 
                    JOptionPane.WARNING_MESSAGE);
            return; // Detiene la ejecución aquí mismo si faltan datos
        }

        // 2. VALIDACIÓN DE NEGOCIO (Llamada al controlador)
        String resultMessage = controller.checkCirculation(plate, date, time);

        int messageType = resultMessage.contains("CAN circulate") && !resultMessage.contains("CAN'T") 
                          ? JOptionPane.INFORMATION_MESSAGE 
                          : JOptionPane.WARNING_MESSAGE;

        JOptionPane.showMessageDialog(this, resultMessage, "Prediction Result", messageType);
    }
    
    // Método auxiliar para limpiar los campos
    private void clearFields() {
        plateField.setText("");
        dateField.setText("");
        timeField.setText("");
        plateField.requestFocus(); // Devuelve el cursor al primer campo por comodidad
    }
}