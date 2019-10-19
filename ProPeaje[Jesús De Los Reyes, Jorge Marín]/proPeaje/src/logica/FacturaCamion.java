/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Calendar;

/**
 *
 * @author Jesús De Los Reyes y Jorge Marín
 */
public class FacturaCamion extends Factura {
    
    private int cargaActual;
    private String descripCarga;
    private String detalleDestino;

    public FacturaCamion() {
    }

    public FacturaCamion(int cargaActual, String descripCarga, String detalleDestino, Calendar fecha, String placa, String tVehiculo, String idConductor, boolean descuento, String sentido,int nf) {
        super(fecha, placa, tVehiculo, idConductor, descuento, sentido,nf);
        this.cargaActual = cargaActual;
        this.descripCarga = descripCarga;
        this.detalleDestino = detalleDestino;
    }

    

    public int getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(int cargaActual) {
        this.cargaActual = cargaActual;
    }

    public String getDescripCarga() {
        return descripCarga;
    }

    public void setDescripCarga(String descripCarga) {
        this.descripCarga = descripCarga;
    }

    public String getDetalleDestino() {
        return detalleDestino;
    }

    public void setDetalleDestino(String detalleDestino) {
        this.detalleDestino = detalleDestino;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nCARGA ACTUAL: " + cargaActual + " Kg\nDESCRIPCION DE LA CARGA: " + descripCarga.toUpperCase() + "\nDETALLE DE DESTINO: " + detalleDestino.toUpperCase();
    }
    
    
    
}
