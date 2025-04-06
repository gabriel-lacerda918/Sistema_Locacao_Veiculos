import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    private Veiculo veiculo;

    @BeforeEach
    void setUp() {
        // Inicializa um veículo para cada teste
        veiculo = new Veiculo("Fiat Uno", 100.0);
    }

    @Test
    void testConstrutorComValorNegativo() {
        // Deve lançar exceção ao tentar criar com valor de diária negativo
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Veiculo("Teste", -10.0);
        });

        String mensagemEsperada = "Valor da diária não pode ser negativo";
        String mensagemAtual = exception.getMessage();

        assertTrue(mensagemAtual.contains(mensagemEsperada));
    }

    @Test
    void testSetValorDiariaNegativo() {
        // Deve lançar exceção ao tentar definir valor de diária negativo
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            veiculo.setValorDiaria(-50.0);
        });

        String mensagemEsperada = "Valor da diária não pode ser negativo";
        String mensagemAtual = exception.getMessage();

        assertTrue(mensagemAtual.contains(mensagemEsperada));
    }

    @Test
    void testCalcularCustoZeroDias() {
        // Deve lançar exceção ao tentar calcular para zero dias
        assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularCusto(0);
        });
    }

    @Test
    void testCalcularCustoDiasNegativos() {
        // Deve lançar exceção ao tentar calcular para dias negativos
        assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularCusto(-5);
        });
    }

    @Test
    void testCalcularCustoSemDesconto() {
        // Teste para 3 dias (sem desconto)
        double custo = veiculo.calcularCusto(3);
        assertEquals(300.0, custo, 0.001);
    }

    @Test
    void testCalcularCustoComDesconto() {
        // Teste para 7 dias (com desconto de 10%)
        double custo = veiculo.calcularCusto(7);
        assertEquals(630.0, custo, 0.001); // 7 * 100 * 0.9 = 630
    }

    @Test
    void testDescontoMenosQueSeteDias() {
        // Teste da função de desconto para menos de 7 dias
        double desconto = veiculo.desconto(6);
        assertEquals(0.0, desconto, 0.001);
    }

    @Test
    void testDescontoSeteDias() {
        // Teste da função de desconto para 7 dias
        double desconto = veiculo.desconto(7);
        assertEquals(0.1, desconto, 0.001);
    }

    @Test
    void testDescontoMaisQueSeteDias() {
        // Teste da função de desconto para mais de 7 dias
        double desconto = veiculo.desconto(10);
        assertEquals(0.1, desconto, 0.001);
    }

    @Test
    void testCalcularMultaAtrasoSemAtraso() {
        // Teste de multa sem atraso (deve ser zero)
        double multa = veiculo.calcularMultaAtraso(5, 5);
        assertEquals(0.0, multa, 0.001);
    }

    @Test
    void testCalcularMultaAtrasoComAtraso() {
        // Teste de multa com 2 dias de atraso
        double multa = veiculo.calcularMultaAtraso(5, 7);
        assertEquals(40.0, multa, 0.001); // 2 dias * (100 * 0.2)
    }

    @Test
    void testCalcularDescontoProgressivoMenosDeTresDias() {
        // Teste para 2 dias (sem desconto progressivo)
        double custo = veiculo.calcularDescontoProgressivo(2);
        assertEquals(200.0, custo, 0.001);
    }

    @Test
    void testCalcularDescontoProgressivoEntreTresESeteDias() {
        // Teste para 5 dias (desconto de 5%)
        double custo = veiculo.calcularDescontoProgressivo(5);
        assertEquals(475.0, custo, 0.001); // 5 * 100 * 0.95 = 475
    }

    @Test
    void testCalcularDescontoProgressivoEntreSeteDiasEQuinzeDias() {
        // Teste para 10 dias (desconto de 10%)
        double custo = veiculo.calcularDescontoProgressivo(10);
        assertEquals(900.0, custo, 0.001); // 10 * 100 * 0.9 = 900
    }

    @Test
    void testCalcularDescontoProgressivoEntreQuinzeETrintaDias() {
        // Teste para 20 dias (desconto de 15%)
        double custo = veiculo.calcularDescontoProgressivo(20);
        assertEquals(1700.0, custo, 0.001); // 20 * 100 * 0.85 = 1700
    }

    @Test
    void testCalcularDescontoProgressivoMaisDeTrintaDias() {
        // Teste para 35 dias (desconto de 25%)
        double custo = veiculo.calcularDescontoProgressivo(35);
        assertEquals(2625.0, custo, 0.001); // 35 * 100 * 0.75 = 2625
    }

    @Test
    void testCalcularDescontoProgressivoZeroDias() {
        // Deve lançar exceção ao tentar calcular para zero dias
        assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularDescontoProgressivo(0);
        });
    }

    @Test
    void testCalcularDescontoProgressivoDiasNegativos() {
        // Deve lançar exceção ao tentar calcular para dias negativos
        assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularDescontoProgressivo(-5);
        });
    }
}