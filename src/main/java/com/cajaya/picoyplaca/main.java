/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cajaya.picoyplaca;

import com.cajaya.picoyplaca.controller.PredictorController;
import com.cajaya.picoyplaca.service.PicoYPlacaEvaluator;
import com.cajaya.picoyplaca.service.analyzer.PlateAnalyzerFactory;
import com.cajaya.picoyplaca.service.time.DefaultHolidayProvider;
import com.cajaya.picoyplaca.view.PredictorForm;
import javax.swing.SwingUtilities;

/**
 *
 * @author cajh1
 */
public class main {

    public static void main(String[] args) {
        
        // 1. INYECCIÓN DE DEPENDENCIAS (Ensamblamos el sistema)
        PlateAnalyzerFactory factory = new PlateAnalyzerFactory();
        DefaultHolidayProvider holidayProvider = new DefaultHolidayProvider();
        PicoYPlacaEvaluator evaluator = new PicoYPlacaEvaluator(factory, holidayProvider);
        PredictorController controller = new PredictorController(evaluator);

        // 2. LANZAMOS LA INTERFAZ GRÁFICA
        // Usamos invokeLater para asegurar que la UI corra en el hilo correcto (buenas prácticas)
        SwingUtilities.invokeLater(() -> {
            PredictorForm form = new PredictorForm(controller);
            form.setVisible(true);
        });
    }
}
