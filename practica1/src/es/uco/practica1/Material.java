package es.uco.practica1;
import es.uco.practica1.Enums

public class Material {
	
	private int id;
	
	private tipo type;
	
	private estado status;
	
	private boolean usoMaterial; // true  = interior, false = exterior
	
	

	public Material(int id, tipo type, boolean usoMaterial, estado status)
	{
		this.id = id;
		this.type = type;
		this.usoMaterial = usoMaterial;
		this.status = status;
	}
	
	public Material()
	{
		this.id = 0;
		this.usoMaterial = true;
		this.type = Enums.tipo.NONE;
		this.status = Enums.estado.NONE;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public tipo getType()
	{
		return this.type;
	}
	
	public estado getStatus()
	{
		return this.status;
	}
	
	public boolean getMaterialUse()
	{
		return this.usoMaterial;
	}
	
	public String toString()
	{
		return "Id: " + this.id + "Tipo: " + this.type
				+ "Estado: " + this.status + "Uso Material: " + this.usoMaterial;
	}
}

