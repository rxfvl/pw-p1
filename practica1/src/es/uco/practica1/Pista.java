package es.uco.practica1;

import java.util.ArrayList;
import es.uco.practica1.Material;
import java.util.*;

public class Pista
{	
	private String nombre; 
	private boolean estado;
	private boolean tipo; //true = interior, false = exterior
	private Enums.tamanio pista;
	private int jugadores_max;
	private ArrayList<Material> materiales;
	
	public Pista() 
	{
		this.nombre = "SIN_NOMBRE";
		this.estado = true;
		this.tipo = true;
		this.pista = Enums.tamanio.NONE;
		this.jugadores_max = -1;
		this.materiales = new ArrayList<Material>();
	}
	
	public Pista(String nombre, boolean estado, boolean tipo, Enums.tamanio tamanio, int jugadores)
	{
		this.nombre = nombre;
		this.estado = estado;
		this.tipo = tipo;
		this.pista = tamanio;
		this.jugadores_max = jugadores;
		this.materiales = new ArrayList<>();
	}
	
	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public boolean getEstado() 
	{
		return estado;
	}

	public void setEstado(boolean estado) 
	{
		this.estado = estado;
	}

	public boolean getTipo()
	{
		return tipo;
	}

	public void setTipo(boolean tipo) 
	{
		this.tipo = tipo;
	}

	public Enums.tamanio getPista() 
	{
		return pista;
	}

	public void setPista(Enums.tamanio pista) 
	{
		this.pista = pista;
	}

	public int getJugadores_max() 
	{
		return jugadores_max;
	}

	public void setJugadores_max(int jugadores_max) 
	{
		this.jugadores_max = jugadores_max;
	}

	public ArrayList<Material> getMateriales() 
	{
		return materiales;
	}

	public void setMateriales(ArrayList<Material> materiales) 
	{
		this.materiales = materiales;
	}

	public String toString() 
	{
		return "Pista [nombre = " + nombre + ", estado = " + estado + ", tipo = " + tipo + 
				", pista = " + pista + ", jugadores maximos = " + jugadores_max + "]";
	}

	public ArrayList<Material> consultarMaterialesDisponibles() 
	{
		ArrayList<Material> aux;
		aux = new ArrayList<>();

		for(Material material : materiales)
		{
			if (material.getStatus() == Enums.estado.DISPONIBLE) 
			{
				aux.add(material);
			}
		}
		return aux;
	}	

	public void asociarMaterialAPista(Material material) 
	{
		if((getEstado() == true) || (material.getMaterialUse() == getEstado()))
		{
			if(material.getType() == Enums.tipo.PELOTAS)
			{
				if((Collections.frequency(getMateriales(), Enums.tipo.PELOTAS)) < 12)
				{
					getMateriales().add(material);
				}
			}
			if(material.getType() == Enums.tipo.CANASTAS)
			{
				if((Collections.frequency(getMateriales(), Enums.tipo.CANASTAS)) < 2)
				{
					getMateriales().add(material);
				}
			}
			if(material.getType() == Enums.tipo.CONOS)
			{
				if((Collections.frequency(getMateriales(), Enums.tipo.CONOS)) < 20)
				{
					getMateriales().add(material);
				}
			}
		}
		else {System.out.println("Error, no se pueden usar materiales de interior en una pista exterior\n");}
	}
}