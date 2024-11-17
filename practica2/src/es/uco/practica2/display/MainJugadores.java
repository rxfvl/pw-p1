package es.uco.practica2.display;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import es.uco.practica2.business.*;
import java.time.LocalDate;
import java.text.ParseException;

public class MainJugadores
{
    private static Scanner scanner;
    private static GestorJugadores gestorJ;

    public static void main(String[] args) 
    {
        scanner = new Scanner(System.in);
        gestorJ = new GestorJugadores();
        
        boolean salir = false;
        
        while (!salir) 
        {
            System.out.println("\n--- Gestión de Jugadores ---");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Borrar Jugador");
            System.out.println("3. Listar Jugadores");
            System.out.println("4. Editar Jugador");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion)
            {
                case 1:
                    crearJ();
                    break;
                case 2:
                	borrarJ();
                    break;
                case 3:
                	listarJ();
                    break;
                case 4:
                	editarJ();
                	break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }
    
    private static void crearJ()
    {
    	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    	
    	System.out.print("Introduce el nombre: ");
    	String nombre = scanner.nextLine();
    	System.out.print("Introduce los apellidos: ");
    	String apellidos = scanner.nextLine();
    	try {
    	System.out.print("Introduce la fecha de nacimiento (dd/MM/yyyy): ");
    	String fechaN = scanner.nextLine();
    	Date fechaNacimiento = formatoFecha.parse(fechaN);
    	}catch(ParseException e) {System.out.println("Formato de fecha inválido");}
    	System.out.print("Introduce el correo electronico: ");
    	String correo = scanner.nextLine();
    	LocalDate fechaIns = LocalDate.now();
    	
    	int res = gestorJ.addJugador(nombre, apellidos, fechaNacimiento, fechaIns, correo);
    }
    
    private static void listarJ()
    {
    	List<JugadorDTO> jugadores = gestorJ.getAllJugadores();
    	if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles.");
        } else {
            System.out.println("Lista de jugadores:");
            for (JugadorDTO jugador : jugadores) {
                System.out.println(jugador.toString());
            }
        }
    }
    
    private static void borrarJ()
    {
    	System.out.print("Introduce el correo del jugador a borrar: ");
    	String correo = scanner.nextLine();
    	int res = gestorJ.deleteJugador(correo);
    	
    	if(res == -1){System.out.println("Error en el borrado del jugador");}
    	else if(res == 0){System.out.println("El jugador no existe");}
    	else{System.out.println("Jugador borrado con éxito");}
    }
    
    private static void editarJ()
    {
    	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    	
    	System.out.print("Introduce el correo del jugador a editar: ");
    	String correo = scanner.nextLine();
    	System.out.print("Introduce el nuevo nombre: ");
    	String nombre = scanner.nextLine();
    	System.out.print("Introduce los nuevos apellidos: ");
    	String apellidos = scanner.nextLine();
    	try{System.out.print("Introduce la nueva fecha de nacimiento (dd/MM/yyyy): ");
    	String fechaN = scanner.nextLine(); 
    	Date fechaNacimiento = formatoFecha.parse(fechaN);
		}catch(ParseException e) {System.out.println("Formato de fecha inválido");}
    	
    	int res = gestorJ.updateJugador(nombre, apellidos, fechaNacimiento, correo);
    	
    	if(res == -1){System.out.println("Error en la actualizacion del jugador");}
    	else if(res == 0){System.out.println("El jugador no existe");}
    	else{System.out.println("Jugador editado con éxito");}
    }
}
