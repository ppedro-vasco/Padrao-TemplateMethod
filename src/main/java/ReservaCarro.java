import java.util.ArrayList;
import java.util.List;

public class ReservaCarro extends Reserva {
    private List<String> tiposCarro;
    private List<Float> valoresCarro;

    public ReservaCarro() {
        tiposCarro = new ArrayList<>();
        tiposCarro.add("Sedan");
        tiposCarro.add("SUV");
        tiposCarro.add("Minivan");
        tiposCarro.add("Esportivo");

        valoresCarro = new ArrayList<>();
        valoresCarro.add(100.0f);
        valoresCarro.add(150.0f);
        valoresCarro.add(100.0f);
        valoresCarro.add(500.0f);
    }

    public List<String> getTiposCarro() {
        return tiposCarro;
    }

    public void setTiposCarro(List<String> tiposCarro) {
        this.tiposCarro = tiposCarro;
    }

    public List<Float> getValoresCarro() {
        return getValoresCarro();
    }

    public void setValoresCarro(List<Float> valoresCarro) {
        this.valoresCarro = valoresCarro;
    }

    @Override
    public String realizarReserva(Usuario usuario) {
        if (usuario.situacaoCadastro()) {
            return "Reserva de carro realizada para o cliente: " + usuario.getInfo();
        } else {
            return "Não é possível realizar a reserva de carro. Usuário não cadastrado.";
        }
    }
    @Override
    public String cancelarReserva(Usuario usuario) {
        if (usuario.situacaoCadastro()) {
            return "Reserva de carro cancelada para o cliente: " + usuario.getInfo();
        } else {
            return "Não é possível cancelar  uma reserva de carro que não existe. (Usuário não cadastrado.)";
        }
    }

    @Override
    public String getTipo() {
        return "Reserva de Carro";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", tipos de carro=" + tiposCarro;
    }

    @Override
    public float calcularTotal() {
        float total = 0.0f;
        for (Float valorCarro : valoresCarro) {
            total += valorCarro;
        }
        return total;
    }
}
