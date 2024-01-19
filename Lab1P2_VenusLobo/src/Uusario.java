
import java.util.Calendar;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Uusario {
    //Atributos 
    String nombre; 
    String apellido; 
    String fechaNacimiento; 
    String correo; 
    String contrasena; 

    //Constructor
    public Uusario(String nombre, String apellido, Calendar fechaNacimiento, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
     
    
    
    
    
}
