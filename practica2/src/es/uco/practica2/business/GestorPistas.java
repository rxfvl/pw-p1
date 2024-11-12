package es.uco.practica2.business;

import java.util.ArrayList;
import es.uco.practica2.business.*;

public class GestorPistas {

	
    private ArrayList<PistaDTO> pistas;
    private ArrayList<MaterialDTO> materiales;

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
	}
}
