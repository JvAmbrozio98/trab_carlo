package modulovendas.Models;

import java.math.BigDecimal;

public class CompraProdutoModel {
    private Integer compraCodigo;
    private Integer produtoCodigo;
    private BigDecimal quantidade;
    private BigDecimal preco;
    private BigDecimal desconto;
    private BigDecimal total;

    public CompraProdutoModel() {
    }

    public CompraProdutoModel(Integer compraCodigo, Integer produtoCodigo, BigDecimal quantidade, BigDecimal preco, BigDecimal desconto, BigDecimal total) {
        this.compraCodigo = compraCodigo;
        this.produtoCodigo = produtoCodigo;
        this.quantidade = quantidade;
        this.preco = preco;
        this.desconto = desconto;
        this.total = total;
    }

    public Integer getCompraCodigo() {
        return compraCodigo;
    }

    public void setCompraCodigo(Integer compraCodigo) {
        this.compraCodigo = compraCodigo;
    }

    public Integer getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(Integer produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
