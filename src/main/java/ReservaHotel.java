import java.util.ArrayList;
import java.util.List;

public class ReservaHotel extends Reserva {
    private List<String> tiposQuarto;
    private List<Float> valoresQuarto;

    public ReservaHotel() {
        tiposQuarto = new ArrayList<>();
        tiposQuarto.add("Quarto Standard");
        tiposQuarto.add("Quarto Deluxe");
        tiposQuarto.add("Suíte Júnior");
        tiposQuarto.add("Suíte Presidencial");

        valoresQuarto = new ArrayList<>();
        valoresQuarto.add(100.0f);
        valoresQuarto.add(150.0f);
        valoresQuarto.add(200.0f);
        valoresQuarto.add(500.0f);
    }

    public List<String> getTiposQuarto() {
        return tiposQuarto;
    }

    public void setTiposQuarto(List<String> tiposQuarto) {
        this.tiposQuarto = tiposQuarto;
    }

    public List<Float> getValoresQuarto() {
        return valoresQuarto;
    }

    public void setValoresQuarto(List<Float> valoresQuarto) {
        this.valoresQuarto = valoresQuarto;
    }

    @Override
    public String realizarReserva(Usuario usuario) {
        if (usuario.situacaoCadastro()) {
            return "Reserva de hotel realizada para o cliente: " + usuario.getInfo();
        } else {
            return "Não é possível realizar a reserva de hotel. Usuário não cadastrado.";
        }
    }
    @Override
    public String cancelarReserva(Usuario usuario) {
        if (usuario.situacaoCadastro()) {
            return "Reserva de hotel cancelada para o cliente: " + usuario.getInfo();
        } else {
            return "Não é possível cancelar  uma reserva de hotel que não existe. (Usuário não cadastrado.)";
        }
    }

    @Override
    public String getTipo() {
        return "Reserva de Hotel";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", tipos de quarto=" + tiposQuarto;
    }

    @Override
    public float calcularTotal() {
        float total = 0.0f;
        for (Float valorQuarto : valoresQuarto) {
            total += valorQuarto;
        }
        return total;
    }
}
