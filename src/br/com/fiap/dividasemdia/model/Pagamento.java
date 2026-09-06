package br.com.fiap.dividasemdia.model;

public class Pagamento {
    private Long idPagamento;
    private Long idParcela;
    private double valorPago;
    private String dataPagamento;
    private String formaPagamento;
    private String status;

    public Pagamento() {}

    public Pagamento(Long idPagamento, Long idParcela, double valorPago, String dataPagamento, String formaPagamento, String status) {
        this.idPagamento = idPagamento;
        this.idParcela = idParcela;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    // Simula o fluxo de estados de um pagamento: pendente -> em processamento -> concluído
    public void processarPagamento() {
        this.status = "EM_PROCESSAMENTO";
    }

    public void confirmarPagamento() {
        this.status = "CONCLUIDO";
    }


    public Long getIdPagamento() { return idPagamento; }
    public void setIdPagamento(Long idPagamento) { this.idPagamento = idPagamento; }

    public Long getIdParcela() { return idParcela; }
    public void setIdParcela(Long idParcela) { this.idParcela = idParcela; }

    public double getValorPago() { return valorPago; }
    public void setValorPago(double valorPago) { this.valorPago = valorPago; }

    public String getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(String dataPagamento) { this.dataPagamento = dataPagamento; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
