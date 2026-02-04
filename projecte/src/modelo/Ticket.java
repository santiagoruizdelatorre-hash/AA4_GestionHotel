package modelo;


public class Ticket {

    private String idTicket;
    private Reserva reserva;
    private double total;

    public Ticket(String idTicket, Reserva reserva) {
        this.idTicket = idTicket;
        this.reserva = reserva;
        this.total = reserva.calcularTotal();
    }

    public String generarTexto() {
        return ""
            + "===== TICKET =====\n"
            + "ID Ticket: " + idTicket + "\n"
            + "ID Reserva: " + reserva.getId() + "\n"
            + "Cliente: " + reserva.getCliente().getNombre() + " (" 
            + reserva.getCliente().getDni() + ")\n"
            + "Habitación: " + reserva.getHabitacion().getNumero() + "\n"
            + "Noches: " + reserva.getNoches() + "\n"
            + "Total: " + String.format("%.2f", total) + " €\n"
            + "==================\n";
    }
}
