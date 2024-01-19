/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_venuslobo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Lab1P2_VenusLobo {

    public static void main(String[] args) throws ParseException {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Uusario> usuario = new ArrayList<>();

        int opc = 0;

        while (opc != 4) {
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
                    System.out.print("Ingrese su apellido: ");
                    String apellido = entrada.nextLine();

                    //FECHA DE NACIMIENTO
                    System.out.print("Ingrese su fecha de nacimiento: ");
                    String fechaNacimiento = entrada.nextLine();
                    DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                    Date fecha = formatoFecha.parse(fechaNacimiento);

                    //Validar la fecha de nacimiento 
                    //CORREO
                    System.out.print("Ingrese correo electronico: ");
                    String correo = entrada.nextLine();

                    //CONTRASENA 
                    System.out.print("Ingrese una contraseñaÑ ");
                    String contrasena = entrada.nextLine();

                    //Agregar al array list la informacion 
                    Uusario usu = new Uusario(nombre, apellido, fecha, correo, contrasena);
                    usuario.add(usu);
                    break;

                case 2:
                    for (int i = 0; i < usuario.size(); i++) {
                        Uusario mascota = usuario.get(i);
                        System.out.println(mascota);
                    }

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
