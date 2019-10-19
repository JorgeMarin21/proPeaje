/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Jesús De Los Reyes y Jorge Marín
 */
public class AdminPeaje {
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Conductor> listaConductores;
    private ArrayList<Factura> listaFacturas;

    public AdminPeaje() {
        listaVehiculos=new ArrayList();
        listaConductores= new ArrayList();
        listaFacturas= new ArrayList();       
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public ArrayList<Conductor> getListaConductores() {
        return listaConductores;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }
    
    
    
    
    
    
    public int buscarVehiculo(String placa){
        for(Vehiculo v:listaVehiculos){
            if(placa.equalsIgnoreCase(v.getPlaca()))
                return listaVehiculos.indexOf(v);
        }    
        return -1;
    }
    
    public int buscarConductor(String id){
        for(Conductor c:listaConductores){
            if(id.equalsIgnoreCase(c.getIdent()))
                return listaConductores.indexOf(c);
        }    
        return -1;
    }
    
    public int buscarFactura(int num){
        for(Factura f:listaFacturas){
            if(num==f.getNumFactura())
                return listaFacturas.indexOf(f);
        }    
        return -1;
    }
    
    public boolean buscarAuto(String placa){
        for(Vehiculo v:listaVehiculos){
            if((!(v instanceof Camion)) && placa.equalsIgnoreCase(v.getPlaca()))
                return true;
        }    
        
        return false;
    }
    
    public boolean buscarCamion(String placa){
        for(Vehiculo v:listaVehiculos){
            if( v instanceof Camion && placa.equalsIgnoreCase(v.getPlaca()))
                return true;
        }    
        
        return false;
    }
    
    public double calcularPeaje(String placa, String sentido){
        double valor=5700;
        if(buscarAuto(placa)){
            if(sentido.equalsIgnoreCase("entrada"))
                return valor+5000;
            else
                return valor+3500;
            
        }else
            return -1;
    }
    
    public double calcularPeaje(String placa, String sentido, int cantidadActual){
        double valor=12500;
        int pos=buscarVehiculo(placa);
        Vehiculo v;
        if(pos!=-1){
            if(buscarCamion(placa)){              
                v=listaVehiculos.get(pos);
                double capCarga=((Camion)v).getCapCarga();
                double numEjes=((Camion)v).getNumEjes();
                
                if(sentido.equalsIgnoreCase("entrada"))
                    valor+=6500;
                else
                    valor+=5000;
                
                
                if(capCarga-cantidadActual<0){
                    valor+=((cantidadActual-capCarga)*7000);
                }
               
                valor+=cantidadActual*2500;
                valor+=numEjes*5000;
                
                return valor;

            }else
                return -1;
        }else
            return -1;
    }
    
    public boolean aplicarDescuento(String id, String sentido,Calendar fecha){
        
        for(Factura f:listaFacturas){
            if(!f.isDescuento())
                if(id.equalsIgnoreCase(f.idConductor))
                    if(fecha.getTime().getDate()==f.fecha.getTime().getDate())
                        if(fecha.getTime().getMonth()==f.fecha.getTime().getMonth())
                            if(fecha.getTime().getYear()==f.fecha.getTime().getYear())
                                if(!(sentido.equalsIgnoreCase(f.sentido)))
                                    return true;
        }
        
        return false;
    }
    
    public boolean agregarVehiculo(Vehiculo v){
        if(buscarVehiculo(v.placa)==-1){
            listaVehiculos.add(v);
            return true;
        }
        return false;
    }
    
    public boolean agregarConductor(Conductor c){
        if(buscarConductor(c.getIdent())==-1){
            listaConductores.add(c);
            return true;
        }
        return false;
    }
    
    public boolean agregarFactura(Factura f){
        if(buscarFactura(f.numFactura)==-1){
            listaFacturas.add(f);
            return true;
        }
        return false;
    }
    
    public String consultarVehiculoEsp(String placa){
        int pos=buscarVehiculo(placa);
        Vehiculo v;
        if(pos!=-1){
           v=listaVehiculos.get(pos);
            if(v instanceof Camion)
               return ((Camion)v).toString();
            else
               return v.toString();
        }
        
        return null;
    }
    
    public int contarCamionIn(){
        int cont=0;
        for(Factura f:listaFacturas){
            if(f.tVehiculo.equalsIgnoreCase("Camion"))
                if(f.sentido.equalsIgnoreCase("entrada"))
                    cont++;
        }
        return cont;
    }
    
    public int contarCamionOut(){
        int cont=0;
        for(Factura f:listaFacturas){
            if(f.tVehiculo.equalsIgnoreCase("Camion"))
                if(f.sentido.equalsIgnoreCase("salida"))
                    cont++;
        }
        return cont;
    }
    
    public int contarAutomovilIn(){
        int cont=0;
        for(Factura f:listaFacturas){
            if(f.tVehiculo.equalsIgnoreCase("automovil"))
                if(f.sentido.equalsIgnoreCase("entrada"))
                    cont++;
        }
        return cont;
    }
    
    public int contarAutomovilOut(){
        int cont=0;
        for(Factura f:listaFacturas){
            if(f.tVehiculo.equalsIgnoreCase("automovil"))
                if(f.sentido.equalsIgnoreCase("salida"))
                    cont++;
        }
        return cont;
    }
    
    public String imprimirFactura(Factura f){
        
        StringBuilder sb = new StringBuilder();
        sb.append(f.toString());
        
        Vehiculo v = listaVehiculos.get(buscarVehiculo(f.placa));
        if(v instanceof Camion){
            int numEjes=((Camion) v).getNumEjes();
            int totalNumEjes=numEjes*5000;
            int cantActual= ((FacturaCamion)f).getCargaActual();
            int capCarga=((Camion) v).getCapCarga();
            int totalCant=cantActual*2500;
            int totalCarga=0;
            
            if(cantActual-capCarga>0){
                totalCarga=(cantActual-capCarga)*7000;
            }
            
            sb.append("\n");
            sb.append("\nPRECIO BASE: $12500");
            sb.append("\nDESTINO: ");
            sb.append((f.sentido.equalsIgnoreCase("entrada"))?"$6500":"$5000");
            sb.append("\nNÚMERO DE EJES: $5000 x ");
            sb.append(numEjes);
            sb.append(" = $");
            sb.append(totalNumEjes);
            sb.append("\nCANTIDAD : $2500 x ");
            sb.append(cantActual);
            sb.append(" = $");
            sb.append(totalCant);
            if(cantActual-capCarga>0){
                sb.append("\nKILOS DE EXCESO : $7000 x ");
                sb.append(cantActual-capCarga);
                sb.append(" = $");
                sb.append(totalCarga);
            }
        }else{
            sb.append("\n");
            sb.append("\nPRECIO BASE: $5700");
            sb.append("\nDESTINO: ");
            sb.append((f.sentido.equalsIgnoreCase("entrada"))?"$5000":"$3500");
        }
        double valor;
        valor=calcularTotalPeaje(f);
        sb.append("\nVALOR DEL PEAJE: $" );
        sb.append(valor);
        return sb.toString();
    }
    
    
    public double calcularTotalPeaje(Factura f){
        double valor;
        if(f instanceof FacturaCamion){
            valor=calcularPeaje(f.getPlaca(), f.getSentido(), ((FacturaCamion)f).getCargaActual() );
        }
        else{
            valor=calcularPeaje(f.getPlaca(), f.getSentido());
        }    
        
        if(aplicarDescuento(f.getIdConductor(), f.getSentido(), f.getFecha())){
            valor=valor*0.5;
        }
        return valor;
    }
    
    
    public String mostrarFactura(Calendar fecha){
        StringBuilder sb = new StringBuilder();
        for(Factura fact:listaFacturas){
            if(fecha.getTime().getDate()==fact.fecha.getTime().getDate())
                if(fecha.getTime().getMonth()==fact.fecha.getTime().getMonth())
                    if(fecha.getTime().getYear()==fact.fecha.getTime().getYear()){
                        sb.append(imprimirFactura(fact));
                        sb.append("\n____________________________________________\n");
                    }
        }
                
        
        return sb.toString();
    }
    
    public String mostrarFactura(int num){
        int pos;
        Factura f;
        pos=buscarFactura(num);
        if(pos==-1){
            return null;
        }
        else{
            f=listaFacturas.get(pos);
            return imprimirFactura(f);
        }
    }
    
    public String mostrarInfoDriver(String id){
        for(Conductor c: listaConductores){
            if(c.getIdent().equalsIgnoreCase(id)){
                return c.toString();
            }
        }
        return null;
    }
    
    public double mostrarGanancias(){
        double acum=0;
        
        for(Factura f: listaFacturas){
            acum+=calcularTotalPeaje(f);
        }
        
        return acum;
    }
    
    public double mostrarGanancias(Calendar fecha){
        double acum=0;
        
        for(Factura fact: listaFacturas){
            if(fecha.getTime().getDate()==fact.fecha.getTime().getDate())
                if(fecha.getTime().getMonth()==fact.fecha.getTime().getMonth())
                    if(fecha.getTime().getYear()==fact.fecha.getTime().getYear())   
                        acum+=calcularTotalPeaje(fact);
            
        }
        return acum;
    }
}
