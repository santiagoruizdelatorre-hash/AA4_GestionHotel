public class ResultadoOperacion {
    private boolean ok;
    private String mensaje;

    public ResultadoOperacion(boolean ok, String mensaje) {
        this.ok = ok;
        this.mensaje = mensaje;
    }

    public boolean isOk() {
        return ok;
    }

    public String getMensaje() {
        return mensaje;
    }
}