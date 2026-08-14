package sistema_financeiro.model;

import java.time.LocalDate;
import java.math.BigDecimal;

public class ContaReceber {

    private int id;
    private Cliente cliente;
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private String status;

    public ContaReceber() {
    }

    public ContaReceber(int id, Cliente cliente, String descricao, BigDecimal valor, LocalDate dataVencimento,
            LocalDate dataPagamento, String status) {
        this.id = id;
        this.cliente = cliente;
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContaReceber [id=" + id + ", cliente=" + cliente + ", descricao=" + descricao + ", valor=" + valor
                + ", dataVencimento=" + dataVencimento + ", dataPagamento=" + dataPagamento + ", status=" + status
                + "]";
    }

}
