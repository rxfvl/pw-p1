package es.uco.practica2.display;

import java.util.List; 
import java.util.Scanner; 
import es.uco.practica2.business.*;

/**
 * Clase MainPistas
 * 
 * Esta clase proporciona una interfaz de consola para gestionar pistas y materiales.
 * Permite crear, listar, borrar pistas y gestionar materiales asociados a ellas.
 * Utiliza el patrón de diseño controlador, donde el flujo del programa es gestionado
 * a través de un menú interactivo.
 */
public class MainPistas {

    // Scanner para entrada de datos
    private static Scanner scanner;
    // GestorPistas para manejar operaciones sobre pistas
    private static GestorPistas gestorP;

    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        gestorP = new GestorPistas(); // Inicia el gestor de pistas

        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- Gestión de Pistas ---");
            System.out.println("1. Crear Pista");
            System.out.println("2. Listar Pistas");
            System.out.println("3. Borrar Pista");
            System.out.println("4. Opciones de materiales");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearP(); // LLamada al método para crear pista
                    break;
                case 2:
                    listarP(); // LLamada al método para listar pistas
                    break;
                case 3:
                    borrarP(); // Llamada al método para borrar pista
                    break;
                case 4:
                    materiales(); // Llamada al método para gestionar materiales
                    break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }

    /**
     * Menú para gestionar materiales asociados a las pistas.
     */
    private static void materiales() {
        boolean salir = false;
        int op;
        
        while(!salir) {
            System.out.println("1. Crear Material");
            System.out.println("2. Asociar Material a Pista");
            System.out.println("3. Borrar Material");
            System.out.println("4. Listar Materiales");
            System.out.println("0. Volver");
            op = scanner.nextInt();
            
            switch(op) {
                case 1:
                    crearM(); // LLamada al método para crear un material
                    break;
                case 2:
                    asociarM(); // LLamada al método para asociar un material a una pista
                    break;
                case 3:
                    borrarM(); // LLamada al método para borrar un material
                    break;
                case 4:
                    listarM(); // LLamada al método para listar materiales
                    break;
                case 0:
                    salir = true; //Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }

    /**
     * Método para crear una nueva pista.
     * Se solicitan los datos necesarios y se llama al gestor para realizar la creación.
     */
    private static void crearP() {
        int res;
        
        System.out.print("Nombre de la pista: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Estado (1 para DISPONIBLE, 2 para NO DISPONIBLE): ");
        int estado = scanner.nextInt();
        
        System.out.print("Tipo de pista (1 para INTERIOR, 2 para EXTERIOR): ");
        int tipo = scanner.nextInt();
        
        System.out.print("Tamaño de la pista (1 para MINIBASKET, 2 para ADULTOS, 3 para TRES_VS_TRES): ");
        int tamanio = scanner.nextInt();

        System.out.print("Número máximo de jugadores: ");
        int jugadores = scanner.nextInt();
        
        res = gestorP.crearPista(nombre, estado, tipo, tamanio, jugadores);
        
        if (res == -1) {
            System.out.println("Error en la creación de la pista");
        } else {
            System.out.println("Pista creada con éxito");
        }
    }

    /**
     * Método para listar todas las pistas disponibles.
     * Muestra la información de cada pista en consola.
     */
    private static void listarP() {
        List<PistaDTO> pistas = gestorP.ListarPistas();
        if (pistas.isEmpty()) {
            System.out.println("No hay pistas disponibles.");
        } else {
            System.out.println("Lista de pistas:");
            for (PistaDTO pista : pistas) {
                System.out.println(pista.toString());
            }
        }
    }

    /**
     * Método para borrar una pista existente.
     * Solicita el nombre de la pista y llama al gestor para eliminarla.
     */
    private static void borrarP() {
        int res;
        String nombre;
        
        System.out.print("Introduce el nombre de la pista: ");
        nombre = scanner.nextLine();
        
        res = gestorP.borrarPista(nombre);
        
        if(res == 0) {
            System.out.println("La pista introducida no existe");
        } else {
            System.out.println("Pista borrada con éxito");
        }
    }

    /**
     * Método para crear un nuevo material.
     * Solicita los parámetros del material y llama al gestor para realizar la creación.
     */
    private static void crearM() {
        int mat, uso, estado, res;
        
        System.out.print("Tipo de material (1 para CANASTAS, 2 para CONOS, 3 para PELOTAS): ");
        mat = scanner.nextInt();
        
        System.out.print("Uso del material (1 para INTERIOR, 2 para EXTERIOR): ");
        uso = scanner.nextInt();
        
        System.out.print("Estado del material (1 para DISPONIBLE, 2 para RESERVADO, 3 para MALESTADO): ");
        estado = scanner.nextInt();
        
        res = gestorP.crearMat(mat, uso, estado);
        
        if (res == 1) {
            System.out.println("Material creado con éxito");
        } else {
            System.out.println("Error en la creación del Material");
        }
    }

    /**
     * Método para asociar un material a una pista.
     * Solicita el tipo y uso del material y el nombre de la pista para asociarlo.
     */
    private static void asociarM() {    	
        System.out.print("Tipo de material a asociar (1 para CANASTAS, 2 para CONOS, 3 para PELOTAS): ");
        int tipo = scanner.nextInt();
        System.out.print("Uso del material (1 para INTERIOR, 2 para EXTERIOR): ");
        int uso = scanner.nextInt();
        System.out.print("Nombre de la pista a la que asociarlo: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        
        int res = gestorP.asociar(nombre, tipo, uso);
        
        if(res == 0){
            System.out.println("La pista indicada no existe");
        } else if(res == -1){
            System.out.println("La pista ha alcanzado el número máximo de materiales de ese tipo");
        } else {
            System.out.println("Material asociado con éxito");
        }
    }

    /**
     * Método para borrar un material existente.
     * Se solicita el tipo de material y se llama al gestor para permitir su eliminación.
     */
    private static void borrarM() {    	
        System.out.print("Tipo de material a borrar (1 para CANASTAS, 2 para CONOS, 3 para PELOTAS): ");
        int tipo = scanner.nextInt();
        
        int res = gestorP.borrarMat(tipo);
        
        if(res == 0) {
            System.out.print("No existe el material");
        } else {
            System.out.println("Material borrado con éxito");
        }
    }

    /**
     * Método para listar todos los materiales disponibles.
     * Muestra la información de cada material en consola.
     */
    private static void listarM() {
        List<MaterialDTO> materiales = gestorP.ListarMat();
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales disponibles.");
        } else {
            System.out.println("Lista de materiales:");
            for (MaterialDTO mat : materiales) {
                System.out.println(mat.toString());
            }
        }
    }
}
