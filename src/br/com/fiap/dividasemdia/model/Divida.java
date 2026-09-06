package br.com.fiap.dividasemdia.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Superclasse abstrata do domínio de dívidas.
 * É abstrata porque não faz sentido existir uma "dívida genérica":
 * toda dívida real é de um tipo concreto (cartão, financiamento etc.).
 */
public abstract class Divida {
    private Long idDivida;
    private Long idUsuario;
    private double valorOriginal;
    private String credor;
    private String tipoDivida;
    private double taxaJurosAnual;
    private String status;

    public Divida() {
    }

    public Divida(Long idDivida, Long idUsuario, double valorOriginal, String credor, String tipoDivida, double taxaJurosAnual, String status) {
        this.idDivida = idDivida;
        this.idUsuario = idUsuario;
        this.valorOriginal = valorOriginal;
        this.credor = credor;
        this.tipoDivida = tipoDivida;
        this.taxaJurosAnual = taxaJurosAnual;
        this.status = status;
    }

    // Método abstrato: cada subclasse define sua própria fórmula de cálculo de juros (polimorfismo)
    public abstract double calcularTotalComJuros(int diasAtraso);
    // Sobrecarga (polimorfismo estático): mesmo nome do método acima, mas recebe uma data
    // em vez de já saber os dias de atraso. Internamente delega para calcularTotalComJuros(int).
    public double calcularTotalComJuros(LocalDate dataVencimento) {
        long diasAtraso = ChronoUnit.DAYS.between(dataVencimento, LocalDate.now());
        return calcularTotalComJuros((int) diasAtraso);
    }

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
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
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