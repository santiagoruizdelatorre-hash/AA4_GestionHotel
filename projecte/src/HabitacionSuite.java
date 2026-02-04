public class HabitacionSuite extends Habitacion {
    private double extraLujo;
    

    public HabitacionSuite(int numero, double precioBase, double extraLujo) {
        super(numero, precioBase);
        this.extraLujo = extraLujo;
    }

    @Override
    public double calcularPrecio(int noches) {
        return (getPrecioBase() + extraLujo) * noches;
    }
}


