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
public class Camion extends Vehiculo{
    
    private int numEjes;
    private int capCarga;
    private boolean seguro;

    public Camion() {
    }

    public Camion(String placa, String marca, int modelo, Calendar tecnoMec,int numEjes, int capCarga, boolean seguro) {
        super(placa,marca,modelo,tecnoMec);
        this.numEjes = numEjes;
        this.capCarga = capCarga;
        this.seguro = seguro;
    }

    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    public int getCapCarga() {
        return capCarga;
    }

    public void setCapCarga(int capCarga) {
        this.capCarga = capCarga;
    }

    public boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    @Override
    public String toString() {
        return super.toString()+ "NÚMERO DE EJES: " + numEjes + "\nCAPACIDAD DE CARGA: " + capCarga + " Kg\nSEGURO: "+((seguro)?"SÍ":"NO" )+"\n";
    }
    
}