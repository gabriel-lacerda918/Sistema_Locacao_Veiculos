public class Veiculo {
    private String modelo;
    private double valorDiaria;

    // Construtor
    public Veiculo(String modelo, double valorDiaria) {
        if (valorDiaria < 0) {
            throw new IllegalArgumentException("Valor da diária não pode ser negativo");
        }
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria < 0) {
            throw new IllegalArgumentException("Valor da diária não pode ser negativo");
        }
        this.valorDiaria = valorDiaria;
    }

    // Método para calcular o custo do aluguel
    public double calcularCusto(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("Número de dias deve ser maior que zero");
        }
        double custoTotal = valorDiaria * dias;
        return aplicarDesconto(dias, custoTotal);
    }

    // Método para aplicar desconto
    private double aplicarDesconto(int dias, double custoTotal) {
        if (dias >= 7) {
            return custoTotal * 0.9; // 10% de desconto
        }
        return custoTotal;
    }

    // Método desconto público para testes
    public double desconto(int dias) {
        if (dias >= 7) {
            return 0.1; // 10% de desconto
        }
        return 0.0; // Sem desconto
    }

    // Método para calcular multa por atraso
    public double calcularMultaAtraso(int diasPrevistos, int diasReais) {
        if (diasReais <= diasPrevistos) {
            return 0.0; // Não há multa se não houver atraso
        }

        int diasAtraso = diasReais - diasPrevistos;
        double custoOriginal = valorDiaria * diasPrevistos;
        double multaDiaria = valorDiaria * 0.2; // 20% do valor da diária por dia de atraso

        return diasAtraso * multaDiaria;
    }

    // Método para calcular desconto progressivo
    public double calcularDescontoProgressivo(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("Número de dias deve ser maior que zero");
        }

        double custoBase = valorDiaria * dias;
        double percentualDesconto = 0.0;

        if (dias >= 30) {
            percentualDesconto = 0.25; // 25% para 30 dias ou mais
        } else if (dias >= 15) {
            percentualDesconto = 0.15; // 15% para 15-29 dias
        } else if (dias >= 7) {
            percentualDesconto = 0.10; // 10% para 7-14 dias
        } else if (dias >= 3) {
            percentualDesconto = 0.05; // 5% para 3-6 dias
        }

        return custoBase * (1 - percentualDesconto);
    }
}