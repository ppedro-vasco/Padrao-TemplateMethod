public abstract class Reserva {
    protected int id;
    protected String tipoReserva;
    protected float valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public abstract String realizarReserva();

    public String getTipo() {
        return "Reserva";
    }

    public String getInfo() {
        return getTipo() + "{" +
                "id=" + this.id +
                ", tipo da reserva='" + this.tipoReserva +
                '}';
    }

    public float calcularTotal() {
        return this.valor;
    }
}