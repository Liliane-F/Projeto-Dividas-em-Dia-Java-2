package br.com.fiap.dividasemdia;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TESTANDO AS CLASSES DA FINTECH ---\n");

        // 1. Instanciando Usuario
        Usuario usuario = new Usuario(1L, "Liliane", "liliane@email.com", "12345678900", "11999998888", "ATIVA");
        System.out.println("Usuário criado: " + usuario.getNome() + " | Status: " + usuario.getStatusConta());

        System.out.println("------------------------------------");

        // 2. Instanciando Divida base (Juros Simples)
        Divida dividaBase = new Divida(100L, 1L, 1500.00, "Banco X", "Geral", 12.5, "PENDENTE");
        System.out.println("Dívida Base - Total com 30 dias de atraso: R$ " + dividaBase.calcularTotalComJuros(30));

        System.out.println("------------------------------------");

        // 3. Testando Subclasse DividaCartaoCredito (Herança + Polimorfismo: Juros Compostos + Multa)
        DividaCartaoCredito cartao = new DividaCartaoCredito(
                101L, 1L, 1500.00, "Nubank", "Cartão de Crédito", 14.0, "PENDENTE", 2.0
        );
        System.out.println("Cartão de Crédito - Total com 30 dias de atraso: R$ " + cartao.calcularTotalComJuros(30));

        System.out.println("------------------------------------");

        // 4. Testando Subclasse DividaFinanciamento (Herança + Polimorfismo: Juros Simples + Taxa Fixa)
        DividaFinanciamento financiamento = new DividaFinanciamento(
                102L, 1L, 1500.00, "BV Financeira", "Financiamento Veicular", 10.0, "PENDENTE", 50.0
        );
        System.out.println("Financiamento - Total com 30 dias de atraso: R$ " + financiamento.calcularTotalComJuros(30));

        System.out.println("------------------------------------");

        // 5. Instanciando Parcela
        Parcela parcela = new Parcela(10L, 100L, 1, 150.00, "2026-09-10", "A_VENCER");
        parcela.gerarParcela();
        parcela.darBaixaParcela();

        System.out.println("------------------------------------");

        // 6. Instanciando Pagamento
        Pagamento pagamento = new Pagamento(500L, 10L, 150.00, "2026-08-23", "PIX", "CONCLUIDO");
        pagamento.processarPagamento();
        pagamento.confirmarPagamento();

        System.out.println("------------------------------------");

        // 7. Instanciando Simulacao (valor original 1500.00 negociado em 10x de 120.00 = 1200.00)
        Simulacao simulacao = new Simulacao(1000L, 1L, 100L, 1500.00, 10, 120.00);
        simulacao.executarSimulacao();

        // Exibindo o retorno e o estado atualizado no console
        System.out.println("Economia calculada: R$ " + simulacao.getEconomiaTotal());
    }
}