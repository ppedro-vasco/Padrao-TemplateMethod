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
        List<Float> valoresQuarto = Arrays.asList(100.0f, 150.0f, 200.0f, 500.0f);
        reserva.setValoresQuarto(valoresQuarto);

        float valorTotalEsperado = 950.0f; // soma dos valores dos quartos
        float valorTotal = reserva.calcularTotal();
        assertEquals(valorTotalEsperado, valorTotal);
    }

    @Test
    void deveRealizarReservaDeHotel() {
        ReservaHotel reserva = new ReservaHotel();
        String resultadoEsperado = "Reserva de hotel realizada.";
        String resultado = reserva.realizarReserva();
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
}
