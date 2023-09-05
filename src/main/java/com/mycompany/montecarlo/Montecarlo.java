/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.montecarlo;

/**
 *
 * @author Jon
 */
public class Montecarlo {

    public static void main(String[] args) {
        EbrioAleatorio ea = new EbrioAleatorio();
        Position pos = ea.salirDelBar(10);
        System.out.print("El ebrio esta a dos cuadras? "+ea.aDosCuadras()+" ");
        System.out.println(ea);
    }
}
