package es.uco.practica1;

import java.util.ArrayList;

public class Pista
{
	private enum tamanio{MINIBASKET, ADULTOS, TRES_VS_TRES}
	
	private String nombre; 
	private boolean estado;
	private boolean tipo;
	private tamanio pista;
	private int jugadores_max;
	private ArrayList<Material> materiales;
	
	public Pista() 
	{
		this.estado = true;
	}
	
	public Pista(String nombre, boolean estado, boolean tipo, tamanio tamanio, int jugadores)
	{
		this.nombre = nombre;
		this.estado = estado;
		this.tipo = tipo;
		this.pista = tamanio;
		this.jugadores_max = jugadores;
		this.materiales = new ArrayList<>();
	}
	
	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public tamanio getPista() {
		return pista;
	}

	public void setPista(tamanio pista) {
		this.pista = pista;
	}

	public int getJugadores_max() {
		return jugadores_max;
	}

	public void setJugadores_max(int jugadores_max) {
		this.jugadores_max = jugadores_max;
	}

	public ArrayList<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<Material> materiales) {
		this.materiales = materiales;
	}

	@Override
	public String toString() {
		return "Pista [nombre = " + nombre + ", estado = " + estado + ", tipo = " + tipo + 
				", pista = " + pista + ", jugadores maximos = " + jugadores_max + "]";
	}
		
}