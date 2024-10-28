package es.uco.practica1;

import java.util.*;

/**
 * La clase GestorReservas gestiona una lista de reservas proporcionando métodos para añadir,
 * modificar, cancelar reservas y consultar reservas futuras o por día y pista específica.
 */
public class GestorReservas {
    /** Lista de reservas gestionadas por la clase */
    private List<Reserva> reservas;
    /** Contador de IDs para asignar IDs únicos a las reservas */
    private int idCounter;

    /**
     * Constructor de la clase GestorReservas.
     * Inicializa la lista de reservas y el contador de IDs.
     */
    public GestorReservas() {
        this.reservas = new ArrayList<>();
        this.idCounter = 1; // Inicia el contador de IDs para las reservas
    }

    /**
     * Añade una nueva reserva a la lista y guarda los cambios en el archivo.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de las reservas
     * @param reserva Reserva a añadir
     * @return true si la reserva se añadió correctamente
     */
    public boolean addReserva(String filePath, Reserva reserva) {
        FileManager fileMan = new FileManager();
        reservas = fileMan.cargarReservasDesdeArchivo(filePath);
        
        reservas.add(reserva);
        fileMan.guardarReservasEnArchivo(filePath, reservas);
        System.out.println("Reserva agregada con éxito");
        return true;
    }

    /**
     * Modifica una reserva existente.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de las reservas
     * @param idReserva ID de la reserva a modificar
     * @return true si la modificación fue exitosa, false si no se encontró la reserva
     */
    public boolean modReserva(String filePath, int idReserva) {
        FileManager fileMan = new FileManager();
        reservas = fileMan.cargarReservasDesdeArchivo(filePath);

        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                // Modificaciones de la reserva
                // Aquí se pueden pedir nuevos valores usando Scanner o predeterminados
                // por simplicidad, solo cambio la fecha y notificar que se ha modificado
                reserva.setFecha(new Date(/* nueva fecha a establecer */));
                fileMan.guardarReservasEnArchivo(filePath, reservas);
                System.out.println("Reserva modificada con éxito");
                return true; // Modificación exitosa
            }
        }
        System.out.println("Reserva no encontrada.\n");
        return false; // Reserva no encontrada
    }

    /**
     * Cancela una reserva existente.
     * 
     * @param filePath Ruta del archivo donde se almacenan los datos de las reservas
     * @param idReserva ID de la reserva a cancelar
     * @return true si la cancelación fue exitosa, false si no se encontró la reserva o si no se puede cancelar con menos de 24 horas de antelación
     */
    public boolean cancelarReserva(String filePath, int idReserva) {
        Iterator<Reserva> it = reservas.iterator();
        while (it.hasNext()) {
            Reserva reserva = it.next();
            if (reserva.getId() == idReserva) {
                long diff = reserva.getFecha().getTime() - new Date().getTime();
                if (diff > 24 * 60 * 60 * 1000) {
                    it.remove();
                    FileManager fileMan = new FileManager();
                    fileMan.guardarReservasEnArchivo(filePath, reservas);
                    System.out.println("Reserva cancelada con éxito");
                    return true;
                } else {
                    System.out.println("No se puede cancelar la reserva con menos de 24 horas de antelación.\n");
                    return false;
                }
            }
        }
        System.out.println("Reserva no encontrada.\n");
        return false; // Reserva no encontrada
    }

    /**
     * Consulta el número de reservas futuras.
     * 
     * @return Número de reservas futuras
     */
    public int contarReservasFuturas() {
        int count = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getFecha().after(new Date())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Consulta las reservas de un día y una pista específica.
     * 
     * @param fecha Fecha de las reservas a consultar
     * @param idPista ID de la pista de las reservas a consultar
     * @return Lista de reservas que coinciden con la fecha y pista especificadas
     */
    public List<Reserva> consultarReservasPorDiaYPista(Date fecha, int idPista) {
        List<Reserva> reservasFiltradas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getFecha().equals(fecha) && reserva.getIdPista() == idPista) {
                reservasFiltradas.add(reserva);
            }
        }
        return reservasFiltradas;
    }
}
