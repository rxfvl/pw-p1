package es.uco.practica2.display;

import java.util.List;
import java.util.Scanner;
import es.uco.practica2.business.*;

public class MainPistas {
	
    private static Scanner scanner;
    private static GestorPistas gestorP;

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
                    crearP();
                    break;
                case 2:
                    listarP();
                    break;
                case 3:
                	borrarP();
                    break;
                case 4:
                	materiales();
                	break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }
    
    private static void materiales()
    {
    	boolean salir = false;
    	int op;
    	
    	while(!salir)
    	{
    		System.out.println("1. Crear Material");
            System.out.println("2. Asociar Material a Pista");
            System.out.println("3. Borrar Material");
            System.out.println("0. Volver");
            op = scanner.nextInt();
            
            switch(op)
            {
            	case 1:
            		crearM();
            		break;
            	case 2:
            		asociarM();
            		break;
            	case 3:
            		borrarM();
            		break;
            	case 0:
            		salir = true;
            		break;
            	default:
            		System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
    	}
    }

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
       
       if (res != 0) {System.out.println("Pista creada con éxito");}
       else {System.out.println("Error en la creación de la pista");}
    }

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
    
    private static void borrarP() {
    	int res;
    	String nombre;
    	
    	System.out.print("Introduce el nombre de la pista: ");
    	nombre = scanner.nextLine();
    	
    	res = gestorP.borrarPista(nombre);
    	
    	if(res == 0) {System.out.println("La pista introducida no existe");}
    	else {System.out.println("Pista borrada con éxito");}
    }
    
    private static void crearM()
    {
    	int mat, uso, estado, res;
    	
    	System.out.print("Tipo de material (1 para CANASTAS, 2 para CONOS, 3 para PELOTAS): ");
    	mat = scanner.nextInt();
    	
    	System.out.print("Uso del material (1 para INTERIOR, 2 para EXTERIOR)");
    	uso = scanner.nextInt();
    	
    	System.out.print("Estado del material (1 para DISPONIBLE, 2 para RESERVADO, 3 para MALESTADO)");
    	estado = scanner.nextInt();
    	
    	res = gestorP.crearMat(mat, uso, estado);
    	
    	if (res == 1) {System.out.println("Material creado con éxito");}
    	else {System.out.println("Error en la creación del Material");}
    }
    
    private static void asociarM()
    {
    	int tipo, uso, estado, res;
    	String nombre;
    	
    	System.out.print("Tipo de material a asociar (1 para CANASTAS, 2 para CONOS, 3 para PELOTAS):");
    	tipo = scanner.nextInt();
    	System.out.print("Uso del material (1 para INTERIOR, 2 para EXTERIOR)");
    	uso = scanner.nextInt();
    	System.out.print("Estado del material (1 para DISPONIBLE, 2 para RESERVADO, 3 para MALESTADO)");
    	estado = scanner.nextInt();
    	System.out.print("Nombre de la pista a la que asociarlo: ");
    	nombre = scanner.nextLine();
    	
    	res = gestorP.asociar(nombre, tipo, uso, estado);
    	
    	if(res == 0){System.out.println("La pista indicada no existe");}
    	else if(res == -1){System.out.println("La pista ha alcanzado el número máximo de materiales de ese tipo");}
    	else{System.out.println("Material asociado con éxito");}
    }
    
    private static void borrarM()
    {
    	int tipo, res;
    	
    	System.out.print("Tipo de material a borrar (1 para CANASTAS, 2 para CONOS, 3 para PELOTAS):");
    	tipo = scanner.nextInt();
    	
    	res = gestorP.borrarMat(tipo);
    	
    	if(res == 0){System.out.print("No existe el material");}
    	else{System.out.print("Material borrado con éxito");}
    }
}
