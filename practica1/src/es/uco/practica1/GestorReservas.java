package es.uco.practica1;

/**
 * GestorReservas class
 * @author Miriam Prado Martínez
 * */

import java.util.*;

public class GestorReservas {
    private List<Reserva> reservas;
    private int idCounter;

    public GestorReservas() {
        this.reservas = new ArrayList<>();
        this.idCounter = 1; // Inicia el contador de IDs para las reservas
    }

    // Método para crear una reserva individual:
    public Reserva crearReservaIndividual(int duracion, int idpista, float precio, float descuento, Date fecha, int participantes, Usuario usuario) {
        // Comprobar si el usuario está registrado:
        if (!usuario.isRegistrado()) {
            System.out.println("El usuario no está registrado.");
            return null;
        }

        // Comprobar la antigüedad para aplicar descuento:
        if (usuario.getAntiguedad() > 2) {
            descuento += 10; // Aplicar 10% de descuento
        }

        Reserva reserva = new ReservaAdultos(idCounter++, duracion, idpista, precio, descuento, fecha, participantes);
        reservas.add(reserva);
        return reserva;
    }

    // Método para crear una reserva dentro de un bono:
    public Reserva crearReservaBono(int duracion, int idpista, float precio, Date fecha, Usuario usuario, int tipoReserva) {
        // Comprobar que el usuario está registrado y que no έχει alcanzado el límite de reservas:
        if (!usuario.isRegistrado()) {
            System.out.println("El usuario no está registrado.");
            return null;
        }

        // Verificar que el bono tiene sesiones disponibles y el tipo coincide:
        if (!usuario.getBono().tieneSesionesDisponibles()) {
            System.out.println("El bono no tiene sesiones disponibles.");
            return null;
        }

        int participants = usuario.getBono().getParticipantesParaTipo(tipoReserva);
        // Crear reserva en función del tipo de bono:
        Reserva reserva = null;

        if (tipoReserva == 1) { // Reserva Infantil
            reserva = new ReservaInfantil(idCounter++, duracion, idpista, precio, 0, fecha, participants);
        } else if (tipoReserva == 2) { // Reserva Adultos
            reserva = new ReservaAdultos(idCounter++, duracion, idpista, precio * 0.95f, 0, fecha, participants);
        } else if (tipoReserva == 3) { // Reserva Familiar
            reserva = new ReservaFamiliar(idCounter++, duracion, idpista, precio * 0.95f, 0, fecha, participants, 0);
        }

        if (reserva != null) {
            reservas.add(reserva);
            usuario.getBono().usarSesion();
        }

        return reserva;
    }

    // Método para modificar una reserva:
    public boolean modificarReserva(int idReserva, Date nuevaFecha, int nuevaDuracion, int nuevaIdPista) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                long diff = nuevaFecha.getTime() - reserva.getFecha().getTime();
                if (diff > 24 * 60 * 60 * 1000) { // Comprobar que quedan más de 24 horas
                    reserva.setfecha(nuevaFecha);
                    reserva.setDuracion(nuevaDuracion);
                    reserva.setIdPista(nuevaIdPista);
                    return true;
                } else {
                    System.out.println("No se puede modificar la reserva con menos de 24 horas de antelación.");
                    return false;
                }
            }
        }
        System.out.println("Reserva no encontrada.");
        return false;
    }

    // Método para cancelar una reserva:
    public boolean cancelarReserva(int idReserva) {
        Iterator<Reserva> it = reservas.iterator();
        while (it.hasNext()) {
            Reserva reserva = it.next();
            if (reserva.getId() == idReserva) {
                long diff = reserva.getFecha().getTime() - new Date().getTime();
                if (diff > 24 * 60 * 60 * 1000) {
                    it.remove();
                    return true;
                } else {
                    System.out.println("No se puede cancelar la reserva con menos de 24 horas de antelación.");
                    return false;
                }
            }
        }
        return false;
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
