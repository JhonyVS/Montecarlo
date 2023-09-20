/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.montecarlo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Jon
 */
public class GraficoPoligonoFrecuenciasCards extends JFrame{
    private Cards cards;

    public GraficoPoligonoFrecuenciasCards(String titulo,int veces) {
        
        super(titulo);
        cards = new Cards();
        int expo = 1;
        // Crear un conjunto de datos de frecuencias
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double valor;
        System.out.println("N \t\t\t Probabilidad");
        while(expo <= veces){
            valor = cards.reyesJuntos((int)Math.pow(10, expo));
            //System.out.print(valor+" ");
            dataset.addValue(valor, "Frecuencias", (int)Math.pow(10, expo)+"");
            expo++;
        }


        // Crear el gráfico de polígono de frecuencias
        JFreeChart chart = ChartFactory.createLineChart(
                titulo,
                "Resultados "+veces,
                "Porcentajes",
                dataset,
                PlotOrientation.VERTICAL,
                true, // Incluir leyenda
                true,
                false
        );

        // Personalizar el gráfico (opcional)
        Plot plot = chart.getPlot();
        plot.setOutlineVisible(false); // Ocultar el borde del gráfico

        // Agregar el gráfico a un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1100, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraficoPoligonoFrecuenciasCards demo = new GraficoPoligonoFrecuenciasCards("Gráfico de Polígono de Frecuencias de Cartas ",6);
            demo.pack();
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null);
            demo.setVisible(true);
        });
    }
}
