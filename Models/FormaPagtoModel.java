package modulovendas.Models;

public class FormaPagtoModel {
    private int fpgCodigo;   // Mapeia FPG_CODIGO
    private String fpgNome;  // Mapeia FPG_NOME
    private char fpgAtivo;   // Mapeia FPG_ATIVO

    public FormaPagtoModel() {
    }

    public FormaPagtoModel(int fpgCodigo, String fpgNome, char fpgAtivo) {
        this.fpgCodigo = fpgCodigo;
        this.fpgNome = fpgNome;
        this.fpgAtivo = fpgAtivo;
    }

    public int getFpgCodigo() {
        return fpgCodigo;
    }

    public void setFpgCodigo(int fpgCodigo) {
        this.fpgCodigo = fpgCodigo;
    }

    public String getFpgNome() {
        return fpgNome;
    }

    public void setFpgNome(String fpgNome) {
        this.fpgNome = fpgNome;
    }

    public char getFpgAtivo() {
        return fpgAtivo;
    }

    public void setFpgAtivo(char fpgAtivo) {
        this.fpgAtivo = fpgAtivo;
    }
}
