/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import java.util.Scanner;
/**
 *
 * @author aniee
 */
public class VistaSistema {
    private Scanner teclado;

    public VistaSistema() {
        this.teclado = new Scanner(System.in);
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public String leerDatos(String etiqueta) {
        System.out.print("Ingrese " + etiqueta + ": ");
        return teclado.nextLine();
    }
}
