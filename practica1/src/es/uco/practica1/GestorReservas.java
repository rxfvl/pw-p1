package es.uco.practica1;

import java.util.*;

public class GestorReservas {
    private List<Reserva> reservas;
    private int idCounter;

    public GestorReservas() {
        this.reservas = new ArrayList<>();
        this.idCounter = 1; // Inicia el contador de IDs para las reservas
    }

    public boolean addReserva(String filePath, Reserva reserva) {
        FileManager fileMan = new FileManager();
        reservas = fileMan.cargarReservasDesdeArchivo(filePath);
        
        reservas.add(reserva);
        fileMan.guardarReservasEnArchivo(filePath, reservas);
        System.out.println("Reserva agregada con éxito");
        return true;
    }

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

    // Método para consultar el número de reservas futuras:
    public int contarReservasFuturas() {
        int count = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getFecha().after(new Date())) {
                count++;
            }
        }
        return count;
    }

    // Método para consultar las reservas de un día y una pista específica:
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
