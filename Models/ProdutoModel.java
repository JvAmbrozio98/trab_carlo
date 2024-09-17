package modulovendas.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoModel {
    private int proCodigo;
    private String proNome;
    private BigDecimal proEstoque;
    private String proUnidade;
    private BigDecimal proPreco;
    private BigDecimal proCusto;
    private BigDecimal proAtacado;
    private BigDecimal proMin;
    private BigDecimal proMax;
    private BigDecimal proEmbalagem;
    private BigDecimal proPeso;
    private LocalDate proCadastro;
    private String proObs;
    private char proAtivo;

    public ProdutoModel() {
    }

    public ProdutoModel(int proCodigo, String proNome, BigDecimal proEstoque, String proUnidade, BigDecimal proPreco, BigDecimal proCusto, BigDecimal proAtacado, BigDecimal proMin, BigDecimal proMax, BigDecimal proEmbalagem, BigDecimal proPeso, LocalDate proCadastro, String proObs, char proAtivo) {
        this.proCodigo = proCodigo;
        this.proNome = proNome;
        this.proEstoque = proEstoque;
        this.proUnidade = proUnidade;
        this.proPreco = proPreco;
        this.proCusto = proCusto;
        this.proAtacado = proAtacado;
        this.proMin = proMin;
        this.proMax = proMax;
        this.proEmbalagem = proEmbalagem;
        this.proPeso = proPeso;
        this.proCadastro = proCadastro;
        this.proObs = proObs;
        this.proAtivo = proAtivo;
    }

    public ProdutoModel(String proNome, BigDecimal proEstoque, String proUnidade, BigDecimal proPreco, BigDecimal proCusto, BigDecimal proAtacado, BigDecimal proMin, BigDecimal proMax, BigDecimal proEmbalagem, BigDecimal proPeso, LocalDate proCadastro, String proObs, char proAtivo) {
        this.proNome = proNome;
        this.proEstoque = proEstoque;
        this.proUnidade = proUnidade;
        this.proPreco = proPreco;
        this.proCusto = proCusto;
        this.proAtacado = proAtacado;
        this.proMin = proMin;
        this.proMax = proMax;
        this.proEmbalagem = proEmbalagem;
        this.proPeso = proPeso;
        this.proCadastro = proCadastro;
        this.proObs = proObs;
        this.proAtivo = proAtivo;
    }

    public int getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(int proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public BigDecimal getProEstoque() {
        return proEstoque;
    }

    public void setProEstoque(BigDecimal proEstoque) {
        this.proEstoque = proEstoque;
    }

    public String getProUnidade() {
        return proUnidade;
    }

    public void setProUnidade(String proUnidade) {
        this.proUnidade = proUnidade;
    }

    public BigDecimal getProPreco() {
        return proPreco;
    }

    public void setProPreco(BigDecimal proPreco) {
        this.proPreco = proPreco;
    }

    public BigDecimal getProCusto() {
        return proCusto;
    }

    public void setProCusto(BigDecimal proCusto) {
        this.proCusto = proCusto;
    }

    public BigDecimal getProAtacado() {
        return proAtacado;
    }

    public void setProAtacado(BigDecimal proAtacado) {
        this.proAtacado = proAtacado;
    }

    public BigDecimal getProMin() {
        return proMin;
    }

    public void setProMin(BigDecimal proMin) {
        this.proMin = proMin;
    }

    public BigDecimal getProMax() {
        return proMax;
    }

    public void setProMax(BigDecimal proMax) {
        this.proMax = proMax;
    }

    public BigDecimal getProEmbalagem() {
        return proEmbalagem;
    }

    public void setProEmbalagem(BigDecimal proEmbalagem) {
        this.proEmbalagem = proEmbalagem;
    }

    public BigDecimal getProPeso() {
        return proPeso;
    }

    public void setProPeso(BigDecimal proPeso) {
        this.proPeso = proPeso;
    }

    public LocalDate getProCadastro() {
        return proCadastro;
    }

    public void setProCadastro(LocalDate proCadastro) {
        this.proCadastro = proCadastro;
    }

    public String getProObs() {
        return proObs;
    }

    public void setProObs(String proObs) {
        this.proObs = proObs;
    }

    public char getProAtivo() {
        return proAtivo;
    }

    public void setProAtivo(char proAtivo) {
        this.proAtivo = proAtivo;
    }
}
