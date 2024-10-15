package es/uco/practica1;

/**
 * Jugador class
 * @author Miriam Prado Martínez
 * */

//Importaciones:
import java.util.Date;					//Para manejar las fechas.
import java.text.SimpleDateFormat;		//Para formatear las fechas: dd/MM/yyyy.
import java.util.concurrent.TimeUnit;	//Para realizar conversiones de tiempo.

public class Jugador {
    // Atributos:
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private Date fechaInscripcion;
    private String correoElectronico;

    // Constructor vacío:
    public Jugador() {
        // Inicializa los atributos si es necesario
    }

    // Constructor parametrizado:
    public Jugador(String nombre, String apellidos, Date fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.fechaInscripcion = new Date(); // hora actual del sistema
    }

    // Métodos get/set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Método toString para imprimir la información del usuario:
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + dateFormat.format(fechaNacimiento) +
                ", fechaInscripcion=" + dateFormat.format(fechaInscripcion) +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }

    // Método calcularAntiguedad:
    public int calcularAntiguedad() {
        long diferenciaMilisegundos = new Date().getTime() - fechaInscripcion.getTime();
        return (int) TimeUnit.MILLISECONDS.toDays(diferenciaMilisegundos) / 365; // convertir a años
    }
}
