package modulovendas.Models;

import java.time.LocalDate;

public class FornecedorModel extends Pessoa {
    private Long for_codigo;
    private String for_contato;

    public FornecedorModel() {
    }

    public FornecedorModel(Long for_codigo, String for_fornecedor) {
        this.for_codigo = for_codigo;
        this.for_contato = for_fornecedor;
    }

    public FornecedorModel(Integer pesCodigo, String pesNome, String pesFantasia, char pesFisica, String pesCpfCnpj, String pesRgIe, LocalDate pesCadastro, String pesEndereco, String pesNumero, String pesComplemento, String pesBairro, String pesCidade, String pesUf, String pesCep, String pesFone1, String pesFone2, String pesCelular, String pesSite, String pesEmail, char pesAtivo, Long for_codigo, String for_fornecedor) {
        super(pesCodigo, pesNome, pesFantasia, pesFisica, pesCpfCnpj, pesRgIe, pesCadastro, pesEndereco, pesNumero, pesComplemento, pesBairro, pesCidade, pesUf, pesCep, pesFone1, pesFone2, pesCelular, pesSite, pesEmail, pesAtivo);
        this.for_codigo = for_codigo;
        this.for_contato = for_fornecedor;
    }

    public FornecedorModel(String pesNome, String pesFantasia, char pesFisica, String pesCpfCnpj, String pesRgIe, LocalDate pesCadastro, String pesEndereco, String pesNumero, String pesComplemento, String pesBairro, String pesCidade, String pesUf, String pesCep, String pesFone1, String pesFone2, String pesCelular, String pesSite, String pesEmail, char pesAtivo, Long for_codigo, String for_fornecedor) {
        super(pesNome, pesFantasia, pesFisica, pesCpfCnpj, pesRgIe, pesCadastro, pesEndereco, pesNumero, pesComplemento, pesBairro, pesCidade, pesUf, pesCep, pesFone1, pesFone2, pesCelular, pesSite, pesEmail, pesAtivo);
        this.for_codigo = for_codigo;
        this.for_contato = for_fornecedor;
    }

    public Long getFor_codigo() {
        return for_codigo;
    }

    public void setFor_codigo(Long for_codigo) {
        this.for_codigo = for_codigo;
    }

    public String getFor_contato() {
        return for_contato;
    }

    public void setFor_contato(String for_contato) {
        this.for_contato = for_contato;
    }
}
