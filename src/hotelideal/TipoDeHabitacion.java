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
public class TipoDeHabitacion {
    
    private  int id_tipodehabitacion;
    private int codigo;
    private String tipo;
    private int cantmaxpersonas;
    private  int cantcamas;
    private String tipodecama;
    private Double precioxnoche;

    public TipoDeHabitacion() {
    }

    public TipoDeHabitacion(int id_tipodehabitacion) {
        this.id_tipodehabitacion = id_tipodehabitacion;
    }

    public TipoDeHabitacion(int codigo, String tipo, int cantmaxpersonas, int cantcamas, String tipodecama, Double precioxnoche) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.cantmaxpersonas = cantmaxpersonas;
        this.cantcamas = cantcamas;
        this.tipodecama = tipodecama;
        this.precioxnoche = precioxnoche;
    }

    public int getId_tipodehabitacion() {
        return id_tipodehabitacion;
    }

    public void setId_tipodehabitacion(int id_tipodehabitacion) {
        this.id_tipodehabitacion = id_tipodehabitacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantmaxpersonas() {
        return cantmaxpersonas;
    }

    public void setCantmaxpersonas(int cantmaxpersonas) {
        this.cantmaxpersonas = cantmaxpersonas;
    }

    public int getCantcamas() {
        return cantcamas;
    }

    public void setCantcamas(int cantcamas) {
        this.cantcamas = cantcamas;
    }

    public String getTipodecama() {
        return tipodecama;
    }

    public void setTipodecama(String tipodecama) {
        this.tipodecama = tipodecama;
    }

    public Double getPrecioxnoche() {
        return precioxnoche;
    }

    public void setPrecioxnoche(Double precioxnoche) {
        this.precioxnoche = precioxnoche;
    }
    
    
    
    
}
