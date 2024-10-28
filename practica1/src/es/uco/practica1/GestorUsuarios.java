package es.uco.practica1;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;


public class GestorUsuarios {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha esperado
	
	private List<Jugador> arrayJugadores;
	private String path;
	
	public GestorUsuarios(String path)
	{
		this.path = path;
	}
	
	public String getPath() {return this.path;}
	public void setPath(String path) {this.path = path;}
	
	
	private boolean jugadorExists(String dni)
	{
		if(arrayJugadores.isEmpty())
			return false;
		for (Jugador player : arrayJugadores)
		{
			if (dni.equals(player.getDni()))
			{
				return true;
			}
		}
		return false;
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
		System.out.println("JUGADORES GUARDADOS LOL");
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
			for (Jugador player : arrayJugadores)
			{
				System.out.println(player.getDni());
				if (player.getDni().equals(dni))
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
                        player.setNombre(nombre);
                        player.setApellidos(apellidos);
                        player.setFechaNacimiento(fechaNacimiento);
                        player.setFechaInscripcion(fechaInscripcion);
                        player.setCorreoElectronico(correo);
                        player.setDni(newDni);
                        break;
					}
					catch(ParseException e)
					{
						System.out.println("Error al parsear la fecha: " + e.getMessage());
					}
				}
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


