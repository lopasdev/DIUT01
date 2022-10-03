/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iesalquerias.ejercicioMVP;

/**
 *
 * @author lopas
 */
public class Modelo {
    private int temp = (int) (Math.random()*100);
    
    
    public int up(int cantidad){
        return cantidad+temp;
    }
    
    public int down(int cantidad){
        return cantidad-temp;
    }
    
}

