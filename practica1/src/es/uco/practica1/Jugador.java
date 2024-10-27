package es.uco.practica1;

//Importaciones:
import java.util.Date;					//Para manejar las fechas.
import java.text.ParseException;
import java.text.SimpleDateFormat;		//Para formatear las fechas: dd/MM/yyyy.
import java.util.concurrent.TimeUnit;	//Para realizar conversiones de tiempo.

public class Jugador {
    
	/**
     * El nombre del jugador.
     */
    private String nombre; 
    /**
     * Los apellidos del jugador.
     */
    private String apellidos; 
    /**
     * La fecha de nacimiento del jugador.
     */
    private Date fechaNacimiento;
    /**
     * La fecha de inscripción en el sistema.
     */
    private Date fechaInscripcion;   
    /**
     * El correo electrónico del jugador.
     */
    private String correoElectronico; 

    /**
     * El dni del jugador.
     */
    private String dni;
    
    /**
     * Constructor por defecto que inicializa el jugador con valores por defecto.
     * Los valores predeterminados son:
     * <ul>
     *     <li>Nombre: "SIN_NOMBRE"</li>
     *     <li>Apellidos: "SIN_APELLIDOS"</li>
     *     <li>Fecha de nacimiento: {@code null}</li>
     *     <li>Fecha de inscripción: {@code null}</li>
     *     <li>Correo electrónico: "SIN_CORREO"</li>
     *     <li>DNI: "SIN_DNI"</li>
     * </ul>
     */
    public Jugador() {
        this.nombre = "SIN_NOMBRE";
        this.apellidos = "SIN_APELLIDOS";
        this.fechaNacimiento = null;
        this.fechaInscripcion = null;
        this.correoElectronico = "SIN_CORREO";
        this.dni = "SIN_DNI";
    }

    /**
     * Constructor que inicializa un nuevo jugador con los parámetros especificados.
     * 
     * @param nombre          El nombre del jugador.
     * @param apellidos       Los apellidos del jugador.
     * @param fechaNacimiento La fecha de nacimiento del jugador.
     * @param correoElectronico El correo electrónico del jugador.
     * @param dni El DNI del jugador.
     */
    public Jugador(String nombre, String apellidos, Date fechaNacimiento, String correoElectronico, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.fechaInscripcion = new Date(); // Se asigna la fecha actual como fecha de inscripción
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del jugador.
     * 
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     * 
     * @param nombre El nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del jugador.
     * 
     * @return Los apellidos del jugador.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del jugador.
     * 
     * @param apellidos Los nuevos apellidos del jugador.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la fecha de nacimiento del jugador.
     * 
     * @return La fecha de nacimiento del jugador.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del jugador.
     * 
     * @param fechaNacimiento La nueva fecha de nacimiento del jugador.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la fecha de inscripción del jugador.
     * 
     * @return La fecha de inscripción del jugador.
     */
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Establece la fecha de inscripción del jugador.
     * 
     * @param fechaInscripcion La nueva fecha de inscripción del jugador.
     */
    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Obtiene el correo electrónico del jugador.
     * 
     * @return El correo electrónico del jugador.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del jugador.
     * 
     * @param correoElectronico El nuevo correo electrónico del jugador.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    /**
     * Obtiene el DNI del jugador.
     * 
     * @return El DNI del jugador.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del jugador.
     * 
     * @param dni El nuevo DNI del jugador.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve una representación en cadena del objeto Jugador.
     * La representación incluye el nombre, apellidos, fecha de nacimiento, 
     * fecha de inscripción y correo electrónico del jugador.
     * 
     * @return Una cadena que representa el jugador.
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + (fechaNacimiento != null ? dateFormat.format(fechaNacimiento) : "N/A") +
                ", fechaInscripcion=" + (fechaInscripcion != null ? dateFormat.format(fechaInscripcion) : "N/A") +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", DNI='" + dni + '\'' +
                '}';
    }

    /**
     * Calcula la antigüedad del jugador en el sistema, en años.
     * 
     * @return La antigüedad del jugador en años.
     */
    public int calcularAntiguedad() {
        long diferenciaMilisegundos = new Date().getTime() - fechaInscripcion.getTime();
        return (int) TimeUnit.MILLISECONDS.toDays(diferenciaMilisegundos) / 365;
    }
}
