package es.uco.practica2.business;

import java.util.List;
import es.uco.practica2.data.dao.*;

public class GestorPistas {


    private PistaDAO pistaDAO = new PistaDAO();
    private MaterialDAO matDAO = new MaterialDAO();
    
    public GestorPistas() {
        
    }
    
	public int crearPista(String nombre, int estado, int tipo, int tamanio, int jugadores)
	{
		PistaDTO pista = new PistaDTO(nombre, estado, tipo, tamanio, jugadores);
		
		return pistaDAO.crearPista(pista);
	}
	
	public List<PistaDTO> ListarPistas()
	{
		return pistaDAO.ListarPistas();
	}
	
	public int borrarPista(String nombre)
	{
		PistaDTO pista = new PistaDTO(nombre, -1, -1, -1, -1);
				
		return pistaDAO.borrarPista(pista);
	}
	
	public int crearMat(int mat, int uso, int estado)
	{		
			if(mat < 1 || mat > 3) {return -1;}
		if(uso != 1 && uso != 2){return -1;}
		if(estado != 1 && estado != 2){return -1;}
		
		MaterialDTO material = new MaterialDTO(mat, uso, estado, -1);
		
		return  matDAO.crearMaterial(material);
	}
	
	public int asociar(String nombre, int tipo, int uso)
	{		
		MaterialDTO mat = new MaterialDTO(tipo, uso, 1, -1);
		PistaDTO pista = new PistaDTO(nombre, -1, -1, -1, -1);
		
		return matDAO.asociarMaterialPista(pista, mat);
	}
	
	public int borrarMat(int tipo)
	{
		MaterialDTO mat = new MaterialDTO(tipo, -1, -1, -1);
		
		return  matDAO.borrarMaterial(mat);
	}
	
	public List<MaterialDTO> ListarMat()
	{
		return matDAO.listarMateriales();
	}
}
