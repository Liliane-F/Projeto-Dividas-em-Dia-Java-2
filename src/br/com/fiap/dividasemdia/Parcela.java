package br.com.fiap.dividasemdia;

public class Parcela {
    private Long idParcela;
    private Long idDivida;
    private int numeroParcela;
    private double valor;
    private String dataVencimento;
    private String status;

    public Parcela(Long idParcela, Long idDivida, int numeroParcela, double valor, String dataVencimento, String stParcela) {
        this.idParcela = idParcela;
        this.idDivida = idDivida;
        this.numeroParcela = numeroParcela;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.status = stParcela; // Corrigido aqui
    }

    public void gerarParcela() {
        this.status = "A_VENCER";
    }

    public void darBaixaParcela() {
        this.status = "PAGA";
    }

    // Getters e Setters (Encapsulamento)
    public Long getIdParcela() { return idParcela; }
    public void setIdParcela(Long idParcela) { this.idParcela = idParcela; }

    public Long getIdDivida() { return idDivida; }
    public void setIdDivida(Long idDivida) { this.idDivida = idDivida; }

    public int getNumeroParcela() { return numeroParcela; }
    public void setNumeroParcela(int numeroParcela) { this.numeroParcela = numeroParcela; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(String dataVencimento) { this.dataVencimento = dataVencimento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}