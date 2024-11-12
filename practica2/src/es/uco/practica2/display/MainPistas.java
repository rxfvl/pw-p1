package es.uco.practica2.display;

import java.util.List;
import java.util.Scanner;
import es.uco.practica2.business.*;

public class MainPistas {
	private static GestorPistas gestorPistas;
    private static Scanner scanner;
    
    private GestorPistas gestorP = new GestorPistas();

    public void main(String[] args) {
        scanner = new Scanner(System.in);
        gestorPistas = new GestorPistas(); // Inicia el gestor de pistas

        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- Gestión de Pistas ---");
            System.out.println("1. Crear Pista");
            System.out.println("2. Listar Pistas");
            System.out.println("3. Asociar Material a Pista");
            System.out.println("4. Borrar Pista");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearP();
                    break;
                case 2:
                    listarP();
                    break;
                case 3:
                    asociarMat();
                    break;
                case 4:
                	borrarP();
                	break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }

    private void crearP() {
        System.out.print("Nombre de la pista: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Estado (true para disponible, false para no disponible): ");
        boolean estado = scanner.nextBoolean();
        
        System.out.print("Tipo de pista (true para interior, false para tipo exterior): ");
        boolean tipo = scanner.nextBoolean();
        
        System.out.print("Tamaño de la pista (1 para MINIBASKET, 2 para ADULTOS, 3 para TRES_VS_TRES): ");
        int tamanio = scanner.nextInt();

        System.out.print("Número máximo de jugadores: ");
        int jugadores = scanner.nextInt();
        
        gestorP.crearPista(nombre, estado, tipo, tamanio, jugadores);
    }

    private void listarP() {
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

    private void asociarMat() {
        
    }
    
    private void borrarP() {
    	int op = 0, res = 0, id = -1;
    	String nombre = null;
    	while(op != 1 || op != 2)
    	{
    		System.out.println("Borrar por ID (1) o por nombre (2): ");
        	op = scanner.nextInt();
        	
        	switch(op) 
        	{
        		case 1:
        			System.out.println("Introduce el id: ");
        			id = scanner.nextInt();
        			break;
        		case 2:
        			System.out.println("Introduce el nombre: ");
        			nombre = scanner.nextLine();
        			break;
        		default:
        			System.out.println("Opción no válida. Por favor intenta de nuevo.");
        	}
    	}
    	
    	res = gestorP.borrarPista(id, nombre);
    	
    	if(res == -1) {System.out.println("La pista introducida no existe");}
    	else {System.out.println("Pista borrada con éxito");}
    }
}
