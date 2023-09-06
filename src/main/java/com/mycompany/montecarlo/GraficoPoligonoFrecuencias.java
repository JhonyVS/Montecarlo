/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.montecarlo;

/**
 *
 * @author Jon
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class GraficoPoligonoFrecuencias extends JFrame {

    private EbrioAleatorio ea;

    public GraficoPoligonoFrecuencias(String titulo,int iteraciones) {
        
        super(titulo);
        ea = new EbrioAleatorio();

        // Crear un conjunto de datos de frecuencias
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int cont = 1;
        int contSi=0;
        int valor;
        while(cont <= iteraciones){
            boolean estaADosCuadras = ea.aDosCuadras(10);
            if(estaADosCuadras){
                contSi++;
            }
            //System.out.print("contsi:"+contSi +" cont:"+cont);
            valor = (int)(((double)contSi / (double)cont)*100);
            System.out.print(valor+" ");
            dataset.addValue(valor, "Frecuencias", cont+"");
            cont++;
            ea.reestablecerPosicion();
        }


        // Crear el gráfico de polígono de frecuencias
        JFreeChart chart = ChartFactory.createLineChart(
                titulo,
                "Resultados "+iteraciones,
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
            GraficoPoligonoFrecuencias demo = new GraficoPoligonoFrecuencias("Gráfico de Polígono de Frecuencias",50);
            demo.pack();
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null);
            demo.setVisible(true);
        });
    }
}

