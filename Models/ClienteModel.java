package modulovendas.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClienteModel extends Pessoa {
    public long cliCodigo;          // CLI_CODIGO
    public BigDecimal cliLimiteCred; // CLI_LIMITECRED (NUMERIC(18,2))

    public ClienteModel() {

    }

    public ClienteModel(long cliCodigo, BigDecimal cliLimiteCred) {
        this.cliCodigo = cliCodigo;
        this.cliLimiteCred = cliLimiteCred;
    }

    public ClienteModel(Integer pesCodigo, String pesNome, String pesFantasia, char pesFisica, String pesCpfCnpj, String pesRgIe, LocalDate pesCadastro, String pesEndereco, String pesNumero, String pesComplemento, String pesBairro, String pesCidade, String pesUf, String pesCep, String pesFone1, String pesFone2, String pesCelular, String pesSite, String pesEmail, char pesAtivo, long cliCodigo, BigDecimal cliLimiteCred) {
        super(pesCodigo, pesNome, pesFantasia, pesFisica, pesCpfCnpj, pesRgIe, pesCadastro, pesEndereco, pesNumero, pesComplemento, pesBairro, pesCidade, pesUf, pesCep, pesFone1, pesFone2, pesCelular, pesSite, pesEmail, pesAtivo);
        this.cliCodigo = cliCodigo;
        this.cliLimiteCred = cliLimiteCred;
    }

    public ClienteModel(String pesNome, String pesFantasia, char pesFisica, String pesCpfCnpj, String pesRgIe, LocalDate pesCadastro, String pesEndereco, String pesNumero, String pesComplemento, String pesBairro, String pesCidade, String pesUf, String pesCep, String pesFone1, String pesFone2, String pesCelular, String pesSite, String pesEmail, char pesAtivo, long cliCodigo, BigDecimal cliLimiteCred) {
        super(pesNome, pesFantasia, pesFisica, pesCpfCnpj, pesRgIe, pesCadastro, pesEndereco, pesNumero, pesComplemento, pesBairro, pesCidade, pesUf, pesCep, pesFone1, pesFone2, pesCelular, pesSite, pesEmail, pesAtivo);
        this.cliCodigo = cliCodigo;
        this.cliLimiteCred = cliLimiteCred;
    }

    public long getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(long cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public BigDecimal getCliLimiteCred() {
        return cliLimiteCred;
    }

    public void setCliLimiteCred(BigDecimal cliLimiteCred) {
        this.cliLimiteCred = cliLimiteCred;
    }
}
