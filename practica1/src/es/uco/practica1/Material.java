package es.uco.practica1;

public class Material {
	
	private int id;
	
	private Enums.tipo type;
	
	private Enums.estado status;
	
	private boolean usoMaterial;
	
	

	public Material(int id, Enums.tipo type, boolean usoMaterial, Enums.estado status)
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
	
	public Enums.tipo getType()
	{
		return this.type;
	}
	
	public Enums.estado getStatus()
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

