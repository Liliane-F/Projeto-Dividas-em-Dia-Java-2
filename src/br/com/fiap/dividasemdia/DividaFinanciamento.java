package br.com.fiap.dividasemdia;

public class DividaFinanciamento extends Divida {
    private double taxaAdministrativaFixa;

    // Construtor alinhado aos 7 parâmetros da classe Divida + o atributo específico
    public DividaFinanciamento(Long idDivida, Long idUsuario, double valorOriginal,
                               String credor, String tipoDivida, double taxaJurosAnual,
                               String status, double taxaAdministrativaFixa) {
        super(idDivida, idUsuario, valorOriginal, credor, tipoDivida, taxaJurosAnual, status);
        this.taxaAdministrativaFixa = taxaAdministrativaFixa;
    }

    // Polimorfismo: reaproveita o cálculo de juros simples da mãe e soma a taxa fixa
    @Override
    public double calcularTotalComJuros(int diasAtraso) {
        if (diasAtraso <= 0) {
            return getValorOriginal();
        }
        double valorComJurosSimples = super.calcularTotalComJuros(diasAtraso);
        return valorComJurosSimples + this.taxaAdministrativaFixa;
    }

    public double getTaxaAdministrativaFixa() {
        return taxaAdministrativaFixa;
    }

    public void setTaxaAdministrativaFixa(double taxaAdministrativaFixa) {
        this.taxaAdministrativaFixa = taxaAdministrativaFixa;
    }
}