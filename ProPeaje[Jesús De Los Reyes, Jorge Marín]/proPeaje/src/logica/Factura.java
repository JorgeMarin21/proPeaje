/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Calendar;


public class Factura {
    protected Calendar fecha;
    protected String placa;
    protected String tVehiculo;
    protected String idConductor;
    protected boolean descuento;
    protected String sentido;
    protected int numFactura;

    public Factura() {
        
    }

    public Factura(Calendar fecha, String placa, String tVehiculo, String idConductor, boolean descuento, String sentido,int nf) {
        this.fecha = fecha;
        this.placa = placa;
        this.tVehiculo = tVehiculo;
        this.idConductor = idConductor;
        this.descuento = descuento;
        this.sentido = sentido;
        numFactura=nf;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTVehiculo() {
        return tVehiculo;
    }

    public void setTVehiculo(String tVehiculo) {
        this.tVehiculo = tVehiculo;
    }

    public String getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public int getNumFactura() {
        return numFactura;
    }

    @Override
    public String toString() {
        return "\nFACTURA DE VENTA N°: " + numFactura + "\nFECHA: " + fecha.getTime() + "\nIDENTIFICACIÓN DEL CONDUCTOR: " + idConductor + "\nPLACA: " + placa.toUpperCase() + "\nTIPO DE VEHÍCULO: " + tVehiculo.toUpperCase() + "\nSENTIDO: " + sentido.toUpperCase() + "\nDESCUENTO: " + ((descuento)?"SÍ":"NO")  ;
    }    
    
}
