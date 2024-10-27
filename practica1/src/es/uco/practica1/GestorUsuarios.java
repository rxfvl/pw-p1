package es.uco.practica1;

import java.util.*;

public class GestorUsuarios {
	
	private List<Jugador> arrayJugadores;
	
	public GestorUsuarios(String path)
	{
		FileManager fileMan = new FileManager();
		this.arrayJugadores =  fileMan.cargarJugadoresDesdeArchivo(path);
	}
	
	public boolean addUser(String filePath, Jugador jugador)
	{
		FileManager fileMan = new FileManager();
		
		
	}
	
	public void listUsers(String filePath)
	{
		FileManager fileMan = new FileManager();
		
		System.out.println(fileMan.readFile(filePath));
	}
}


