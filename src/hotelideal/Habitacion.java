/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

/**
 *
 * @author nancy
 */
public class Habitacion {
    private int id_habitacion;
    private int numHabitacion;
    private int piso;
    private boolean estado;
    private TipoDeHabitacion id_tipodehabitacion;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Habitacion(int numHabitacion, int piso, boolean estado, TipoDeHabitacion id_tipodehabitacion) {
        this.numHabitacion = numHabitacion;
        this.piso = piso;
        this.estado = estado;
        this.id_tipodehabitacion = id_tipodehabitacion;
    }

    public Habitacion(int id_habitacion, int numHabitacion, int piso, boolean estado, TipoDeHabitacion id_tipodehabitacion) {
        this.id_habitacion = id_habitacion;
        this.numHabitacion = numHabitacion;
        this.piso = piso;
        this.estado = estado;
        this.id_tipodehabitacion = id_tipodehabitacion;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoDeHabitacion getId_tipodehabitacion() {
        return id_tipodehabitacion;
    }

    public void setId_tipodehabitacion(TipoDeHabitacion id_tipodehabitacion) {
        this.id_tipodehabitacion = id_tipodehabitacion;
    }
    
    
    
    
    
}
