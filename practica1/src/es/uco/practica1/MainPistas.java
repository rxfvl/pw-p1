package es.uco.practica1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class MainPistas {
    
    private static GestorPistas gestorPistas;
    private static Scanner scanner;

    public static void main(String[] args) {
    	Properties propiedades = new Properties();
        
        // Cargar propiedades del fichero
        try (InputStream input = new FileInputStream("config.properties")) 
        {
            propiedades.load(input);
        } catch (IOException ex) 
        {
            System.out.println("Error al cargar las propiedades: " + ex.getMessage());
            return;
        }
    	
        scanner = new Scanner(System.in);
        gestorPistas = new GestorPistas(propiedades.getProperty("pistasFile")); // Inicia el gestor de pistas

        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- Gestión de Pistas ---");
            System.out.println("1. Crear Pista");
            System.out.println("2. Listar Pistas");
            System.out.println("3. Asociar Material a Pista");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearPista();
                    break;
                case 2:
                    gestorPistas.listPistas(gestorPistas.getPath());
                    break;
                case 3:
                    asociarMaterialAPista();
                    break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }

    private static void crearPista() {
        System.out.print("Nombre de la pista: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Estado (true para disponible, false para no disponible): ");
        boolean estado = scanner.nextBoolean();
        
        System.out.print("Tipo de pista (true para interior, false para tipo exterior): ");
        boolean tipo = scanner.nextBoolean();
        
        System.out.print("Tamaño de la pista (1 para MINIBASKET, 2 para ADULTOS, 3 para TRES_VS_TRES): ");
        int tamanioInput = scanner.nextInt();
        Enums.tamanio tamanio = Enums.tamanio.NONE;
        switch (tamanioInput) {
            case 1: tamanio = Enums.tamanio.MINIBASKET; break;
            case 2: tamanio = Enums.tamanio.ADULTOS; break;
            case 3: tamanio = Enums.tamanio.TRES_VS_TRES; break;
        }

        System.out.print("Número máximo de jugadores: ");
        int jugadores = scanner.nextInt();

        Pista pista = new Pista(nombre, estado, tipo, tamanio, jugadores); // CAMBIAR
        
        gestorPistas.addPista(gestorPistas.getPath(), pista);
    }


    private static void asociarMaterialAPista() {
        System.out.print("Nombre de la pista: ");
        String nombrePista = scanner.nextLine();

        System.out.print("ID del material: ");
        int idMaterial = scanner.nextInt();

        boolean resultado = gestorPistas.asociarMaterialAPista(nombrePista, idMaterial);
        if (resultado) {
            System.out.println("Material asociado a la pista con éxito.");
        } else {
            System.out.println("No se pudo asociar el material a la pista. Verifica que la pista y el material existen y están disponibles.");
        }
    }
}