package es.uco.practica2.display;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import es.uco.practica2.business.JugadorDTO;
import es.uco.practica2.business.GestorJugadores;

public class MainJugadores {
    public static void main(String[] args) {
        Properties propiedades = new Properties();
        GestorJugadores gestorJugadores = new GestorJugadores(); // Inicia el gestor de jugadores

        // Cargar propiedades del fichero
        try (InputStream input = new FileInputStream("config.properties")) {
            propiedades.load(input);
        } catch (IOException ex) {
            System.out.println("Error al cargar las propiedades: " + ex.getMessage());
            return;
        }

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("1. Añadir Jugador");
            System.out.println("2. Modificar información Jugador");
            System.out.println("3. Listar Jugadores");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Lógica para añadir un jugador
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese sus apellidos: ");
                    String apellidos = scanner.nextLine();

                    System.out.print("Ingrese su correo electrónico: ");
                    String correo = scanner.nextLine();

                    System.out.print("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
                    String fechaNac = scanner.nextLine();
                    Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);

                    System.out.print("Ingrese la fecha de inscripción (dd/MM/yyyy): ");
                    String fechaInscripcion = scanner.nextLine();
                    Date fechaIns = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInscripcion);

                    JugadorDTO jugador = new JugadorDTO(0, nombre, apellidos, fechaNacimiento, fechaIns, correo);

                    try {
                        gestorJugadores.addJugador(jugador);
                        System.out.println("Jugador añadido con éxito.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    // Lógica para modificar un jugador
                    System.out.print("Introduzca el ID del jugador a modificar: ");
                    int idM = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    JugadorDTO jugadorParaModificar = gestorJugadores.getJugador(idM);

                    if (jugadorParaModificar != null) {
                        System.out.print("Nombre (actual " + jugadorParaModificar.getNombre() + "): ");
                        jugadorParaModificar.setNombre(scanner.nextLine());

                        System.out.print("Apellidos (actual " + jugadorParaModificar.getApellidos() + "): ");
                        jugadorParaModificar.setApellidos(scanner.nextLine());

                        System.out.print("Correo electrónico (actual " + jugadorParaModificar.getCorreo_electronico() + "): ");
                        jugadorParaModificar.setCorreo_electronico(scanner.nextLine());

                        try {
                            gestorJugadores.updateJugador(jugadorParaModificar);
                            System.out.println("Jugador modificado con éxito.");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;
                case 3:
                    // Listar jugadores
                    try {
                        for (JugadorDTO j : gestorJugadores.getAllJugadores()) {
                            System.out.println(j);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    salir = true; // Salir del bucle
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
        scanner.close();
    }
}
