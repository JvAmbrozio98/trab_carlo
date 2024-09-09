package modulovendas.Controllers;

import modulovendas.Models.Cliente;
import modulovendas.Connection.ConnectionModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ClienteController {
    private Connection connectionModule = null;

    public ClienteController(ConnectionModule connectionModule) {
        this.connectionModule = ConnectionModule.getConexao();
    }

    public void adicionar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO pessoa (PES_NOME, PES_FANTASIA, " +
                "PES_FISICA, PES_CPFCNPJ, " +
                "PES_RGIE, PES_CADASTRO, " +
                "PES_ENDERECO, PES_NUMERO, " +
                "PES_COMPLEMENTO, PES_BAIRRO, " +
                "PES_CIDADE, PES_UF, PES_CEP, " +
                "PES_FONE1, PES_FONE2, PES_CELULAR, " +
                "PES_SITE, PES_EMAIL, PES_ATIVO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO pessoa (PES_NOME, PES_FANTASIA, PES_FISICA, PES_CPFCNPJ, PES_RGIE, PES_CADASTRO, PES_ENDERECO, PES_NUMERO, PES_COMPLEMENTO, PES_BAIRRO, PES_CIDADE, PES_UF, PES_CEP, PES_FONE1, PES_FONE2, PES_CELULAR, PES_SITE, PES_EMAIL, PES_ATIVO)\n" +
                "VALUES\n" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, 'Y')";
        PreparedStatement stm = connectionModule.prepareStatement(sql);
        stm.setString(1,cliente.getPesNome());
        stm.setString(2,cliente.getPesFantasia());
        stm.setString(3,String.valueOf(cliente.getPesFisica()));
        stm.setString(4,cliente.getPesCpfCnpj());
        stm.setString(5,cliente.getPesRgIe());
        stm.setString(6,cliente.getPesCadastro().format(DateTimeFormatter.BASIC_ISO_DATE));
        stm.setString(7,cliente.getPesEndereco());
        stm.setString(8,cliente.getPesNumero());
        stm.setString();
        stm.execute();
        stm.close();
    }

}
