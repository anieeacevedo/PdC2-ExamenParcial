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
public class Postulante {
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;
    private GradoEstudio gradoEstudio;
    
    // Gestión del almacenamiento en Arreglo de Postulaciones
    private Postulacion[] postulaciones;
    private int contadorPostulaciones;

    public Postulante(String email, String nombres, String apellidos, String direccion, Date nacimiento, String clave) {
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.clave = clave;
        this.postulaciones = new Postulacion[200]; // Límite amplio de postulaciones en arreglo
        this.contadorPostulaciones = 0;
    }

    public boolean asignarGradoEstudio(GradoEstudio grado) {
        this.gradoEstudio = grado;
        return true;
    }

    public boolean postular(Oferta oferta) {
        if (contadorPostulaciones >= postulaciones.length) {
            return false;
        }
        postulaciones[contadorPostulaciones] = new Postulacion(oferta);
        contadorPostulaciones++;
        return true;
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        for (int i = 0; i < contadorPostulaciones; i++) {
            if (postulaciones[i] == postulacion) {
                postulaciones[i].anular();
                return true;
            }
        }
        return false;
    }

    public Postulacion[] getPostulaciones() {
        Postulacion[] lista = new Postulacion[contadorPostulaciones];
        System.arraycopy(postulaciones, 0, lista, 0, contadorPostulaciones);
        return lista;
    }

    public String getEmail() { return email; }
    public String getClave() { return clave; }
    public String getNombres() { return nombres; }
}
