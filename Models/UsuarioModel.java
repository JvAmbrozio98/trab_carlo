package modulovendas.Models;

import java.time.LocalDate;

public class UsuarioModel {
    public long usuCodigo;      // USU_CODIGO (SERIAL)
    public String usuNome;      // USU_NOME (VARCHAR(80))
    public String usuLogin;     // USU_LOGIN (VARCHAR(20))
    public String usuSenha;     // USU_SENHA (VARCHAR(20))
    public LocalDate usuCadastro; // USU_CADASTRO (DATE)
    public char usuAtivo;       // USU_ATIVO (CHAR(1))

    public UsuarioModel() {
    }

    public UsuarioModel(char usuAtivo, LocalDate usuCadastro, String usuSenha, String usuLogin, String usuNome, long usuCodigo) {
        this.usuAtivo = usuAtivo;
        this.usuCadastro = usuCadastro;
        this.usuSenha = usuSenha;
        this.usuLogin = usuLogin;
        this.usuNome = usuNome;
        this.usuCodigo = usuCodigo;
    }

    public long getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public LocalDate getUsuCadastro() {
        return usuCadastro;
    }

    public void setUsuCadastro(LocalDate usuCadastro) {
        this.usuCadastro = usuCadastro;
    }

    public char getUsuAtivo() {
        return usuAtivo;
    }

    public void setUsuAtivo(char usuAtivo) {
        this.usuAtivo = usuAtivo;
    }
}
