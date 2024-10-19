package es.uco.practica1;

import java.util.ArrayList;
import es.uco.practica1.Material;
import java.util.*;

public class Pista
{	
    /** 
     * El nombre de la pista.
     */
	private String nombre; 
	
    /** 
     * El estado de la pista (true si está disponible, false si está ocupada).
     */
	private boolean estado;
	
    /** 
     * El tipo de la pista (true si es interior, false si es exterior).
     */
	private boolean tipo; // true = interior, false = exterior
	
    /** 
     * El tamaño de la pista, basado en un enumerado definido en {@link Enums}.
     */
	private Enums.tamanio pista;
	
    /** 
     * El número máximo de jugadores permitidos en la pista.
     */
	private int jugadores_max;
	
    /** 
     * Los materiales disponibles para la pista (pelotas, conos, canastas, etc.).
     */
	private ArrayList<Material> materiales;
	
    /**
     * Constructor por defecto que inicializa la pista con valores predeterminados.
     * El nombre será "SIN_NOMBRE", la pista estará disponible, será interior,
     * y no tendrá un tamaño definido ni jugadores asociados.
     */
	public Pista() 
	{
		this.nombre = "SIN_NOMBRE";
		this.estado = true;
		this.tipo = true;
		this.pista = Enums.tamanio.NONE;
		this.jugadores_max = -1;
		this.materiales = new ArrayList<Material>();
	}
	
    /**
     * Constructor con parámetros que permite inicializar la pista con un nombre, estado,
     * tipo (interior o exterior), tamaño, y número máximo de jugadores.
     * 
     * @param nombre El nombre de la pista.
     * @param estado El estado de la pista (true si está disponible, false si está ocupada).
     * @param tipo El tipo de la pista (true si es interior, false si es exterior).
     * @param tamanio El tamaño de la pista, de tipo {@link Enums.tamanio}.
     * @param jugadores El número máximo de jugadores permitidos.
     */
	public Pista(String nombre, boolean estado, boolean tipo, Enums.tamanio tamanio, int jugadores)
	{
		this.nombre = nombre;
		this.estado = estado;
		this.tipo = tipo;
		this.pista = tamanio;
		this.jugadores_max = jugadores;
		this.materiales = new ArrayList<>();
	}
	
    /**
     * Devuelve el nombre de la pista.
     * 
     * @return El nombre de la pista.
     */
	public String getNombre()
	{
		return nombre;
	}

    /**
     * Establece el nombre de la pista.
     * 
     * @param nombre El nombre que se quiere asignar a la pista.
     */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

    /**
     * Devuelve el estado actual de la pista.
     * 
     * @return true si la pista está disponible, false si está ocupada.
     */
	public boolean getEstado() 
	{
		return estado;
	}

    /**
     * Establece el estado de la pista.
     * 
     * @param estado true si la pista está disponible, false si está ocupada.
     */
	public void setEstado(boolean estado) 
	{
		this.estado = estado;
	}

    /**
     * Devuelve el tipo de la pista.
     * 
     * @return true si la pista es interior, false si es exterior.
     */
	public boolean getTipo()
	{
		return tipo;
	}

    /**
     * Establece el tipo de la pista (interior o exterior).
     * 
     * @param tipo true si la pista es interior, false si es exterior.
     */
	public void setTipo(boolean tipo) 
	{
		this.tipo = tipo;
	}

    /**
     * Devuelve el tamaño de la pista.
     * 
     * @return El tamaño de la pista, de tipo {@link Enums.tamanio}.
     */
	public Enums.tamanio getPista() 
	{
		return pista;
	}

    /**
     * Establece el tamaño de la pista.
     * 
     * @param pista El tamaño de la pista, de tipo {@link Enums.tamanio}.
     */
	public void setPista(Enums.tamanio pista) 
	{
		this.pista = pista;
	}

    /**
     * Devuelve el número máximo de jugadores permitidos en la pista.
     * 
     * @return El número máximo de jugadores.
     */
	public int getJugadores_max() 
	{
		return jugadores_max;
	}

    /**
     * Establece el número máximo de jugadores permitidos en la pista.
     * 
     * @param jugadores_max El número máximo de jugadores.
     */
	public void setJugadores_max(int jugadores_max) 
	{
		this.jugadores_max = jugadores_max;
	}

    /**
     * Devuelve la lista de materiales asociados a la pista.
     * 
     * @return Una lista de materiales disponibles.
     */
	public ArrayList<Material> getMateriales() 
	{
		return materiales;
	}

    /**
     * Establece la lista de materiales para la pista.
     * 
     * @param materiales Una lista de materiales que se desea asociar a la pista.
     */
	public void setMateriales(ArrayList<Material> materiales) 
	{
		this.materiales = materiales;
	}

    /**
     * Devuelve una representación en cadena de los atributos de la pista.
     * 
     * @return Una cadena que representa la pista.
     */
	@Override
	public String toString() 
	{
		return "Pista [nombre = " + nombre + ", estado = " + estado + ", tipo = " + tipo + 
				", pista = " + pista + ", jugadores maximos = " + jugadores_max + "]";
	}

    /**
     * Consulta y devuelve los materiales disponibles en la pista.
     * 
     * @return Una lista de materiales que están disponibles en la pista.
     */
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

    /**
     * Asocia un material a la pista si cumple con los requisitos de cantidad y tipo.
     * No se pueden usar materiales de interior en una pista exterior.
     * 
     * @param material El material que se quiere asociar a la pista.
     */
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
		else {
			System.out.println("Error, no se pueden usar materiales de interior en una pista exterior\n");
		}
	}
}