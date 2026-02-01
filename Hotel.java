import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    public void agregarHabitacion(Habitacion h){
        this.habitaciones.add(h);
    }
    public void crearReserva(String nombre, String dni, double telefono, LocalDate salida, String tipo) {
        Habitacion disponible = null;
        for (Habitacion h : habitaciones) {
        if (h.getEstado() == EstadoHabitacion.DISPONIBLE) {
                disponible = h;
                break;
        }
    }
    if (disponible != null) {
            Cliente cliente = new Cliente(dni, nombre, telefono);
            String idReserva = "RES-" + (reservas.size() + 1);
             Reserva nueva = new Reserva(idReserva, cliente, disponible, entrada, salida);
            
            reservas.add(nueva);
            disponible.setEstado(EstadoHabitacion.OCUPADA);
            System.out.println("Reserva creada con éxito: " + idReserva);
        } else {
            System.out.println("No hay habitaciones disponibles de ese tipo.");
        }
    }

    public Reserva buscarReservaPorId(String id) {
        for (Reserva r : reservas) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public void cancelarReserva(String id) {
        Reserva r = buscarReservaPorId(id);
        if (r != null) {
            r.cancelar();
        }
    }

    public Ticket generarTicket(String idReserva) {
        Reserva r = buscarReservaPorId(idReserva);
        if (r != null) {
            return new Ticket(idReserva, r);
        }
        return null;
    }
}
