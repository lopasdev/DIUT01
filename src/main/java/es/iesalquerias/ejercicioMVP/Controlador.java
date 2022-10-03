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
public class Controlador {
    private Modelo modelo;
    private Vista vista;
    
    public Controlador(){
        modelo = new Modelo();
        vista = new Vista(this);
    }
    
    public void initView(String[] args){
        vista.water(args);
    }
    
    void upTemp(int temp){
        int newTemp = modelo.up(temp);
        vista.showTemp(newTemp);
    }
    
    void downTemp(int temp){
        int newTemp = modelo.down(temp);
        vista.showTemp(newTemp);
    }
  
}
