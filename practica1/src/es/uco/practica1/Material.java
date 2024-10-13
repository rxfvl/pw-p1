package es.uco.practica1;

public class Material {
	
	private enum tipo
	{
		pelotas,
		canastas,
		conos
	}
	private enum estado {
		disponible,
		reservado,
		malEstado
	}
	private int id;
	
	private tipo type;
	
	private estado status;
	
	private boolean usoMaterial;
	
	

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

