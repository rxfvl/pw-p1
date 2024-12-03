package es.uco.practica2.business;

public class PistaDTO {
	private int id;
	private String nombre;
	private int estado;
	private int tipo;
	private int tamanio;
	private int jugadores_max;
	
	public PistaDTO(String nombre, int estado, int tipo, int tamanio, int jugadores_max) {
		//this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.tipo = tipo;
		this.tamanio = tamanio;
		this.jugadores_max = jugadores_max;
	}
	public PistaDTO() {}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tamanio
	 */
	public int getTamanio() {
		return tamanio;
	}

	/**
	 * @param tamanio the tamanio to set
	 */
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	/**
	 * @return the jugadores_max
	 */
	public int getJugadores_max() {
		return jugadores_max;
	}

	/**
	 * @param jugadores_max the jugadores_max to set
	 */
	public void setJugadores_max(int jugadores_max) {
		this.jugadores_max = jugadores_max;
	}
	@Override
	public String toString() {
		return "PistaDTO [nombre=" + nombre + ", estado=" + estado + ", tipo=" + tipo + ", tamanio="
				+ tamanio + ", jugadores_max=" + jugadores_max + "]";
	}
	
}
