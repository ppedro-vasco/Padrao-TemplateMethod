import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaCarroTest {
    @Test
    void deveRetornarTiposCarro() {
        ReservaCarro reserva = new ReservaCarro();
        List<String> tiposCarroEsperados = Arrays.asList(
                "Sedan",
                "SUV",
                "Minivan",
                "Esportivo"
        );
        assertEquals(tiposCarroEsperados, reserva.getTiposCarro());
    }

    @Test
    void deveRetornarValorTotalDaReserva() {
        ReservaCarro reserva = new ReservaCarro();
        List<Float> valoresCarro = Arrays.asList(100.0f, 150.0f, 100.0f, 500.0f); // considerando que foi alugado todos os carros
        reserva.setValoresCarro(valoresCarro);

        float valorTotalEsperado = 850.0f; // soma dos valores dos carros
        float valorTotal = reserva.calcularTotal();
        assertEquals(valorTotalEsperado, valorTotal);
    }

    @Test
    void deveRealizarReservaDeCarro() {
        ReservaCarro reserva = new ReservaCarro();

        UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
        usuarioCpf.setDocumento("CPF");
        usuarioCpf.setNome("Pedro Vasconcelos");
        usuarioCpf.setEmail("pedro@example.com");
        usuarioCpf.setCpf("151.835.516-18");
        usuarioCpf.cadastrar();

        String resultadoEsperado = "Reserva de carro realizada para o cliente: Usuário{documento='CPF', nome='Pedro Vasconcelos', " +
                "email='pedro@example.com', tipo de usuário='Pessoa Física: 151.835.516-18}";

        String resultado = reserva.realizarReserva(usuarioCpf);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void deveCancelarReservaDeCarro(){
        ReservaCarro reserva = new ReservaCarro();

        UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
        usuarioCpf.setDocumento("CPF");
        usuarioCpf.setNome("Pedro Vasconcelos");
        usuarioCpf.setEmail("pedro@example.com");
        usuarioCpf.setCpf("151.835.516-18");
        usuarioCpf.cadastrar();

        // teste
        String resultadoEsperado = "Reserva de carro cancelada para o cliente: Usuário{documento='CPF', nome='Pedro Vasconcelos', " +
                "email='pedro@example.com', tipo de usuário='Pessoa Física: 151.835.516-18}";

        String resultado = reserva.cancelarReserva(usuarioCpf);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void deveRetornarInformacoesDaReserva() {
        ReservaCarro reserva = new ReservaCarro();
        reserva.setId(1);
        reserva.setTipoReserva("Reserva de Carro");

        String infoEsperada = "Reserva de Carro{id=1, tipo da reserva='Reserva de Carro}, tipos de carro=[Sedan, SUV, Minivan, Esportivo]";
        String info = reserva.getInfo();
        assertEquals(infoEsperada, info);
    }

    @Test
    public void deveRealizarReservaDeCarroComUsuarioNaoCadastrado() {
        ReservaCarro reserva = new ReservaCarro();

        UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
        usuarioCpf.setDocumento("CPF");
        usuarioCpf.setNome("Pedro Vasconcelos");
        usuarioCpf.setEmail("pedro@example.com");
        usuarioCpf.setCpf("151.835.516-18");

        String resultadoEsperado = "Não é possível realizar a reserva de carro. Usuário não cadastrado.";

        String resultado = reserva.realizarReserva(usuarioCpf);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void deveCancelarReservaDeCarroComUsuarioNaoCadastrado() {
        ReservaCarro reserva = new ReservaCarro();

        UsuarioPessoaFisica usuarioCpf = new UsuarioPessoaFisica();
        usuarioCpf.setDocumento("CPF");
        usuarioCpf.setNome("Pedro Vasconcelos");
        usuarioCpf.setEmail("pedro@example.com");
        usuarioCpf.setCpf("151.835.516-18");

        String resultadoEsperado = "Não é possível cancelar  uma reserva de carro que não existe. (Usuário não cadastrado.)";

        String resultado = reserva.cancelarReserva(usuarioCpf);
        assertEquals(resultadoEsperado, resultado);
    }
}
