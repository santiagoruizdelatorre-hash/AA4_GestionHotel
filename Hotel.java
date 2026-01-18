import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    private int contadorReservas = 1;
    private int contadorTickets = 1;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    public ResultadoOperacion crearReserva(String nombre, String dni, String telefono,
                                           LocalDate entrada, LocalDate salida, String tipo) {

        if (nombre == null || nombre.trim().isEmpty() ||
            dni == null || dni.trim().isEmpty() ||
            telefono == null || telefono.trim().isEmpty()) {
            return new ResultadoOperacion(false, "Datos del cliente inválidos.");
        }

        if (entrada == null || salida == null || !salida.isAfter(entrada)) {
            return new ResultadoOperacion(false, "Fechas inválidas. La salida debe ser posterior a la entrada.");
        }

        Habitacion libre = buscarHabitacionDisponible(tipo);
        if (libre == null) {
            return new ResultadoOperacion(false, "No hay habitaciones disponibles de tipo " + tipo);
        }

        Cliente c = new Cliente(dni.trim(), nombre.trim(), telefono.trim());
        String id = "R" + contadorReservas++;
        Reserva r = new Reserva(id, c, libre, entrada, salida);

        // Confirmamos directamente para simplificar (puedes dejarlo en PENDIENTE si quieres)
        r.confirmar();
        reservas.add(r);

        return new ResultadoOperacion(true, "Reserva creada y confirmada. ID: " + id);
    }

    private Habitacion buscarHabitacionDisponible(String tipo) {
        if (tipo == null) return null;
        String t = tipo.trim().toLowerCase();

        for (Habitacion h : habitaciones) {
            if (h.getEstado() != EstadoHabitacion.DISPONIBLE) continue;

            if (t.equals("simple") && (h instanceof HabitacionSimple)) return h;
            if (t.equals("doble") && (h instanceof HabitacionDoble)) return h;
            if (t.equals("suite") && (h instanceof HabitacionSuite)) return h;
        }
        return null;
    }

    public Reserva buscarReservaPorId(String id) {
        if (id == null) return null;
        for (Reserva r : reservas) {
            if (r.getId().equalsIgnoreCase(id.trim())) return r;
        }
        return null;
    }

    public ResultadoOperacion comprobarReserva(LocalDate dia, String id) {
        if (dia == null || id == null || id.trim().isEmpty()) {
            return new ResultadoOperacion(false, "Datos inválidos para comprobar reserva.");
        }

        Reserva r = buscarReservaPorId(id);
        if (r == null) return new ResultadoOperacion(false, "No existe ninguna reserva con ese ID.");

        boolean dentro =
            (dia.isEqual(r.getFechaEntrada()) || dia.isAfter(r.getFechaEntrada())) &&
            (dia.isBefore(r.getFechaSalida()));

        if (!dentro) return new ResultadoOperacion(false, "La reserva existe, pero no corresponde a esta fecha.");

        if (r.getEstado() == EstadoReserva.CANCELADA) {
            return new ResultadoOperacion(false, "La reserva está cancelada.");
        }

        return new ResultadoOperacion(true, "Sí, hay una reserva para ese día con ese ID.");
    }

    public ResultadoOperacion cancelarReserva(String id) {
        Reserva r = buscarReservaPorId(id);
        if (r == null) return new ResultadoOperacion(false, "No existe ninguna reserva con ese ID.");

        if (r.getEstado() == EstadoReserva.CANCELADA) {
            return new ResultadoOperacion(false, "La reserva ya estaba cancelada.");
        }

        r.cancelar();
        return new ResultadoOperacion(true, "Reserva cancelada correctamente.");
    }

    public Ticket generarTicket(String idReserva) {
        Reserva r = buscarReservaPorId(idReserva);
        if (r == null) return null;

        if (r.getEstado() != EstadoReserva.CONFIRMADA) {
            return null;
        }

        String idTicket = "T" + contadorTickets++;
        return new Ticket(idTicket, r);
    }
}