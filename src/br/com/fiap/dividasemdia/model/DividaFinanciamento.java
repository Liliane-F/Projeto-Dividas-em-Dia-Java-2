package br.com.fiap.dividasemdia.model;

/**
 * Subclasse de Divida.
 * Demonstra herança (extends) e sobrescrita (@Override) de calcularTotalComJuros,
 * usando juros simples + tarifa administrativa fixa — regra específica de financiamento.
 */
public class DividaFinanciamento extends Divida {
    private double taxaAdministrativaFixa;

    // Construtor alinhado aos 7 parâmetros da classe Divida + o atributo específico
    public DividaFinanciamento(Long idDivida, Long idUsuario, double valorOriginal,
                               String credor, String tipoDivida, double taxaJurosAnual,
                               String status, double taxaAdministrativaFixa) {
        super(idDivida, idUsuario, valorOriginal, credor, tipoDivida, taxaJurosAnual, status);
        this.taxaAdministrativaFixa = taxaAdministrativaFixa;
    }

    // Sobrescreve com juros simples (diferente do juros compostos do cartão)
    @Override
    public double calcularTotalComJuros(int diasAtraso) {
        if (diasAtraso <= 0) {
            return getValorOriginal();
        }
        double taxaDiaria = (getTaxaJurosAnual() / 100) / 365;
        double juros = getValorOriginal() * taxaDiaria * diasAtraso;
        double valorComJurosSimples = getValorOriginal() + juros;

        return valorComJurosSimples + this.taxaAdministrativaFixa;
    }

    public double getTaxaAdministrativaFixa() {
        return taxaAdministrativaFixa;
    }

    public void setTaxaAdministrativaFixa(double taxaAdministrativaFixa) {
        this.taxaAdministrativaFixa = taxaAdministrativaFixa;
    }
}