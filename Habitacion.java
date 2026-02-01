public abstract class Habitacion implements Facturable{
    private int numero;
    private double precioBase;
    private EstadoHabitacion estado;

    public Habitacion(int numero, double precioBase){
        this.numero = numero;
        this.precioBase = precioBase;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }
    public int getNumero(){
        return numero;


    }
    public EstadoHabitacion getEstado(){
        return estado;
    }
    public double getPrecioBase(){
        return precioBase;
    }
    public void setEstado(EstadoHabitacion e){
        System.out.println("Estado de la habitacion" + e);
    }
    public void calcularPrecio(double precioBase){
      System.out.println("Calculando precio");
      getPrecioBase();
    }
}
