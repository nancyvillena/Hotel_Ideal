/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import javax.swing.JOptionPane;

/**
 *
 * @author nancy
 */
public class HotelIdeal {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        // TODO code application logic here
        
        
        Conexion conexion=new Conexion();
        
       TipoDeHabitacion t1= new TipoDeHabitacion();
    TipoDeHabitacionData tdh= new  TipoDeHabitacionData(conexion);
  //t1=  td.buscarTipoDeHabitacion(2);
      
    Habitacion h1= new Habitacion();
    HabitacionData hd=new HabitacionData(conexion);
    //hd.buscarHabitacion(45);
    //h1 = hd.buscarIdHabitacion(2);
    h1= hd.buscarHabitacion(45);
    System.out.println("ID:"+ h1.getId_habitacion()+", Piso:  "+ h1.getPiso()+" , Estado:"+
            h1.isEstado()+  ", Tipo de Habitacion:"+ h1.getId_tipodehabitacion()+"" );
            
     
     
       /* h1.setNumHabitacion(450);
        h1.setPiso(4);
        h1.setEstado(false);
       h1.setId_tipodehabitacion(t1);
       
       hd.actualizarHabitacion(h1); 
       //hd.guardarHabitacion(h1);*/
       
    
   
    /*t1.setCodigo(5645);
    t1.setTipo("Suite de Lujo");
    t1.setCantmaxpersonas(2);
    t1.setCantcamas(1);
    t1.setTipodecama("Queen");
    t1.setPrecioxnoche(2500.00);

     TipoDeHabitacionData td= new  TipoDeHabitacionData(con);
     td.guardarTipoDeHabitacion(t1);*/
    
 // TipoDeHabitacionData td= new  TipoDeHabitacionData(con);
 // td.buscarTipoDeHabitacion(1);
   // td.guardarTipoDeHabitacion(t1);
    
        /*Cursada c1 = new Cursada();
      c1.setAlumno(a1);
      c1.setMateria(m1);
      c1.setNota(8.50);*/

    // MateriaData md=new MateriaData(con);
    //m1= md.buscarMateria(2);
     //AlumnoData ad= new AlumnoData(con);
    //  ad.guardarAlumno(a1);
       //a1= ad.buscarAlumno(1);
    }
}
