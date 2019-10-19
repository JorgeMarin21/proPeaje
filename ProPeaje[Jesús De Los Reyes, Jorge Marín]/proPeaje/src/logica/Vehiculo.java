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
public class Vehiculo {
    
    protected String placa;
    protected String marca;
    protected int modelo;
    protected Calendar tecnoMec;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, int modelo, Calendar tecnoMec) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tecnoMec = tecnoMec;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public Calendar getTecnoMec() {
        return tecnoMec;
    }

    public void setTecnoMec(Calendar tecnoMec) {
        this.tecnoMec = tecnoMec;
    }

    @Override
    public String toString() {
        return "PLACA: " + placa.toUpperCase() + "\nMARCA: " + marca.toUpperCase() + "\nMODELO: " + modelo + "\nFECHA DE TECNOMECÁNICA:\n" + tecnoMec.getTime()+"\n";
    }
    
    
    
    
}
