package modelo;

public class HabitacionSuite extends Habitacion {
    
    private double extraLujo;

    public HabitacionSuite(int numero, double precioBase, double extraLujo) {
        super(numero, precioBase); // Pasa los datos obligatorios al padre
        this.extraLujo = extraLujo;
    }

    @Override
    public double calcularPrecio(int noches) {
        // Suma el precio base + el extra de lujo
        return (getPrecioBase() + extraLujo) * noches;
    }
}