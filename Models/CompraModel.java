package modulovendas.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CompraModel {
    private Integer cprCodigo;
    private Integer usuCodigo;
    private Integer forCodigo;
    private LocalDate cprEmissao;
    private BigDecimal cprValor;
    private BigDecimal cprDesconto;
    private BigDecimal cprTotal;
    private LocalDate cprDtEntrada;
    private String cprObs;

    public CompraModel() {
    }

    public CompraModel(Integer cprCodigo, Integer usuCodigo, Integer forCodigo, LocalDate cprEmissao, BigDecimal cprValor, BigDecimal cprDesconto, BigDecimal cprTotal, LocalDate cprDtEntrada, String cprObs) {
        this.cprCodigo = cprCodigo;
        this.usuCodigo = usuCodigo;
        this.forCodigo = forCodigo;
        this.cprEmissao = cprEmissao;
        this.cprValor = cprValor;
        this.cprDesconto = cprDesconto;
        this.cprTotal = cprTotal;
        this.cprDtEntrada = cprDtEntrada;
        this.cprObs = cprObs;
    }

    public String getCprObs() {
        return cprObs;
    }

    public void setCprObs(String cprObs) {
        this.cprObs = cprObs;
    }

    public LocalDate getCprDtEntrada() {
        return cprDtEntrada;
    }

    public void setCprDtEntrada(LocalDate cprDtEntrada) {
        this.cprDtEntrada = cprDtEntrada;
    }

    public BigDecimal getCprTotal() {
        return cprTotal;
    }

    public void setCprTotal(BigDecimal cprTotal) {
        this.cprTotal = cprTotal;
    }

    public BigDecimal getCprDesconto() {
        return cprDesconto;
    }

    public void setCprDesconto(BigDecimal cprDesconto) {
        this.cprDesconto = cprDesconto;
    }

    public BigDecimal getCprValor() {
        return cprValor;
    }

    public void setCprValor(BigDecimal cprValor) {
        this.cprValor = cprValor;
    }

    public LocalDate getCprEmissao() {
        return cprEmissao;
    }

    public void setCprEmissao(LocalDate cprEmissao) {
        this.cprEmissao = cprEmissao;
    }

    public Integer getForCodigo() {
        return forCodigo;
    }

    public void setForCodigo(Integer forCodigo) {
        this.forCodigo = forCodigo;
    }

    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public Integer getCprCodigo() {
        return cprCodigo;
    }

    public void setCprCodigo(Integer cprCodigo) {
        this.cprCodigo = cprCodigo;
    }
}
