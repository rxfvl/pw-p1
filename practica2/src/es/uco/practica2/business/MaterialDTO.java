package es.uco.practica2.business;

public class MaterialDTO {
	private int id;
	private int tipo;
	private int uso_material;
	private int estado;
	private int id_pista;
	
	
	public MaterialDTO(int tipo, int uso_material, int estado, int id_pista) {
		//this.id = id;
		this.tipo = tipo; // 1 CANASTAS; 2 CONOS; 3 PELOTAS
		this.uso_material = uso_material; // 1 INTERIOR; 2 EXTERIOR
		this.estado = estado; // 1 DISPONIBLE; 2 RESERVADO; 3 MALESTADO
		this.id_pista = id_pista;
	}
	public MaterialDTO() {}
	
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
	 * @return the uso_material
	 */
	public int getUso_material() {
		return uso_material;
	}
	/**
	 * @param uso_material the uso_material to set
	 */
	public void setUso_material(int uso_material) {
		this.uso_material = uso_material;
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
	@Override
	public String toString() {
		return "MaterialDTO [tipo=" + tipo + ", uso_material=" + uso_material + ", estado=" + estado
				+ ", id_pista=" + id_pista + "]";
	}
	
}
