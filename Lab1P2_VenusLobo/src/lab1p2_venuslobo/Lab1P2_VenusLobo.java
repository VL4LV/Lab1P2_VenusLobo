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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.println("4. Salir del programa");
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
                    System.out.print("Ingrese su fecha de nacimiento (yyyy/MM/dd): ");
                    String fechaNacimiento = entrada.nextLine();
                    DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                    Date fecha = formatoFecha.parse(fechaNacimiento);

                    Date newFecha = new Date();

                    //Validar la fecha de nacimiento 
                    int resta = (int) newFecha.getYear() - (int) fecha.getYear();

                    if (resta < 12) {
                        System.out.println("Usted no tiene la edad adecuada.");
                    } else {

                        String correo;
                        String contrasena;

                        //CORREO
                        do {
                            System.out.print("Ingrese correo electrónico: ");
                            correo = entrada.nextLine();

                            if (!correoValido(correo)) {
                                System.out.println("El correo solo puede contener “-“, “_”, “&”, “$” y “%”");
                            }

                        } while (!correoValido(correo));

                        //CONTRASENA 
                        do {
                            System.out.print("Ingrese una contraseña: ");
                            contrasena = entrada.nextLine();

                            if (!contrasenaValida(contrasena)) {
                                System.out.println("La contraseña solo puede contener (“!“, “?”,“<”, “>”, “$” y “%”).");
                            }

                        } while (!contrasenaValida(contrasena));

                        //Agregar al array list la informacion 
                        Uusario usu = new Uusario(nombre, apellido, fecha, correo, contrasena);
                        usuario.add(usu);
                    }
                    break;

                case 2:
                    for (int i = 0; i < usuario.size(); i++) {
                        Uusario mascota = usuario.get(i);
                        System.out.print(mascota);
                        imprimirFecha(mascota.getFechaNacimiento());
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

    public static boolean correoValido(String correo) {
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static void imprimirFecha(Date fecha) {
        System.out.println((fecha.getYear() + 1900) + "/" + (fecha.getMonth() + 1) + "/" + fecha.getDate() + "}");
    }

    public static boolean contrasenaValida(String contrasena) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!\\?<>$%])[A-Za-z\\d!\\?<>$%]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();
    }
}
