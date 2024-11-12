package es.uco.practica2.business;

import java.util.ArrayList;
import java.util.List;
import es.uco.practica2.business.*;
import es.uco.practica2.data.dao.PistaDAO;

public class GestorPistas {

	
    private List<PistaDTO> pistas;
    private ArrayList<MaterialDTO> materiales;
    private PistaDAO pistaDAO;
    
    public GestorPistas() {
        this.pistas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }
    
	public void crearPista(String nombre, boolean estado, boolean tipo, int tamanio, int jugadores)
	{
		int estadoInt, tipoInt;
		
		if(estado){estadoInt = 1;}
		else {estadoInt = 2;}
		
		if(tipo){tipoInt = 1;}
		else {tipoInt = 2;}
		
		PistaDTO pista = new PistaDTO(-1, nombre, estadoInt, tipoInt, tamanio, jugadores);
		
		pistaDAO.crearPista(pista);
	}
	
	public List<PistaDTO> ListarPistas()
	{
		pistas = pistaDAO.ListarPistas();
		
		return pistas;
	}
	
	public int borrarPista(int id, String nombre)
	{
		int res;
		PistaDTO pista = new PistaDTO(id, nombre, -1, -1, -1, -1);
				
		res = pistaDAO.borrarPista(pista);
		
		return res;
	}
}
