package br.com.fiap.dividasemdia.model;

public class DividaCartaoCredito extends Divida {
    private double multaAtrasoPercentual;

    // Construtor alinhado com a superclasse Divida
    public DividaCartaoCredito(Long idDivida, Long idUsuario, double valorOriginal,
                               String credor, String tipoDivida, double taxaJurosAnual,
                               String status, double multaAtrasoPercentual) {
        super(idDivida, idUsuario, valorOriginal, credor, tipoDivida, taxaJurosAnual, status);
        this.multaAtrasoPercentual = multaAtrasoPercentual;
    }

    // Polimorfismo: cálculo com juros compostos e acréscimo de multa
    @Override
    public double calcularTotalComJuros(int diasAtraso) {
        if (diasAtraso <= 0) {
            return getValorOriginal();
        }

        double taxaDiaria = (getTaxaJurosAnual() / 100) / 365;
        // Fórmula matemática de juros compostos
        double valorComJuros = getValorOriginal() * Math.pow((1 + taxaDiaria), diasAtraso);
        // Aplica a multa fixa sobre o valor original
        double valorMulta = getValorOriginal() * (this.multaAtrasoPercentual / 100);

        return valorComJuros + valorMulta;
    }

    public double getMultaAtrasoPercentual() {
        return multaAtrasoPercentual;
    }

    public void setMultaAtrasoPercentual(double multaAtrasoPercentual) {
        this.multaAtrasoPercentual = multaAtrasoPercentual;
    }
}