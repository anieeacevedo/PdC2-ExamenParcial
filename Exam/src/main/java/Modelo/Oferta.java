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
public class Oferta {
    private String puesto;
    private String descripcion;
    private String area;
    private Date fechaInicio;
    private Date fechaTermino;
    
    private Requisito[] requisitos;
    private int contadorRequisitos;

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.requisitos = new Requisito[50]; // Capacidad inicial máxima para el arreglo fixo
        this.contadorRequisitos = 0;
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        if (contadorRequisitos >= requisitos.length) {
            return false;
        }
        // Insertamos el requisito manteniendo la abstracción del orden dado
        requisitos[contadorRequisitos] = new Requisito(orden, descripcion);
        contadorRequisitos++;
        return true;
    }

    public Requisito[] getRequisitos() {
        // Retornamos un arreglo exactamente de la dimensión de los elementos registrados
        Requisito[] actuales = new Requisito[contadorRequisitos];
        System.arraycopy(requisitos, 0, actuales, 0, contadorRequisitos);
        return actuales;
    }

    public boolean eliminarRequisito(int orden) {
        for (int i = 0; i < contadorRequisitos; i++) {
            if (requisitos[i].getOrden() == orden) {
                // Desplazamos los elementos para mantener la continuidad del arreglo en memoria
                for (int j = i; j < contadorRequisitos - 1; j++) {
                    requisitos[j] = requisitos[j + 1];
                }
                requisitos[contadorRequisitos - 1] = null;
                contadorRequisitos--;
                return true;
            }
        }
        return false;
    }

    public String getPuesto() {
        return puesto;
    }
}