package es.uco.practica2.business;

import java.util.Date;

public class ReservasDTO {
	private int id;
	private Date fecha;
	private int duracion;
	private int id_pista;
	private float precio;
	private float descuento;
	private int tipo_reserva;	//0=adultos; 1=infantil; 2=familiar;
	private int num_ninios;
	private int num_adultos;
	private int id_bono;
	private int id_jugador;
	
	public ReservasDTO(Date fecha, int duracion, int id_pista, float precio, float descuento, int tipo_reserva,
			int num_ninios, int num_adultos, int id_bono, int id_jugador) {
		//this.id = id;
		this.fecha = fecha;
		this.duracion = duracion;
		this.id_pista = id_pista;
		this.precio = precio;
		this.descuento = descuento;
		this.tipo_reserva = tipo_reserva;
		this.num_ninios = num_ninios;
		this.num_adultos = num_adultos;
		this.id_bono = id_bono;
		this.id_jugador= id_jugador;
	}
	
	public ReservasDTO() {}

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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the id_pista
	 */
	public int getId_pista() {
		return id_pista;
	}

	/**
	 * @param id_pista the id_pista to set
	 */
	public void setId_pista(int id_pista) {
		this.id_pista = id_pista;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the descuento
	 */
	public float getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the tipo_reserva
	 */
	public int getTipo_reserva() {
		return tipo_reserva;
	}

	/**
	 * @param tipo_reserva the tipo_reserva to set
	 */
	public void setTipo_reserva(int tipo_reserva) {
		this.tipo_reserva = tipo_reserva;
	}

	/**
	 * @return the num_ninios
	 */
	public int getNum_ninios() {
		return num_ninios;
	}

	/**
	 * @param num_ninios the num_ninios to set
	 */
	public void setNum_ninios(int num_ninios) {
		this.num_ninios = num_ninios;
	}

	/**
	 * @return the num_adultos
	 */
	public int getNum_adultos() {
		return num_adultos;
	}

	/**
	 * @param num_adultos the num_adultos to set
	 */
	public void setNum_adultos(int num_adultos) {
		this.num_adultos = num_adultos;
	}

	/**
	 * @return the id_bono
	 */
	public int getId_bono() {
		return id_bono;
	}

	/**
	 * @param id_bono the id_bono to set
	 */
	public void setId_bono(int id_bono) {
		this.id_bono = id_bono;
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
	@Override
	public String toString() {
		return "ReservasDTO [fecha=" + fecha + ", duracion=" + duracion + ", id_pista=" + id_pista
				+ ", precio=" + precio + ", descuento=" + descuento + ", tipo_reserva=" + tipo_reserva + ", num_ninios="
				+ num_ninios + ", num_adultos=" + num_adultos + ", id_bono=" + id_bono + ", id_jugador=" + id_jugador + "]";
	}
}
