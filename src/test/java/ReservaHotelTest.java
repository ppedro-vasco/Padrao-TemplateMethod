import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReservaHotelTest {

    @Test
    void deveRetornarTiposQuarto() {
        ReservaHotel reserva = new ReservaHotel();
        List<String> tiposQuartoEsperados = Arrays.asList(
                "Quarto Standard",
                "Quarto Deluxe",
                "Suíte Júnior",
                "Suíte Presidencial"
        );
        assertEquals(tiposQuartoEsperados, reserva.getTiposQuarto());
    }

    @Test
    void deveRetornarValorTotalDaReserva() {
        ReservaHotel reserva = new ReservaHotel();
        List<Float> valoresQuarto = Arrays.asList(100.0f, 150.0f, 200.0f, 500.0f); // considerando que foi alugado todos os quartos
        reserva.setValoresQuarto(valoresQuarto);

        float valorTotalEsperado = 950.0f; // soma dos valores dos quartos
        float valorTotal = reserva.calcularTotal();
        assertEquals(valorTotalEsperado, valorTotal);
    }

    @Test
    void deveRealizarReservaDeHotel() {
        ReservaHotel reserva = new ReservaHotel();

        UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
        usuarioCpf.setDocumento("CPF");
        usuarioCpf.setNome("Pedro Vasconcelos");
        usuarioCpf.setEmail("pedro@example.com");
        usuarioCpf.setCpf("151.835.516-18");
        usuarioCpf.cadastrar();

        String resultadoEsperado = "Reserva de hotel realizada para o cliente: Usuário{documento='CPF', nome='Pedro Vasconcelos', " +
                "email='pedro@example.com', tipo de usuário='Pessoa Física: 151.835.516-18}";

        String resultado = reserva.realizarReserva(usuarioCpf);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void deveCancelarReservaDeHotal(){
        ReservaHotel reserva = new ReservaHotel();

        UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
        usuarioCpf.setDocumento("CPF");
        usuarioCpf.setNome("Pedro Vasconcelos");
        usuarioCpf.setEmail("pedro@example.com");
        usuarioCpf.setCpf("151.835.516-18");
        usuarioCpf.cadastrar();

        // teste
        String resultadoEsperado = "Reserva de hotel cancelada para o cliente: Usuário{documento='CPF', nome='Pedro Vasconcelos', " +
                "email='pedro@example.com', tipo de usuário='Pessoa Física: 151.835.516-18}";

        String resultado = reserva.cancelarReserva(usuarioCpf);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void deveRetornarInformacoesDaReserva() {
        ReservaHotel reserva = new ReservaHotel();
        reserva.setId(1);
        reserva.setTipoReserva("Reserva de Hotel");

        String infoEsperada = "Reserva de Hotel{id=1, tipo da reserva='Reserva de Hotel}, tipos de quarto=[Quarto Standard, Quarto Deluxe, Suíte Júnior, Suíte Presidencial]";
        String info = reserva.getInfo();
        assertEquals(infoEsperada, info);
    }

    @Test
    public void deveRealizarReservaDeHotelComUsuarioNaoCadastrado() {
        ReservaHotel reserva = new ReservaHotel();

        UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
        usuarioCpf.setDocumento("CPF");
        usuarioCpf.setNome("Pedro Vasconcelos");
        usuarioCpf.setEmail("pedro@example.com");
        usuarioCpf.setCpf("151.835.516-18");

        String resultadoEsperado = "Não é possível realizar a reserva de hotel. Usuário não cadastrado.";

        String resultado = reserva.realizarReserva(usuarioCpf);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void deveCancelarReservaDeHotelComUsuarioNaoCadastrado() {
ReservaHotel reserva = new ReservaHotel();

    UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
    usuarioCpf.setDocumento("CPF");
    usuarioCpf.setNome("Pedro Vasconcelos");
    usuarioCpf.setEmail("pedro@example.com");
    usuarioCpf.setCpf("151.835.516-18");

    String resultadoEsperado = "Não é possível cancelar  uma reserva de hotel que não existe. (Usuário não cadastrado.)";

    String resultado = reserva.cancelarReserva(usuarioCpf);
    assertEquals(resultadoEsperado, resultado);
   }
}
