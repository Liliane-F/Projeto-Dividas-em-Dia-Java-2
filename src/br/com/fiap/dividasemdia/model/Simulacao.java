package br.com.fiap.dividasemdia.model;

public class Simulacao {
    private Long idSimulacao;
    private Long idUsuario;
    private Long idDivida;
    private double valorDivida;
    private int quantidadeParcelas;
    private double valorParcela;
    private double economiaTotal;

    public Simulacao() {}

    // Construtor com paramêtro (inicia economiaTotal com 0.0)
    public Simulacao(Long idSimulacao, Long idUsuario, Long idDivida, double valorDivida, int quantidadeParcelas, double valorParcela) {
        this.idSimulacao = idSimulacao;
        this.idUsuario = idUsuario;
        this.idDivida = idDivida;
        this.valorDivida = valorDivida;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorParcela = valorParcela;
        this.economiaTotal = 0.0;
    }

    public void executarSimulacao() {
        this.economiaTotal = calcularEconomia();
    }

    // Regra de negócio real
    public double calcularEconomia() {
        double totalParcelado = this.quantidadeParcelas * this.valorParcela;
        if (this.valorDivida > totalParcelado) {
            this.economiaTotal = this.valorDivida - totalParcelado;
        } else {
            this.economiaTotal = 0.0;
        }
        return this.economiaTotal;
    }

    public Long getIdSimulacao() { return idSimulacao; }
    public void setIdSimulacao(Long idSimulacao) { this.idSimulacao = idSimulacao; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdDivida() { return idDivida; }
    public void setIdDivida(Long idDivida) { this.idDivida = idDivida; }

    public double getValorDivida() { return valorDivida; }
    public void setValorDivida(double valorDivida) { this.valorDivida = valorDivida; }

    public int getQuantidadeParcelas() { return quantidadeParcelas; }
    public void setQuantidadeParcelas(int quantidadeParcelas) { this.quantidadeParcelas = quantidadeParcelas; }

    public double getValorParcela() { return valorParcela; }
    public void setValorParcela(double valorParcela) { this.valorParcela = valorParcela; }

    public double getEconomiaTotal() { return economiaTotal; }
    public void setEconomiaTotal(double economiaTotal) { this.economiaTotal = economiaTotal; }
}