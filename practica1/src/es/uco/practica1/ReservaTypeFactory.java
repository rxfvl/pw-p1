package es.uco.practica1;

public abstract class ReservaTypeFactory 
{
	//Metodos factory para cada reserva
	public abstract ReservaInfantil createReservaInfantil();
	
	public abstract ReservaInfantil createReservaFamiliar();

	public abstract ReservaInfantil createReservaAdultos();
}
