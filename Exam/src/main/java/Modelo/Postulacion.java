/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author aniee
 */
public class Postulacion {
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;
    private Oferta oferta;

    public Postulacion(Oferta oferta) {
        this.fecha = new Date(); // Fecha y hora del momento de la postulación
        this.anulado = false;
        this.fechaAnulacion = null;
        this.oferta = oferta;
    }

    public void anular() {
        this.anulado = true;
        this.fechaAnulacion = new Date();
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public Oferta getOferta() {
        return oferta;
    }
}