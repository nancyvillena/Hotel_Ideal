/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.time.LocalDate;

/**
 *
 * @author nancy
 */
public class Reserva {
    private int id_reserva;
    private int cantPersonas;
    private LocalDate fechaEntrada;
     private LocalDate fechaSalida;
     private Double importeTotal;
    private boolean estado_reserva;
     private LocalDate fechaDeReserva;
      private Habitacion habitacion;
    private Huesped huesped;

    public Reserva() {
    }

    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Reserva(int cantPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, Double importeTotal, boolean estado_reserva, LocalDate fechaDeReserva, Habitacion habitacion, Huesped huesped) {
        this.cantPersonas = cantPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estado_reserva = estado_reserva;
        this.fechaDeReserva = fechaDeReserva;
        this.habitacion = habitacion;
        this.huesped = huesped;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public boolean isEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(boolean estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public LocalDate getFechaDeReserva() {
        return fechaDeReserva;
    }

    public void setFechaDeReserva(LocalDate fechaDeReserva) {
        this.fechaDeReserva = fechaDeReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
    
    
    
}
