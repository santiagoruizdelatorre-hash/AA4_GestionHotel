import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private String id;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private EstadoReserva estado;

    public Reserva(String id, Cliente cliente, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        // Por defecto la dejamos pendiente, aunque en el Hotel la confirmas inmediatamente
        this.estado = EstadoReserva.PENDIENTE; 
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public int getNoches() {
        // Calcula la diferencia de días de forma segura usando una API moderna de Java
        long dias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        return (int) dias;
    }

    public double calcularTotal() {
        return habitacion.calcularPrecio(getNoches());
    }

    public void confirmar() {
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
    }
}