package es.uco.practica2.business;

import java.util.Date;


public class BonoDTO
{
	private int id;
	private int tamanio_pista;
	private int id_jugador;
	private int sesiones;
	private Date fecha_cad;
	
	public BonoDTO(int tamanio_pista, int id_jugador, int sesiones, Date fecha_cad) {
		this.tamanio_pista = tamanio_pista;
		this.id_jugador = id_jugador;
		this.sesiones = sesiones;
		this.fecha_cad = fecha_cad;
	}
	
	public BonoDTO() {}

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
	 * @return the tamanio_pista
	 */
	public int getTamanio_pista() {
		return tamanio_pista;
	}

	/**
	 * @param tamanio_pista the tamanio_pista to set
	 */
	public void setTamanio_pista(int tamanio_pista) {
		this.tamanio_pista = tamanio_pista;
	}

	/**
	 * @return the id_jugador
	 */
	public int getId_jugador() {
		return id_jugador;
	}

	/**
	 * @param id_jugador the id_jugador to set
	 */
	public void setId_jugador(int id_jugador) {
		this.id_jugador = id_jugador;
	}

	/**
	 * @return the sesiones
	 */
	public int getSesiones() {
		return sesiones;
	}

	/**
	 * @param sesiones the sesiones to set
	 */
	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}

	/**
	 * @return the fecha_cad
	 */
	public Date getFecha_cad() {
		return fecha_cad;
	}

	/**
	 * @param fecha_cad the fecha_cad to set
	 */
	public void setFecha_cad(Date fecha_cad) {
		this.fecha_cad = fecha_cad;
	}

	@Override
	public String toString() {
		return "BonoDTO [tamanio_pista=" + tamanio_pista + ", id_jugador=" + id_jugador + ", sesiones="
				+ sesiones + ", fecha_cad=" + fecha_cad + "]";
	}

	
	
}