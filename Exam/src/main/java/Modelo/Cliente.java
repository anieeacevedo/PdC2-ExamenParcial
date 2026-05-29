/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author aniee
 */
public class Cliente {
    private String ruc;
    private String razonSocial;
    private String email;
    private String contacto;
    private String telefono;
    private String clave;
    private Rubro rubro;
    
    // Gestión del almacenamiento interno en formato de Arreglo
    private Oferta[] ofertas;
    private int contadorOfertas;

    public Cliente(String ruc, String razonSocial, String email, String contacto, String telefono, String clave, Rubro rubro) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.email = email;
        this.contacto = contacto;
        this.telefono = telefono;
        this.clave = clave;
        this.rubro = rubro;
        this.ofertas = new Oferta[100];
        this.contadorOfertas = 0;
    }

    public boolean agregarOferta(Oferta oferta) {
        if (contadorOfertas >= ofertas.length) {
            return false;
        }
        ofertas[contadorOfertas] = oferta;
        contadorOfertas++;
        return true;
    }

    public boolean eliminarOferta(Oferta oferta) {
        for (int i = 0; i < contadorOfertas; i++) {
            if (ofertas[i] == oferta) {
                for (int j = i; j < contadorOfertas - 1; j++) {
                    ofertas[j] = ofertas[j + 1];
                }
                ofertas[contadorOfertas - 1] = null;
                contadorOfertas--;
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        Oferta[] activas = new Oferta[contadorOfertas];
        System.arraycopy(ofertas, 0, activas, 0, contadorOfertas);
        return activas;
    }

    public String getEmail() { return email; }
    public String getClave() { return clave; }
    public String getRazonSocial() { return razonSocial; }
}
