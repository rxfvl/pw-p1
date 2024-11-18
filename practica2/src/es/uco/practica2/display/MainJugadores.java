package es.uco.practica2.display;

// Importación de librerías necesarias
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import es.uco.practica2.business.*;
import java.time.LocalDate;
import java.text.ParseException;

/**
 * Clase MainJugadores que gestiona las interacciones con los jugadores
 * a través de un menú en la consola.
 */
public class MainJugadores
{
    private static Scanner scanner; // Escáner para la entrada de datos del usuario
    private static GestorJugadores gestorJ; // Gestor de jugadores para las operaciones CRUD

    /**
     * Método principal que inicia la aplicación.
     * Presenta un menú al usuario y llama a los métodos correspondientes
     * según la opción seleccionada.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) 
    {
        scanner = new Scanner(System.in);
        gestorJ = new GestorJugadores();
        
        boolean salir = false; // Variable de control para salir del menú
        
        while (!salir) 
        {
            // Muestra el menú de opciones
            System.out.println("\n--- Gestión de Jugadores ---");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Borrar Jugador");
            System.out.println("3. Listar Jugadores");
            System.out.println("4. Editar Jugador");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt(); // Captura la opción seleccionada
            scanner.nextLine(); // Limpiar el buffer

            // Control del menú según la opción seleccionada
            switch (opcion)
            {
                case 1:
                    crearJ(); // Método para crear un jugador
                    break;
                case 2:
                    borrarJ(); // Método para borrar un jugador
                    break;
                case 3:
                    listarJ(); // Método para listar jugadores
                    break;
                case 4:
                    editarJ(); // Método para editar un jugador
                    break;
                case 0:
                    salir = true; // Volver al menú principal 
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo."); // Mensaje de error
            }
        }
    }
    
    /**
     * Método para crear un nuevo jugador.
     * Solicita los datos necesarios al usuario y utiliza el gestor de jugadores
     * para agregar el nuevo jugador.
     */
    private static void crearJ()
    {
        // Solicita datos del jugador al usuario
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce los apellidos: ");
        String apellidos = scanner.nextLine();
        Date fechaNacimiento; // Variable para almacenar la fecha de nacimiento
        
        // Captura y procesa la fecha de nacimiento
        try {
            System.out.print("Introduce la fecha de nacimiento: ");
            String fechaInput = scanner.nextLine();
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInput);
        } catch (ParseException e) {
            // Manejo de la excepción en caso de un formato inválido
            e.printStackTrace();
            return; // Sale del método en caso de error
        }
        
        System.out.print("Introduce el correo electronico: ");
        String correo = scanner.nextLine();
        LocalDate fechaIns = LocalDate.now(); // Fecha de inscripción (fecha actual)
        
        // Intenta agregar el jugador a través del gestor
        int res = gestorJ.addJugador(nombre, apellidos, fechaNacimiento, fechaIns, correo);
        
        // Mensaje de resultado de la operación
        if(res != 1) {
            System.out.println("Error en la creación del jugador");
        } else {
            System.out.println("Jugador creado con éxito");
        }
    }
    
    /**
     * Método para listar todos los jugadores existentes.
     * Muestra una lista con los jugadores disponibles o un mensaje si no hay jugadores.
     */
    private static void listarJ()
    {
        List<JugadorDTO> jugadores = gestorJ.getAllJugadores(); // Obtiene la lista de jugadores
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles."); // Mensaje cuando no hay jugadores
        } else {
            System.out.println("Lista de jugadores:");
            for (JugadorDTO jugador : jugadores) {
                System.out.println(jugador.toString()); // Muestra cada jugador
            }
        }
    }
    
    /**
     * Método para borrar un jugador en base a su correo electrónico.
     * Solicita el correo del jugador a borrar y utiliza el gestor correspondiente.
     */
    private static void borrarJ()
    {
        System.out.print("Introduce el correo del jugador a borrar: ");
        String correo = scanner.nextLine(); // Captura el correo del jugador
        int res = gestorJ.deleteJugador(correo); // Intenta borrar el jugador
        
        // Mensajes para indicar el resultado de la operación
        if(res == -1) {
            System.out.println("Error en el borrado del jugador");
        } else if(res == 0) {
            System.out.println("El jugador no existe");
        } else {
            System.out.println("Jugador borrado con éxito");
        }
    }
    
    /**
     * Método para editar la información de un jugador.
     * Solicita el correo del jugador a editar y sus nuevos datos.
     */
    private static void editarJ()
    {
        // Solicita el correo y nuevos datos al usuario para la edición
        System.out.print("Introduce el correo del jugador a editar: ");
        String correo = scanner.nextLine();
        System.out.print("Introduce el nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce los nuevos apellidos: ");
        String apellidos = scanner.nextLine();
        Date fechaNacimiento; // Variable para almacenar la nueva fecha de nacimiento
        
        // Captura y procesa la nueva fecha de nacimiento
        try {
            System.out.print("Introduce la fecha de nacimiento: ");
            String fechaInput = scanner.nextLine();
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInput);
        } catch (ParseException e) {
            // Manejo de la excepción en caso de un formato inválido
            e.printStackTrace();
            return; // Sale del método en caso de error
        }
        
        // Intenta actualizar la información del jugador
        int res = gestorJ.updateJugador(nombre, apellidos, fechaNacimiento, correo);
        
        // Mensajes para indicar el resultado de la operación
        if(res == -1) {
            System.out.println("Error en la actualizacion del jugador");
        } else if(res == 0) {
            System.out.println("El jugador no existe");
        } else {
            System.out.println("Jugador editado con éxito");
        }
    }
}
