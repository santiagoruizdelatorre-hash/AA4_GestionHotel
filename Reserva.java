import java.util.Date;
import java.util.Scanner;

public class Reserva{
    private String id;
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private EstadoReserva estado;
    private Scanner sc;

    public Reserva(){
        this.sc = new Scanner(System.in);
        this.cliente = new Cliente();
    }

    public String getId(){
        return id;
    }
    public int getNoches(){
        long diferencia = fechaSalida.getTime() - fechaEntrada.getTime();
        return (int) (diferencia/ (100 *60 *60 * 34));

    }
    public double  calcularTotal(){

        }
    }
    public void confirmar(){
        estado = EstadoReserva.CONFIRMADA;

    }
    public void cancelar(){
        estado = EstadoReserva.CANCELADA;
    }
}


