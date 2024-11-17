package es.uco.practica2.display;

import java.util.*;
import java.io.*;
import java.util.Properties;

public class MainProgram {

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

        // Iniciar gestores
        //gestorUsuarios = new GestorUsuarios(propiedades.getProperty("usuariosFile"));
        //gestorPistas = new GestorPistas();
        //gestorReservas = new GestorReservas();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) 
        {
        	System.out.println("\n--- Menú principal ---");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Pistas");
            System.out.println("3. Gestión de Reservas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) 
            {
                case 1:
                    // Lógica de gestión de usuarios
                    MainJugadores.main(args); // Llamada al main de gestión de usuarios
                    break;
                case 2:
                    // Lógica de gestión de pistas
                    MainPistas.main(args); // Llamada al main de gestión de pistas
                    break;
                case 3:
                    // Lógica de gestión de reservas
                    MainReservas.main(args); // Llamada al main de gestión de reservas
                    break;
                case 0:
                    salir = true; // Salir del bucle
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }

        scanner.close();
        System.out.println("Saliendo de la aplicación.");
    }
}
