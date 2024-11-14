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
    
	public int crearPista(String nombre, int estado, int tipo, int tamanio, int jugadores)
	{		
		int res;
		
		PistaDTO pista = new PistaDTO(-1, nombre, estado, tipo, tamanio, jugadores);
		
		res = pistaDAO.crearPista(pista);
		
		return res;
	}
	
	public List<PistaDTO> ListarPistas()
	{
		pistas = pistaDAO.ListarPistas();
		
		return pistas;
	}
	
	public int borrarPista(String nombre)
	{
		int res;
		PistaDTO pista = new PistaDTO(-1, nombre, -1, -1, -1, -1);
				
		res = pistaDAO.borrarPista(pista);
		
		return res;
	}
	
	public int crearMat(int mat, int uso, int estado)
	{
		
	}
}
