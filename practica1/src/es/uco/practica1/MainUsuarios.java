package es.uco.practica1;

import java.io.*;
import java.util.*;

public class MainUsuarios 
{
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
		
        GestorUsuarios gestorUsuarios = new GestorUsuarios(propiedades.getProperty("usuariosFile"));
        
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!salir) 
        {
            System.out.println("1. Añadir usuario");
            System.out.println("2. Modificar informacion usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) 
            {
                case 1:
                    // Lógica de gestión de usuarios
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
                	
                    gestorUsuarios.addUser(gestorUsuarios.getPath(), jugador); // Llamada al main de gestión de usuarios
                    break;
                case 2:
                    // Lógica de gestión de pistas
                	System.out.println("Introduzca el DNI de la persona a modificar");
                	String dniM = scanner.nextLine();
                    gestorUsuarios.modUser(gestorUsuarios.getPath(), dniM); // Llamada al main de gestión de pistas
                    break;
                case 3:
                    // Lógica de gestión de reservas
                    gestorUsuarios.listUsers(gestorUsuarios.getPath());
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
