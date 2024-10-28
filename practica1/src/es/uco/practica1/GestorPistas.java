package es.uco.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase GestorPistas se encarga de gestionar una lista de pistas y materiales,
 * proporcionando métodos para añadir, modificar, listar pistas, y manejar materiales
 * asociados a las pistas.
 */
public class GestorPistas {

    /** Lista de pistas gestionadas por la clase */
    private List<Pista> pistas;

    /** Lista de materiales gestionados por la clase */
    private List<Material> materiales;

    /**
     * Constructor de la clase GestorPistas.
     * Inicializa las listas de pistas y materiales.
     */
    public GestorPistas() {
        this.pistas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }

    /**
     * Añade una nueva pista a la lista y guarda los cambios en el archivo.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de las pistas
     * @param pista Pista a añadir
     * @return true si la pista se añadió correctamente, false si la pista ya existe
     */
    public boolean addPista(String filePath, Pista pista) {
        FileManager fileMan = new FileManager();
        pistas = fileMan.cargarPistasDesdeArchivo(filePath);
        
        if (pistaExists(pista.getNombre())) {
            System.out.println("ERR: La pista ya existe");
            return false;
        }
        
        pistas.add(pista);
        fileMan.guardarPistasEnArchivo(filePath, pistas);
        System.out.println("Pista agregada con éxito");
        return true;
    }

    /**
     * Modifica los datos de una pista existente.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de las pistas
     * @param nombrePista Nombre de la pista a modificar
     */
    public void modPista(String filePath, String nombrePista) {
        FileManager fileMan = new FileManager();
        pistas = fileMan.cargarPistasDesdeArchivo(filePath);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < pistas.size(); i++) {
            if (pistas.get(i).getNombre().equals(nombrePista)) {
                // Detalles para modificar la pista
                System.out.print("Ingrese el nuevo estado (true/false): ");
                boolean estado = scanner.nextBoolean();

                System.out.print("Ingrese el nuevo tipo (true/false): ");
                boolean tipo = scanner.nextBoolean();

                System.out.print("Ingrese el nuevo tamaño: ");
                Enums.tamanio tamanio = Enums.tamanio.valueOf(scanner.next().toUpperCase());

                System.out.print("Ingrese el nuevo número máximo de jugadores: ");
                int jugadores = scanner.nextInt();

                // Actualizo la pista
                pistas.get(i).setEstado(estado);
                pistas.get(i).setTipo(tipo);
                pistas.get(i).setPista(tamanio);
                pistas.get(i).setJugadores_max(jugadores);

                break;
            }
        }
        fileMan.guardarPistasEnArchivo(filePath, pistas);
        System.out.println("Pista modificada con exito");
    }

    /**
     * Lista todas las pistas guardadas en el archivo especificado.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de las pistas
     * @return Lista de pistas
     */
    public List<Pista> listPistas(String filePath) {
        FileManager fileMan = new FileManager();
        return fileMan.cargarPistasDesdeArchivo(filePath);
    }

    /**
     * Comprueba si una pista con un determinado nombre existe en la lista de pistas.
     * 
     * @param nombre Nombre de la pista a buscar
     * @return true si la pista existe, false en caso contrario
     */
    private boolean pistaExists(String nombre) {
        for (Pista pista : pistas) {
            if (pista.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Crea un nuevo material y lo guarda en el archivo.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de los materiales
     * @param material Material a crear
     */
    public void crearMaterial(String filePath, Material material) {
        FileManager fileMan = new FileManager();
        materiales = fileMan.cargarMaterialesDesdeArchivo(filePath);
        materiales.add(material);
        fileMan.guardarMaterialesEnArchivo(filePath, materiales);
    }

    /**
     * Asocia un material a una pista específica.
     * 
     * @param nombrePista Nombre de la pista a la que se desea asociar el material
     * @param idMaterial ID del material a asociar
     * @return true si la asociación fue exitosa, false en caso contrario
     */
    public boolean asociarMaterialAPista(String nombrePista, int idMaterial) {
        Pista pista = buscarPista(nombrePista);
        Material material = buscarMaterial(idMaterial);
        
        if (pista != null && material != null) {
            if (material.getStatus() == Enums.estado.DISPONIBLE) {
                pista.asociarMaterialAPista(material);
                material.setStatus(Enums.estado.RESERVADO);
                return true;  // Asociación exitosa
            }
        }
        return false;  // Error en la asociación
    }

    /**
     * Busca una pista por su nombre.
     * 
     * @param nombre Nombre de la pista a buscar
     * @return Pista encontrada, o null si no se encuentra
     */
    private Pista buscarPista(String nombre) {
        for (Pista pista : pistas) {
            if (pista.getNombre().equals(nombre)) {
                return pista;
            }
        }
        return null;
    }

    /**
     * Busca un material por su ID.
     * 
     * @param id ID del material a buscar
     * @return Material encontrado, o null si no se encuentra
     */
    private Material buscarMaterial(int id) {
        for (Material material : materiales) {
            if (material.getId() == id) {
                return material;
            }
        }
        return null;
    }
}
