import java.util.Date;

public class Reserva {
    private String id;
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private EstadoReserva estado;

    public Reserva(String id, Cliente cliente, Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
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

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public int getNoches() {
        long diferencia = fechaSalida.getTime() - fechaEntrada.getTime();
        int noches = (int) (diferencia / (1000L * 60 * 60 * 24));
        return Math.max(noches, 0);
    }

    public double calcularTotal() {
        if (habitacion == null) return 0;
        return habitacion.calcularPrecio(getNoches());
    }

    public void confirmar() {
        estado = EstadoReserva.CONFIRMADA;
        if (habitacion != null) habitacion.setEstado(EstadoHabitacion.OCUPADA);
    }

    public void cancelar() {
        estado = EstadoReserva.CANCELADA;
        if (habitacion != null) habitacion.setEstado(EstadoHabitacion.DISPONIBLE);
    }
}


