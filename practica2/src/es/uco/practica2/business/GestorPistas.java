package es.uco.practica2.business;

import java.util.ArrayList;
import java.util.List;
import es.uco.practica2.business.*;
import es.uco.practica2.data.dao.*;

public class GestorPistas {

	
    private List<PistaDTO> pistas;
    private ArrayList<MaterialDTO> materiales;
    private PistaDAO pistaDAO;
    private MaterialDAO matDAO;
    
    public GestorPistas() {
        this.pistas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }
    
	public int crearPista(String nombre, int estado, int tipo, int tamanio, int jugadores)
	{		
		int res;
		
		PistaDTO pista = new PistaDTO(nombre, estado, tipo, tamanio, jugadores);
		
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
		PistaDTO pista = new PistaDTO(nombre, -1, -1, -1, -1);
				
		res = pistaDAO.borrarPista(pista);
		
		return res;
	}
	
	public int crearMat(int mat, int uso, int estado)
	{		
		int res;
		
		if(mat < 1 || mat > 3) {return -1;}
		if(uso != 1 && uso != 2){return -1;}
		if(estado != 1 && estado != 2){return -1;}
		
		MaterialDTO material = new MaterialDTO(mat, uso, estado, -1);
		res = matDAO.crearMaterial(material);
		
		return res;
	}
	
	public int asociar(String nombre, int tipo)
	{
		int res;
		
		MaterialDTO mat = new MaterialDTO(tipo, -1, -1, -1);
		PistaDTO pista = new PistaDTO(nombre, -1, -1, -1, -1);
		
		res = matDAO.asociarMaterialPista(pista, mat);
	}
}
