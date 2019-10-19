/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Jesús De Los Reyes y Jorge Marín
 */
public class Conductor {
    
    private String nombre;
    private String ident;
    private long telefono;
    private String ciudad;

    public Conductor() {
    }

    public Conductor(String nombre, String ident, long telefono, String ciudad) {
        this.nombre = nombre;
        this.ident = ident;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "NOMBRE: " + nombre.toUpperCase() + "\nIDENTIFICACIÓN: " + ident + "\nTELÉFONO: " + telefono + "\nCIUDAD: " + ciudad.toUpperCase() ;
    }
    
}
