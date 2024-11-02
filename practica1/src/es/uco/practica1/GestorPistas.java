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
    private String pathMat;
    private String path;
	private List<Pista> pistas;

    /** Lista de materiales gestionados por la clase */
    private List<Material> materiales;

    /**
     * Constructor de la clase GestorPistas.
     * Inicializa las listas de pistas y materiales.
     */
    public GestorPistas(String path, String pathMat) {
    	this.path = path;
    	this.pathMat = pathMat;
        this.pistas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }

    
    
    public String getPath()
    {
    	return this.path;
    }
    
    public void setPath(String path)
    {
    	this.path = path;
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
        boolean existe = pistaExists(pista.getNombre());
        if (existe) {
            System.out.println("ERR: La pista ya existe");
            pistas.clear();
            return false;
        }
        
        pistas.add(pista);
        fileMan.guardarPistasEnArchivo(filePath, pistas);
        pistas.clear();
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
        pistas.clear();
        System.out.println("Pista modificada con exito");
        scanner.close();
    }

    /**
     * Lista todas las pistas guardadas en el archivo especificado.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de las pistas
     * @return Lista de pistas
     */
    public void listPistas(String filePath) {
        FileManager fileMan = new FileManager();
        System.out.println(fileMan.readFile(filePath));
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
        if (buscarMaterial(material.getId()) != null)
        {
        	System.out.println("ERR: Material ya existe");
        }
        else
        {
        	materiales.add(material);
            fileMan.guardarMaterialesEnArchivo(filePath, materiales);
            System.out.println("Material creado con éxito");
        }
        
    }

    /**
     * Asocia un material a una pista específica.
     * 
     * @param nombrePista Nombre de la pista a la que se desea asociar el material
     * @param idMaterial ID del material a asociar
     * @return true si la asociación fue exitosa, false en caso contrario
     */
    public boolean asociarMaterialAPista(String nombrePista, int idMaterial) {
    	FileManager fileMan = new FileManager();
    	pistas = fileMan.cargarPistasDesdeArchivo(this.path);
    	materiales = fileMan.cargarMaterialesDesdeArchivo(this.pathMat);
    	
        Pista pista = buscarPista(nombrePista);
        Material material = buscarMaterial(idMaterial);
        Scanner scanner = new Scanner(System.in);
        
        if (material == null)
        {        	
        	System.out.println("El material introducido no existe, ¿desea crearlo? S/n");
        	String opt = scanner.nextLine().toLowerCase();
        	while (!opt.equals("s") && !opt.equals("n"))
        	{
        		System.out.println("Opcion incorrecta, por favor introduzca S o N");
        		opt = scanner.nextLine().toLowerCase();
        	}
        	if (opt.equals("s"))
        	{
        		material = new Material();
        		System.out.println("Intruduzca el Id");
        		int id = scanner.nextInt();
        		material.setId(id);
        		scanner.nextLine(); //Limpiar buffer
        		
        		System.out.println("Introduzca el tipo (Pelotas, canastas o conos)");
        		String tipo = scanner.nextLine().toLowerCase();
        		while (!tipo.equals("pelotas") && !tipo.equals("canastas") && !tipo.equals("conos") && !tipo.equals("none"))
        		{
        			System.out.println("Tipo incorrecto, introduzca pelotas, canastas o conos (None para no establecer ninguno)");
        			tipo = scanner.nextLine().toLowerCase();
        		}
        		if (tipo.equals("pelotas"))
        		{
        			material.setType(Enums.tipo.PELOTAS);
        		}
        		else if (tipo.equals("canastas"))
        		{
        			material.setType(Enums.tipo.CANASTAS);
        		}
        		else if (tipo.equals("conos"))
        		{
        			material.setType(Enums.tipo.CONOS);
        		}
        		else if (tipo.equals("none"))
        		{
        			material.setType(Enums.tipo.NONE);
        		}
        		
        		System.out.println("Introduzca el estado (Disponible, reservado o malestado)");
        		String estado = scanner.nextLine().toLowerCase();
        		while (!estado.equals("disponible") && !estado.equals("reservado") && !estado.equals("malestado") && !estado.equals("none"))
        		{
        			System.out.println("Estado incorrecto, introduzca disponible, reservado o malestado (None para no establecer ninguno)");
        			estado = scanner.nextLine().toLowerCase();
        		}
        		if (estado.equals("disponible"))
        		{
        			material.setStatus(Enums.estado.DISPONIBLE);
        		}
        		else if (estado.equals("reservado"))
        		{
        			material.setStatus(Enums.estado.RESERVADO);
        		}
        		else if (estado.equals("malestado"))
        		{
        			material.setStatus(Enums.estado.MALESTADO);
        		}
        		else if (estado.equals("none"))
        		{
        			material.setStatus(Enums.estado.NONE);
        		}
        		
        		System.out.println("Introduzca el uso (interior o exterior)");
        		String uso = scanner.nextLine().toLowerCase();
        		while (!uso.equals("interior") && !uso.equals("exterior"))
        		{
        			System.out.println("Uso incorrecto, introduzca interior o exterior (None para no establecer ninguno)");
        			uso = scanner.nextLine().toLowerCase();
        		}
        		if (uso.equals("interior"))
        		{
        			material.setMaterialUse(true);
        		}
        		else material.setMaterialUse(false);
        		
        		crearMaterial(this.pathMat, material);
        		
        	}
        }
        
        System.out.println(pista);
        System.out.println(material);
        
        
        if (pista != null && material != null) {
            if (material.getStatus() == Enums.estado.DISPONIBLE) {
                pista.asociarMaterialAPista(material);
                material.setStatus(Enums.estado.RESERVADO);
                fileMan.guardarPistasEnArchivo(this.path, pistas);
                pistas.clear();
                materiales.clear();
                return true;  // Asociación exitosa
            }
        }
        pistas.clear();
        materiales.clear();
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



	public String getPathMat() {
		return pathMat;
	}



	public void setPathMat(String pathMat) {
		this.pathMat = pathMat;
	}
}
