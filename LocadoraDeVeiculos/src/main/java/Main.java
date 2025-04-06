public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Locadora de Veículos");
        System.out.println("-------------------------------");

        // Criar alguns veículos de exemplo
        Veiculo carro1 = new Veiculo("Fiat Uno", 80.0);
        Veiculo carro2 = new Veiculo("Honda Civic", 150.0);
        Veiculo carro3 = new Veiculo("Toyota Corolla", 180.0);

        // Exibir informações e cálculos de exemplo
        exibirInfoVeiculo(carro1, 3);
        exibirInfoVeiculo(carro2, 7);
        exibirInfoVeiculo(carro3, 15);

        // Exemplo de cálculo de multa
        System.out.println("\nExemplo de cálculo de multa por atraso:");
        double multa = carro1.calcularMultaAtraso(3, 5);
        System.out.println("Multa para atraso de 2 dias no Fiat Uno: R$ " + String.format("%.2f", multa));

        // Exemplo de desconto progressivo
        System.out.println("\nExemplo de desconto progressivo:");
        double custoProgressivo = carro2.calcularDescontoProgressivo(15);
        System.out.println("Custo com desconto progressivo para 15 dias no Honda Civic: R$ " + String.format("%.2f", custoProgressivo));
    }

    private static void exibirInfoVeiculo(Veiculo veiculo, int dias) {
        System.out.println("\nVeículo: " + veiculo.getModelo());
        System.out.println("Valor da diária: R$ " + String.format("%.2f", veiculo.getValorDiaria()));
        System.out.println("Período de aluguel: " + dias + " dias");
        System.out.println("Desconto aplicado: " + (veiculo.desconto(dias) * 100) + "%");
        System.out.println("Custo total: R$ " + String.format("%.2f", veiculo.calcularCusto(dias)));
    }
}