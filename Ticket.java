import java.time.LocalDate;

public class Ticket {
    private String idTicket;
    private Reserva reserva;
    private LocalDate fechaEmision;
    private double total;

    public Ticket(String idTicket, Reserva reserva) {
        this.idTicket = idTicket;
        this.reserva = reserva;
        this.fechaEmision = LocalDate.now();
        this.total = reserva.calcularTotal();
    }

    public String generarTexto() {
        return ""
            + "===== TICKET =====\n"
            + "ID Ticket: " + idTicket + "\n"
            + "ID Reserva: " + reserva.getId() + "\n"
            // La siguiente línea estaba cortada en la imagen, se completa lógicamente:
            + "Cliente: " + reserva.getCliente().getNombre() + " (" + reserva.getCliente().getDni() + ")\n"
            + "Habitación: " + reserva.getHabitacion().getNumero() + "\n"
            + "Entrada: " + reserva.getFechaEntrada() + "\n"
            + "Salida: " + reserva.getFechaSalida() + "\n"
            + "Noches: " + reserva.getNoches() + "\n"
            + "Total: " + String.format("%.2f", total) + " €\n"
            + "Fecha emisión: " + fechaEmision + "\n"
            + "====================\n";
    }
}