/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
 
package com.mycompany.montecarlo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jon
 */
public class Montecarlo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraficoPoligonoFrecuencias demo = new GraficoPoligonoFrecuencias("Gráfico de Polígono de Frecuencias",50);
            demo.pack();
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null);
            demo.setVisible(true);
        });
        
    }
}
