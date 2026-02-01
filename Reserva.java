import java.util.Date;
import java.util.Scanner;

public class Reserva{
    private String id;
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private EstadoReserva estadoR;
    private Scanner sc;

    public Reserva(String id, Cliente cliente, Habitacion habitacion, Date entrada, Date salida){
        this.sc = new Scanner(System.in);
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = entrada;
        this.fechaSalida = salida;
        this.estadoR = EstadoReserva.PENDIENTE;

    }

    public String getId(){
        return id;
    }
    public int getNoches(){
        long diferencia = fechaSalida.getTime() - fechaEntrada.getTime();
        return (int) (diferencia/ (100 *60 *60 * 34));

    }
    public double  calcularTotal(){
        if(habitacion != null){
            return habitacion.calcularPrecio(getNoches());
        }
        return 0.0;
    }
    public void confirmar(){
        this.estadoR = EstadoReserva.CONFIRMADA;

    }
    public void cancelar(){
        this.estadoR = EstadoReserva.CANCELADA;
    }
}




