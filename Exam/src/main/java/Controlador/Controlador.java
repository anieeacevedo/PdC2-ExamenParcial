/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import java.util.Date;
import Vista.VistaSistema;

/**
 *
 * @author aniee
 */
public class Controlador {
    private Cliente[] clientesEmpresas;
    private int totalEmpresas;
    private Postulante[] postulantesCandidatos;
    private int totalPostulantes;
    
    private VistaSistema vista;

    public Controlador(VistaSistema vista) {
        this.clientesEmpresas = new Cliente[100];
        this.totalEmpresas = 0;
        this.postulantesCandidatos = new Postulante[500];
        this.totalPostulantes = 0;
        this.vista = vista;
    }

    public void ejecutarPortal() {
        vista.mostrarMensaje("=== SISTEMA DE RECLUTAMIENTO TI (MVC + ARREGLOS) ===");

        Rubro rubroTI = new Rubro("Telecomunicaciones");
        Cliente empresaTI = new Cliente("20100077881", "SoftMarcos S.A.C.", "contacto@softmarcos.com", "Ing. Silva", "999111222", "admin123", rubroTI);
        clientesEmpresas[totalEmpresas++] = empresaTI;

        // Registro de Oferta con sus requisitos  ordenados
        Oferta vacanteJava = new Oferta("Desarrollador Backend Java", "Desarrollo de microservicios corporativos", "Sistemas", new Date(), new Date());
        vacanteJava.agregarRequisito(1, "Dominio del Lenguaje Java SE y POO.");
        vacanteJava.agregarRequisito(2, "Conocimiento del patrón arquitectónico MVC.");
        empresaTI.agregarOferta(vacanteJava);
        
        vista.mostrarMensaje("\n[INFO]: Empresa '" + empresaTI.getRazonSocial() + "' ha publicado la oferta: " + vacanteJava.getPuesto());

        // Simulación del Flujo de Registro de un Postulante
        vista.mostrarMensaje("\n--- Formulario de Registro de Candidato ---");
        String email = vista.leerDatos("Email para la cuenta");
        String nombres = vista.leerDatos("Nombres");
        String apellidos = vista.leerDatos("Apellidos");
        
        // Simulación de credencial autogenerada
        String claveAutogenerada = "TI_" + String.valueOf((int)(Math.random() * 9000 + 1000));
        
        Postulante nuevoCandidato = new Postulante(email, nombres, apellidos, "Av. Universitaria 1200", new Date(), claveAutogenerada);
        GradoEstudio bachiller = new GradoEstudio("Bachiller en Ingenieria de Sistemas");
        nuevoCandidato.asignarGradoEstudio(bachiller);
        
        postulantesCandidatos[totalPostulantes++] = nuevoCandidato;
        vista.mostrarMensaje("ÉXITO: Candidato registrado. Su clave autogenerada de acceso es: " + claveAutogenerada);

        vista.mostrarMensaje("\n--- Simulador de Postulación Automática ---");
        boolean exitoPostulacion = nuevoCandidato.postular(vacanteJava);
        
        if (exitoPostulacion) {
            vista.mostrarMensaje("¡Felicidades " + nuevoCandidato.getNombres() + "! Has postulado con éxito a la vacante: " + vacanteJava.getPuesto());
            
            // Muestra los requisitos de la vacante 
            vista.mostrarMensaje("Requisitos solicitados en orden:");
            for (Requisito req : vacanteJava.getRequisitos()) {
                vista.mostrarMensaje(" -> Orden [" + req.getOrden() + "] - " + req.getDescripcion());
            }
        }
    }
}
