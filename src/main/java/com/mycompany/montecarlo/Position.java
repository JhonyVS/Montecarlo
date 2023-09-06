/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.montecarlo;

/**
 *
 * @author Jon
 */
class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        x=0;
        y=0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXUp() {
        x++;
    }
    public void setXDown() {
        x--;
    }

    public void setYUp() {
        y++;
    }
    public void setYDown() {
        y--;
    }

    @Override
    public String toString() {
        return "Posicion:["+x+","+y+"]";
    }

    public void reestablecer() {
        x=0;
        y=0;
    }
    
}
