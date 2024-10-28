package es.uco.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPistas {
    
    private List<Pista> pistas;
    private List<Material> materiales;

    public GestorPistas() {
        this.pistas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }

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

    public List<Pista> listPistas(String filePath) {
        FileManager fileMan = new FileManager();
        return fileMan.cargarPistasDesdeArchivo(filePath);
    }

    private boolean pistaExists(String nombre) {
        for (Pista pista : pistas) {
            if (pista.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    // Métodos adicionales para manejar materiales y asociarlos
    public void crearMaterial(String filePath, Material material) {
        FileManager fileMan = new FileManager();
        materiales = fileMan.cargarMaterialesDesdeArchivo(filePath);
        materiales.add(material);
        fileMan.guardarMaterialesEnArchivo(filePath, materiales);
    }

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

    private Pista buscarPista(String nombre) {
        for (Pista pista : pistas) {
            if (pista.getNombre().equals(nombre)) {
                return pista;
            }
        }
        return null;
    }

    private Material buscarMaterial(int id) {
        for (Material material : materiales) {
            if (material.getId() == id) {
                return material;
            }
        }
        return null;
    }
}
