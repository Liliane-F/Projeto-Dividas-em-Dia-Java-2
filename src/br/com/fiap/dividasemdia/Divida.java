package br.com.fiap.dividasemdia;

public class Divida {
    private Long idDivida;
    private Long idUsuario;
    private double valorOriginal;
    private String Credor;
    private String tipoDivida;
    private double taxaJurosAnual;
    private String status;


    //Construtor que inicializa a dívida genérica
    public Divida(Long idDivida, Long idUsuario, double valorOriginal, String Credor, String tipoDivida, double taxaJurosAnual, String status ) {
        this.idDivida = idDivida;
        this.idUsuario = idUsuario;
        this.valorOriginal = valorOriginal;
        this.Credor = Credor;
        this.tipoDivida = tipoDivida;
        this.taxaJurosAnual = taxaJurosAnual;
        this.status = status;
    }

    // Calcula juros por dias de atraso
    public double calcularTotalComJuros(int diasAtraso) {
        if (diasAtraso <= 0) {
            return this.valorOriginal;
        }
        //Descobre a taxa de juros por dia
        double taxaDiaria = (this.taxaJurosAnual / 100) / 365;
        double juros = this.valorOriginal * taxaDiaria * diasAtraso;
        return this.valorOriginal + juros;
    }

    // Getters e Setters

    public Long getIdDivida() {
        return idDivida;
    }

    public void setIdDivida(Long idDivida) {
        this.idDivida = idDivida;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getCredor() {
        return Credor;
    }

    public void setCredor(String credor) {
        Credor = credor;
    }

    public String getTipoDivida() {
        return tipoDivida;
    }

    public void setTipoDivida(String tipoDivida) {
        this.tipoDivida = tipoDivida;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
