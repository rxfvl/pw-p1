package es.uco.practica1;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * La clase GestorUsuarios se encarga de gestionar una lista de usuarios (jugadores),
 * proporcionando métodos para añadir, modificar y listar usuarios, y utilizando un archivo 
 * para almacenar la información de los jugadores.
 */
public class GestorUsuarios {
	
	/** Formato de fecha esperado para las fechas de nacimiento e inscripción */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /** Lista de jugadores gestionados por la clase */
    private List<Jugador> arrayJugadores;

    /** Ruta del archivo donde se almacenan los datos de los jugadores */
    private String path;

    /**
     * Constructor de la clase GestorUsuarios
     * 
     * @param path Ruta del archivo donde se almacenan los datos de los jugadores
     */
    public GestorUsuarios(String path) {
        this.path = path;
    }

    /**
     * Obtiene la ruta del archivo de jugadores.
     * 
     * @return Ruta del archivo de jugadores
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Establece la ruta del archivo de jugadores.
     * 
     * @param path Nueva ruta del archivo de jugadores
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Comprueba si un jugador con un determinado DNI existe en la lista de jugadores.
     * 
     * @param dni DNI del jugador a buscar
     * @return true si el jugador existe, false en caso contrario
     */
    private boolean jugadorExists(String dni) {
        if (arrayJugadores.isEmpty())
            return false;
        for (Jugador player : arrayJugadores) {
            if (dni.equals(player.getDni())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añade un nuevo jugador a la lista y guarda los cambios en el archivo.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de los jugadores
     * @param jugador Jugador a añadir
     * @return true si el jugador se añadió correctamente, false si el jugador ya existe
     */
    public boolean addUser(String filePath, Jugador jugador) {
        FileManager fileMan = new FileManager();
        arrayJugadores = fileMan.cargarJugadoresDesdeArchivo(filePath);

        if (jugadorExists(jugador.getDni())) {
            System.out.println("ERR: Usuario ya existe\n");
            arrayJugadores.clear();
            return false;
        }
        arrayJugadores.add(jugador);
        fileMan.guardarJugadoresEnArchivo(filePath, arrayJugadores);
        arrayJugadores.clear();
        return true;
    }

    /**
     * Modifica los datos de un jugador existente.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de los jugadores
     * @param dni DNI del jugador a modificar
     */
    public void modUser(String filePath, String dni) {
        FileManager fileMan = new FileManager();
        arrayJugadores = fileMan.cargarJugadoresDesdeArchivo(filePath);
        Scanner scanner = new Scanner(System.in);

        if (jugadorExists(dni)) {
            for (Jugador player : arrayJugadores) {
                System.out.println(player.getDni());
                if (player.getDni().equals(dni)) {
                    try {
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese los apellidos: ");
                        String apellidos = scanner.nextLine();

                        System.out.print("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
                        Date fechaNacimiento = dateFormat.parse(scanner.nextLine());

                        System.out.print("Ingrese la fecha de inscripción (yyyy-MM-dd): ");
                        Date fechaInscripcion = dateFormat.parse(scanner.nextLine());

                        System.out.print("Ingrese el correo: ");
                        String correo = scanner.nextLine();

                        System.out.print("Ingrese el nuevo DNI: ");
                        String newDni = scanner.nextLine();

                        // Actualizo el jugador
                        player.setNombre(nombre);
                        player.setApellidos(apellidos);
                        player.setFechaNacimiento(fechaNacimiento);
                        player.setFechaInscripcion(fechaInscripcion);
                        player.setCorreoElectronico(correo);
                        player.setDni(newDni);
                        break;
                    } catch (ParseException e) {
                        System.out.println("Error al parsear la fecha: " + e.getMessage());
                    }
                }
            }
            fileMan.guardarJugadoresEnArchivo(filePath, arrayJugadores);
            arrayJugadores.clear();
            System.out.println("Usuario modificado con exito\n");
        } else {
            System.out.println("El usuario no existe\n");
        }
    }

    /**
     * Lista todos los jugadores guardados en el archivo especificado.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de los jugadores
     */
    public void listUsers(String filePath) {
        FileManager fileMan = new FileManager();
        System.out.println(fileMan.readFile(filePath));
    }
}


