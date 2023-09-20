
package com.mycompany.montecarlo;

import java.util.Random;

/**
 *
 * @author Jon
 */
public class Cards {
    
    /**
    * ♠=Spades
    * ♥=Hearts
    * ♣=Clubs
    * ♦=Diamonds
    **/
    public static final String[] barajaOrdenada = { 
        "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS",
        "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
        "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC",
        "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD"
    };
    public String[] getCopiaBaraja(){
        return Cards.barajaOrdenada;
    }
    public Cards(){
        
    }
    public double reyesJuntos(int veces){
        double res;
        int cont = 0;// contador cuantas veces se repite el pátron
        // hacemos un recorrido en funcion a alas veces que deseamos hacer la simulacion
        for(int i = 0;i<veces;i++){
            String[] barajaBarajada = desordenarBaraja(getCopiaBaraja());
            //Recorremos la baraja hasta encontrar algun patron de reyes juntos
            for (int j = 0; j < barajaBarajada.length-1; j++) {
                if(barajaBarajada[j].charAt(0)== 'K' && (barajaBarajada[j+1].charAt(0)== 'K')) {
                    //si es que encontramos ese patron, lo contabilizamos en la variable cont
                    cont++;
                    j=barajaBarajada.length;
                    //mostrarBaraja(barajaBarajada);
                }
            }
        }
        res = ((double)cont / (double)veces);
        System.out.println(veces+" \t                  \t" +res+" \t");
        return res;
    }

    private String[] desordenarBaraja(String[] copiaBaraja) {
        String[] res = copiaBaraja;
        Random r = new Random();
        int numAleatorio;
        String aux;
        for (int i = 0; i < res.length; i++) {
            numAleatorio = r.nextInt(res.length-1);
            aux = res[numAleatorio];
            res[numAleatorio] = res [i];
            res[i] = aux;            
        }
        return res;
    }
    public static void main(String[] args) {
        Cards c = new Cards();
        c.reyesJuntos(10);
        c.reyesJuntos(100);
        c.reyesJuntos(1000);
        c.reyesJuntos(10000);
        c.reyesJuntos(100000);
        c.reyesJuntos(1000000);
        c.reyesJuntos(10000000);
        c.reyesJuntos(100000000);
        
    }

    private void mostrarBaraja(String[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+",");
        }
        System.out.println();
    }
}
