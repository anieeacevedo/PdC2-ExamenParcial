/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.Controlador;
import Vista.VistaSistema;
/**
 *
 * @author aniee
 */
public class Main {
    public static void main(String[] args) {
        VistaSistema vista = new VistaSistema();
    
        Controlador controlador = new Controlador(vista);
        
        controlador.ejecutarPortal();
    }
}
