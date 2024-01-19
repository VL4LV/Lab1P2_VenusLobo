/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_venuslobo;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Lab1P2_VenusLobo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int opc = 0; 
        
        while(opc != 4){
            System.out.println("---REGISTRO DE USUARIOS---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar todo");
            System.out.println("3. Listar por dominio");
            System.out.print("Que desea realizar: ");
            opc = entrada.nextInt();
            
            switch (opc) {
                case 1:
                    entrada.nextLine();
                    
                    //NOMBRE
                    System.out.print("Ingrese su nombre: ");
                    String nombre = entrada.nextLine();
                    
                    //APELLIDO
                    System.out.println("Ingrese su apellido: ");
                    String apellido = entrada.nextLine();
                    
                    
                    
                    break;
                case 2: 
                    break; 
                case 3: 
                    break; 
                    
                case 4: 
                    System.out.println("Gracias por usar el programa de VLLV. ");
                    break; 
                default:
                    System.out.println("Opcion invalida");
            }
            
        }
    }
    
}
