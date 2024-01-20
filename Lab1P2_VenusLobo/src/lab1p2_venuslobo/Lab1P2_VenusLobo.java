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
            System.out.println();
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
                                System.out.println("El correo solo puede ser de los dominios permitidos y contener “-“, “_”, “&”, “$” y “%”.");
                            }

                        } while (!correoValido(correo));

                        // Contraseña
                        do {
                            System.out.print("Ingrese una contraseña: ");
                            contrasena = entrada.nextLine();

                            if (!contrasenaValida(contrasena)) {
                                System.out.println("La contraseña solo puede contener una letra mayúscula, una letra minúscula, un número y un símbolo (“!“, “?”,“<”, “>”, “$” y “%”).");
                            }

                        } while (!contrasenaValida(contrasena));

                        //Agregar al array list la informacion 
                        Uusario usu = new Uusario(nombre, apellido, fecha, correo, contrasena);
                        usuario.add(usu);
                    }
                    break;

                case 2:
                    System.out.println("---LISTADO COMPLETO DE USUARIOS---");
                    for (int i = 0; i < usuario.size(); i++) {
                        Uusario usuarioActual = usuario.get(i);

                        System.out.println("Nombre: " + usuarioActual.getNombre());
                        System.out.println("Apellido: " + usuarioActual.getApellido());

                        Date newFech = new Date();
                        int edadEnMilisegundos = (int) (newFech.getTime() - usuarioActual.getFechaNacimiento().getTime());
                        int edadEnSegundos = edadEnMilisegundos / 1000;
                        int edadEnDias = (int) (edadEnSegundos / (24 * 3600));
                        int edadEnAnos = edadEnDias / 365;
                        int diasRestantes = edadEnDias % 365;

                        int meses = diasRestantes / 30;
                        int dias = diasRestantes % 30;

                        //edad exacta
                        System.out.println("Edad: " + edadEnAnos + " años, " + meses + " meses, " + dias + " días");
                        System.out.println("Correo Electrónico: " + usuarioActual.getCorreo());
                        System.out.println("Contraseña: " + usuarioActual.getContrasena());
                        System.out.println("--------------------------");
                    }
                    break;

                case 3:
                    String dominiosPermitidos = "gmail.com,outlook.com,yahoo.com,icloud.com,protonmail.com,fastmail.com";

                    String[] dominiosArray = dominiosPermitidos.split(",");

                    //Copiar la misma logica del 2 
                    System.out.println("---LISTADO DE USUARIOS ORDENADO POR DOMINIO---");
                    for (String dominio : dominiosArray) {
                        for (Uusario usuarioActual : usuario) {
                            String correo = usuarioActual.getCorreo().toLowerCase();
                            if (correo.contains("@" + dominio)) {
                                System.out.println("Nombre: " + usuarioActual.getNombre());
                                System.out.println("Apellido: " + usuarioActual.getApellido());

                                Date newFech = new Date();
                                int edadEnMilisegundos = (int) (newFech.getTime() - usuarioActual.getFechaNacimiento().getTime());
                                int edadEnSegundos = edadEnMilisegundos / 1000;
                                int edadEnDias = (int) (edadEnSegundos / (24 * 3600));
                                int edadEnAnos = edadEnDias / 365;
                                int diasRestantes = edadEnDias % 365;

                                int meses = diasRestantes / 30;
                                int dias = diasRestantes % 30;

                                System.out.println("Edad: " + edadEnAnos + " años, " + meses + " meses, " + dias + " días");
                                System.out.println("Correo Electrónico: " + usuarioActual.getCorreo());
                                System.out.println("Contraseña: " + usuarioActual.getContrasena());
                                System.out.println("--------------------------");
                            }
                        }
                    }
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

        // Validar dominios 
        if (matcher.matches()) {
            String dominiosPermitidos = "gmail.com,outlook.com,yahoo.com,icloud.com,protonmail.com,fastmail.com";
            String[] dominiosArray = dominiosPermitidos.split(",");

            String[] partesCorreo = correo.split("@");
            if (partesCorreo.length == 2) {
                String dominio = partesCorreo[1].toLowerCase();

                for (String dominioPermitido : dominiosArray) {
                    if (dominio.equals(dominioPermitido)) {
                        return true;
                    }
                }
            }
        }

        return false;
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
