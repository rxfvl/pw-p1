package es.uco.practica2.business;

import java.util.Date;
import java.time.LocalDate;

public class JugadorDTO {
    private int id;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private LocalDate fecha_inscripcion;
    private String correo_electronico;

    // Constructor que incluye el ID
    public JugadorDTO(String nombre, String apellidos, Date fecha_nacimiento, LocalDate fecha_inscripcion,
                      String correo_electronico) {
        //this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_inscripcion = fecha_inscripcion;
        this.correo_electronico = correo_electronico;
    }
	
	public JugadorDTO() {}
	
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the fecha_nacimiento
	 */
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	/**
	 * @param fecha_nacimiento the fecha_nacimiento to set
	 */
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	/**
	 * @return the fecha_inscripcion
	 */
	public LocalDate getFecha_inscripcion() {
		return fecha_inscripcion;
	}
	/**
	 * @param fecha_inscripcion the fecha_inscripcion to set
	 */
	public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
	/**
	 * @return the correo_electronico
	 */
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	/**
	 * @param correo_electronico the correo_electronico to set
	 */
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	@Override
	public String toString() {
        return "JugadorDTO [nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento="
                + fecha_nacimiento + ", fecha_inscripcion=" + fecha_inscripcion + ", correo_electronico="
                + correo_electronico + "]";
	}
	
}
