package es.uco.practica1;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;


public class GestorUsuarios {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha esperado
	
	private List<Jugador> arrayJugadores;
	
	private boolean jugadorExists(String dni)
	{
		for (Jugador player : arrayJugadores)
		{
			if (player.getDni() == dni)
			{
				return false;
			}
		}
		return true;
	}
		
	
	public boolean addUser(String filePath, Jugador jugador)
	{
		FileManager fileMan = new FileManager();
		arrayJugadores = fileMan.cargarJugadoresDesdeArchivo(filePath);
		
		if (jugadorExists(jugador.getDni()))
		{
			System.out.println("ERR: Usuario ya existe\n");
			arrayJugadores.clear();
			return false;
		}
		arrayJugadores.add(jugador);
		fileMan.guardarJugadoresEnArchivo(filePath, arrayJugadores);
		arrayJugadores.clear();
		return true;
	}
	
	public void modUser(String filePath, String dni)
	{
		FileManager fileMan = new FileManager();
		arrayJugadores = fileMan.cargarJugadoresDesdeArchivo(filePath);
		Scanner scanner = new Scanner(System.in);
		
		
		if (jugadorExists(dni))
		{
			for (int i = 0; i < arrayJugadores.size(); i++)
			{
				if (arrayJugadores.get(i).getDni().equals(dni))
				{
					try
					{
						System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese los apellidos: ");
                        String apellidos = scanner.nextLine();

                        System.out.print("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
                        Date fechaNacimiento = dateFormat.parse(scanner.nextLine());

                        System.out.print("Ingrese la fecha de inscripción (yyyy-MM-dd): ");
                        Date fechaInscripcion = dateFormat.parse(scanner.nextLine());

                        System.out.print("Ingrese el correo: ");
                        String correo = scanner.nextLine();

                        System.out.print("Ingrese el nuevo DNI: ");
                        String newDni = scanner.nextLine();
                        
                        // Actualizo el jugador
                        arrayJugadores.get(i).setNombre(nombre);
                        arrayJugadores.get(i).setApellidos(apellidos);
                        arrayJugadores.get(i).setFechaNacimiento(fechaNacimiento);
                        arrayJugadores.get(i).setFechaInscripcion(fechaInscripcion);
                        arrayJugadores.get(i).setCorreoElectronico(correo);
                        arrayJugadores.get(i).setDni(newDni);
                        
					}
					catch(ParseException e)
					{
						System.out.println("Error al parsear la fecha: " + e.getMessage());
					}
				}
				break;
			}
			fileMan.guardarJugadoresEnArchivo(filePath, arrayJugadores);
			arrayJugadores.clear();
			System.out.println("Usuario modificado con exito\n");
		}
		
		else
			System.out.println("El usuario no existe\n");
		
	}
	
	public void listUsers(String filePath)
	{
		FileManager fileMan = new FileManager();
		
		System.out.println(fileMan.readFile(filePath));
	}
}


