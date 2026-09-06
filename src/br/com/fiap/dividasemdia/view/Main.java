package br.com.fiap.dividasemdia.view;

import br.com.fiap.dividasemdia.model.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          DÍVIDAS EM DIA - SISTEMA FINTECH        ");
        System.out.println("   Organize suas dívidas e alcance sua liberdade  ");
        System.out.println("==================================================\n");

        // 1. Perfil do Usuário (Tela 'Dashboard' / 'Criar sua conta')
        Usuario usuario = new Usuario(1L, "Juliana Santos", "juliana.santos@email.com", "12345678900", "11987654321", "ATIVA");
        System.out.println("[USUÁRIO LOGADO]");
        System.out.println("Cliente: " + usuario.getNome() + " | E-mail: " + usuario.getEmail() + " | Conta: " + usuario.getStatusConta());
        System.out.println("--------------------------------------------------\n");

        // 2. Dívida de Cartão de Crédito (Tela 'Detalhe da Dívida' - Cartão Y)
        DividaCartaoCredito dividaCartao = new DividaCartaoCredito(
                101L, usuario.getIdUsuario(), 5000.00, "Cartão Y", "Fatura do Cartão", 18.0, "ATRASADO", 2.0
        );
        System.out.println("[DETALHE DA DÍVIDA - CARTÃO DE CRÉDITO]");
        System.out.println("Credor: " + dividaCartao.getCredor() + " (" + dividaCartao.getTipoDivida() + ")");
        System.out.println("Valor Original: R$ " + String.format("%.2f", dividaCartao.getValorOriginal()));
        System.out.println("Taxa Contratual: " + dividaCartao.getTaxaJurosAnual() + "% a.a. | Multa por Atraso: " + dividaCartao.getMultaAtrasoPercentual() + "%");

        // Demonstração do polimorfismo com cálculo de atraso
        double totalAtualizadoCartao = dividaCartao.calcularTotalComJuros(15);
        System.out.println("Status: " + dividaCartao.getStatus() + " (15 dias de atraso)");
        System.out.println("Saldo Devedor Atualizado (Juros Compostos + Multa): R$ " + String.format("%.2f", totalAtualizadoCartao));

        double totalPorData = dividaCartao.calcularTotalComJuros(LocalDate.of(2024, 5, 1));
        System.out.println("Total calculado a partir da data de vencimento: R$ " + String.format("%.2f", totalPorData));

        System.out.println("--------------------------------------------------\n");

        // 3. Dívida de Financiamento (Tela 'Dashboard' - Financiamento Z)
        DividaFinanciamento dividaFinanc = new DividaFinanciamento(
                102L, usuario.getIdUsuario(), 10000.00, "Financiamento Z", "Financiamento de Veículo", 9.0, "EM_ANDAMENTO", 150.0
        );
        System.out.println("[DETALHE DA DÍVIDA - FINANCIAMENTO]");
        System.out.println("Credor: " + dividaFinanc.getCredor() + " (" + dividaFinanc.getTipoDivida() + ")");
        System.out.println("Valor Original: R$ " + String.format("%.2f", dividaFinanc.getValorOriginal()));
        System.out.println("Taxa: " + dividaFinanc.getTaxaJurosAnual() + "% a.a. | Taxa Administrativa: R$ " + String.format("%.2f", dividaFinanc.getTaxaAdministrativaFixa()));
        // Demonstração do polimorfismo com cálculo de atraso
        double totalAtualizadoFinanc = dividaFinanc.calcularTotalComJuros(30);
        System.out.println("Previsão com 30 dias de atraso (Juros Simples + Tarifa Fixa): R$ " + String.format("%.2f", totalAtualizadoFinanc));
        System.out.println("--------------------------------------------------\n");

        // 4. Gestão de Parcelas e Pagamento (Tela 'Parcelas e Quitações')
        System.out.println("[HISTÓRICO E QUITAÇÃO DE PARCELAS]");
        Parcela parcela = new Parcela(1L, dividaCartao.getIdDivida(), 1, 1000.00, "2024-01-05", "PENDENTE");
        System.out.println("Processando Parcela 1 de 6 | Vencimento: " + parcela.getDataVencimento() + " | Valor: R$ " + String.format("%.2f", parcela.getValor()));

        Pagamento pagamento = new Pagamento(501L, parcela.getIdParcela(), 1000.00, "2024-01-03", "PIX", "PENDENTE");
        pagamento.processarPagamento();
        pagamento.confirmarPagamento();
        parcela.darBaixaParcela();

        System.out.println("Pagamento ID " + pagamento.getIdPagamento() + " via " + pagamento.getFormaPagamento() + ": " + pagamento.getStatus());
        System.out.println("Situação da Parcela após confirmação: " + parcela.getStatus());
        System.out.println("--------------------------------------------------\n");

        // 5. Simulador de Renegociação (Tela 'Simulador de Renegociação')
        System.out.println("[SIMULADOR DE RENEGOCIAÇÃO]");
        System.out.println("Proposta: Quitar saldo de R$ 2.250,00 em 12 parcelas fixas de R$ 180,00");
        Simulacao simulacao = new Simulacao(1001L, usuario.getIdUsuario(), dividaCartao.getIdDivida(), 2250.00, 12, 180.00);
        simulacao.executarSimulacao();

        double totalProposta = simulacao.getQuantidadeParcelas() * simulacao.getValorParcela();
        System.out.println("Custo Total Renegociado: R$ " + String.format("%.2f", totalProposta));
        System.out.println("Economia Estimada para o Cliente: R$ " + String.format("%.2f", simulacao.getEconomiaTotal()));

        System.out.println("\n[RESUMO DE TODAS AS DÍVIDAS]");
        // Lista declarada como Divida (supertipo): mesmo guardando objetos de tipos diferentes,
        // o Java decide em tempo de execução qual calcularTotalComJuros rodar em cada um (polimorfismo dinâmico)
        var dividas = new ArrayList<Divida>();
        dividas.add(dividaCartao);
        dividas.add(dividaFinanc);

        for (var d : dividas) {
            System.out.println(d.getCredor() + " (" + d.getTipoDivida() + "): saldo com 15 dias de atraso = R$ "
                    + String.format("%.2f", d.calcularTotalComJuros(15)));
        }

        System.out.println("\n==================================================");
        System.out.println("      SIMULAÇÃO CONCLUÍDA COM SUCESSO!            ");
        System.out.println("==================================================");
    }
}