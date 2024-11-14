package es.uco.practica2.display;

import java.io.*;
import java.util.*;
import es.uco.practica2.business.*;

public class MainJugadores {
	public static void main(String[] args) 
	{
		Properties propiedades = new Properties();
        
        // Cargar propiedades del fichero
        try (InputStream input = new FileInputStream("config.properties")) 
        {
            propiedades.load(input);
        } catch (IOException ex) 
        {
            System.out.println("Error al cargar las propiedades: " + ex.getMessage());
            return;
        }
		
        GestorJugadores gestorJugadores = new GestorJugadores(propiedades.getProperty("JugadoresFile"));
        
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!salir) 
        {
            System.out.println("1. Añadir Jugador");
            System.out.println("2. Modificar informacion Jugador");
            System.out.println("3. Listar Jugadores");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) 
            {
                case 1:
                    // Lógica de gestión de Jugadores
                	Date date = new Date();
                	
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese sus apellidos: ");
                    String apellidos = scanner.nextLine();

                    System.out.print("Ingrese su correo electrónico: ");
                    String correo = scanner.nextLine();

                    System.out.print("Ingrese su DNI: ");
                    String dni = scanner.nextLine();
                	
                	Jugador jugador = new Jugador(nombre, apellidos, date, correo, dni);
                	
                    gestorJugadores.addUser(gestorJugadores.getPath(), jugador); // Llamada al main de gestión de Jugadores
                    break;
                case 2:
                    // Lógica de gestión de pistas
                	System.out.println("Introduzca el DNI de la persona a modificar");
                	String dniM = scanner.nextLine();
                    gestorJugadores.modUser(gestorJugadores.getPath(), dniM); // Llamada al main de gestión de pistas
                    break;
                case 3:
                    // Lógica de gestión de reservas
                    gestorJugadores.listUsers(gestorJugadores.getPath());
                    break;
                case 0:
                    salir = true; // Salir del bucle
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }
}
