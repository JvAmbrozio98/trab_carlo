package modulovendas.Models;

import java.time.LocalDate;

public class Pessoa {
    private long pesCodigo;          // PES_CODIGO
    private String pesNome;          // PES_NOME
    private String pesFantasia;      // PES_FANTASIA
    private char pesFisica;          // PES_FISICA
    private String pesCpfCnpj;       // PES_CPFCNPJ
    private String pesRgIe;          // PES_RGIE
    private LocalDate pesCadastro;   // PES_CADASTRO
    private String pesEndereco;      // PES_ENDERECO
    private String pesNumero;        // PES_NUMERO
    private String pesComplemento;   // PES_COMPLEMENTO
    private String pesBairro;        // PES_BAIRRO
    private String pesCidade;        // PES_CIDADE
    private String pesUf;            // PES_UF
    private String pesCep;           // PES_CEP
    private String pesFone1;         // PES_FONE1
    private String pesFone2;         // PES_FONE2
    private String pesCelular;       // PES_CELULAR
    private String pesSite;          // PES_SITE
    private String pesEmail;         // PES_EMAIL
    private char pesAtivo;

    public Pessoa() {
    }

    public Pessoa(long pesCodigo, String pesNome, String pesFantasia, char pesFisica, String pesCpfCnpj, String pesRgIe, LocalDate pesCadastro, String pesEndereco, String pesNumero, String pesComplemento, String pesBairro, String pesCidade, String pesUf, String pesCep, String pesFone1, String pesFone2, String pesCelular, String pesSite, String pesEmail, char pesAtivo) {
        this.pesCodigo = pesCodigo;
        this.pesNome = pesNome;
        this.pesFantasia = pesFantasia;
        this.pesFisica = pesFisica;
        this.pesCpfCnpj = pesCpfCnpj;
        this.pesRgIe = pesRgIe;
        this.pesCadastro = pesCadastro;
        this.pesEndereco = pesEndereco;
        this.pesNumero = pesNumero;
        this.pesComplemento = pesComplemento;
        this.pesBairro = pesBairro;
        this.pesCidade = pesCidade;
        this.pesUf = pesUf;
        this.pesCep = pesCep;
        this.pesFone1 = pesFone1;
        this.pesFone2 = pesFone2;
        this.pesCelular = pesCelular;
        this.pesSite = pesSite;
        this.pesEmail = pesEmail;
        this.pesAtivo = pesAtivo;
    }

    public Pessoa(String pesNome, String pesFantasia, char pesFisica, String pesCpfCnpj, String pesRgIe, LocalDate pesCadastro, String pesEndereco, String pesNumero, String pesComplemento, String pesBairro, String pesCidade, String pesUf, String pesCep, String pesFone1, String pesFone2, String pesCelular, String pesSite, String pesEmail, char pesAtivo) {
        this.pesNome = pesNome;
        this.pesFantasia = pesFantasia;
        this.pesFisica = pesFisica;
        this.pesCpfCnpj = pesCpfCnpj;
        this.pesRgIe = pesRgIe;
        this.pesCadastro = pesCadastro;
        this.pesEndereco = pesEndereco;
        this.pesNumero = pesNumero;
        this.pesComplemento = pesComplemento;
        this.pesBairro = pesBairro;
        this.pesCidade = pesCidade;
        this.pesUf = pesUf;
        this.pesCep = pesCep;
        this.pesFone1 = pesFone1;
        this.pesFone2 = pesFone2;
        this.pesCelular = pesCelular;
        this.pesSite = pesSite;
        this.pesEmail = pesEmail;
        this.pesAtivo = pesAtivo;
    }

    public long getPesCodigo() {
        return pesCodigo;
    }

    public void setPesCodigo(long pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public String getPesFantasia() {
        return pesFantasia;
    }

    public void setPesFantasia(String pesFantasia) {
        this.pesFantasia = pesFantasia;
    }

    public char getPesFisica() {
        return pesFisica;
    }

    public void setPesFisica(char pesFisica) {
        this.pesFisica = pesFisica;
    }

    public String getPesCpfCnpj() {
        return pesCpfCnpj;
    }

    public void setPesCpfCnpj(String pesCpfCnpj) {
        this.pesCpfCnpj = pesCpfCnpj;
    }

    public String getPesRgIe() {
        return pesRgIe;
    }

    public void setPesRgIe(String pesRgIe) {
        this.pesRgIe = pesRgIe;
    }

    public LocalDate getPesCadastro() {
        return pesCadastro;
    }

    public void setPesCadastro(LocalDate pesCadastro) {
        this.pesCadastro = pesCadastro;
    }

    public String getPesEndereco() {
        return pesEndereco;
    }

    public void setPesEndereco(String pesEndereco) {
        this.pesEndereco = pesEndereco;
    }

    public String getPesNumero() {
        return pesNumero;
    }

    public void setPesNumero(String pesNumero) {
        this.pesNumero = pesNumero;
    }

    public String getPesComplemento() {
        return pesComplemento;
    }

    public void setPesComplemento(String pesComplemento) {
        this.pesComplemento = pesComplemento;
    }

    public String getPesBairro() {
        return pesBairro;
    }

    public void setPesBairro(String pesBairro) {
        this.pesBairro = pesBairro;
    }

    public String getPesCidade() {
        return pesCidade;
    }

    public void setPesCidade(String pesCidade) {
        this.pesCidade = pesCidade;
    }

    public String getPesUf() {
        return pesUf;
    }

    public void setPesUf(String pesUf) {
        this.pesUf = pesUf;
    }

    public String getPesCep() {
        return pesCep;
    }

    public void setPesCep(String pesCep) {
        this.pesCep = pesCep;
    }

    public String getPesFone1() {
        return pesFone1;
    }

    public void setPesFone1(String pesFone1) {
        this.pesFone1 = pesFone1;
    }

    public String getPesFone2() {
        return pesFone2;
    }

    public void setPesFone2(String pesFone2) {
        this.pesFone2 = pesFone2;
    }

    public String getPesCelular() {
        return pesCelular;
    }

    public void setPesCelular(String pesCelular) {
        this.pesCelular = pesCelular;
    }

    public String getPesSite() {
        return pesSite;
    }

    public void setPesSite(String pesSite) {
        this.pesSite = pesSite;
    }

    public String getPesEmail() {
        return pesEmail;
    }

    public void setPesEmail(String pesEmail) {
        this.pesEmail = pesEmail;
    }

    public char getPesAtivo() {
        return pesAtivo;
    }

    public void setPesAtivo(char pesAtivo) {
        this.pesAtivo = pesAtivo;
    }
}
