package es.uco.practica1;

/**
 * GestorPistas class
 * @author Miriam Prado Martínez
 * */

import java.util.ArrayList;
import java.util.List;
import es.uco.practica1.Enums;

public class GestorPistas {
    
    private List<Pista> pistas;
    private List<Material> materiales;

    public GestorPistas() {
        this.pistas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }

    // Crear pistas:
    public void crearPista(String nombre, boolean estado, boolean tipo, Enums.tamanio tamanio, int jugadores) {
        Pista pista = new Pista(nombre, estado, tipo, tamanio, jugadores);
        pistas.add(pista);
    }

    // Crear materiales:
    public void crearMaterial(int id, Enums.tipo type, boolean usoMaterial, Enums.estado status) {
        Material material = new Material(id, type, usoMaterial, status);
        materiales.add(material);
    }

    // Asociar materiales a pistas:
    public boolean asociarMaterialAPista(String nombrePista, int idMaterial) {
        Pista pista = buscarPista(nombrePista);
        Material material = buscarMaterial(idMaterial);
        
        if (pista != null && material != null) {
            if (material.getStatus() == Enums.estado.DISPONIBLE) {
                pista.asociarMaterialAPista(material);
                material.getStatus();  // Cambiar el estado del material a otro (por ejemplo, RESERVADO o MALESTADO)
                return true;  // Asociación exitosa
            }
        }
        return false;  // Error en la asociación
    }

    // Listar pistas no disponibles:
    public List<Pista> listarPistasNoDisponibles() {
        List<Pista> noDisponibles = new ArrayList<>();
        for (Pista pista : pistas) {
            if (!pista.getEstado()) {
                noDisponibles.add(pista);
            }
        }
        return noDisponibles;
    }

    // Obtener pistas libres según número de jugadores y tipo de pista:
    public List<Pista> obtenerPistasLibres(int numJugadores, boolean tipoPista) {
        List<Pista> libres = new ArrayList<>();
        for (Pista pista : pistas) {
            if (pista.getEstado() && pista.getTipo() == tipoPista && pista.getJugadores_max() >= numJugadores) {
                libres.add(pista);
            }
        }
        return libres;
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
