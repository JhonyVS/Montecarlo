/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.montecarlo;

import java.util.Random;

/**
 *
 * @author Jon
 */
public class EbrioAleatorio {
    private Position pos;

    public EbrioAleatorio() {
        pos= new Position();
    }
    
    public boolean aDosCuadras(int numeroDeCalles){
        salirDelBar(numeroDeCalles);
        int distancia = Math.abs(pos.getX())+Math.abs(pos.getY());
        return distancia<=2;
    }
    
    private void salirDelBar(int intentos){
        Random r = new Random();
        int numAleatorio;
        while(intentos > 1){
            numAleatorio = r.nextInt(100);
            if(numAleatorio <25){
                moverDerecha();
            }else if(numAleatorio<50){
                moverIzquierda();
            }else if(numAleatorio<75){
                moverArriba();
            }else
                moverAbajo();
            intentos--;
        }
        
    }

    @Override
    public String toString() {
        return "El Ebrio se encuentra en: "+pos;
    }
    
    private void moverDerecha(){
        pos.setXUp();
    }
    private void moverIzquierda(){
        pos.setXDown();
    }
    private void moverArriba(){
        pos.setYUp();
    }
    private void moverAbajo(){
        pos.setYDown();
    }
    public void reestablecerPosicion(){
        pos.reestablecer();
    }
    public Position getPosicion(){
        return pos;
    }
}
