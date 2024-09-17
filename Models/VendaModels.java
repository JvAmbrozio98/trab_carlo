package modulovendas.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaModels {
    public long vdaCodigo;         // VDA_CODIGO (SERIAL)
    public int usuCodigo;          // USU_CODIGO (INTEGER)
    public int cliCodigo;          // CLI_CODIGO (INTEGER)
    public LocalDate vdaData;      // VDA_DATA (DATE)
    public BigDecimal vdaValor;    // VDA_VALOR (NUMERIC(18,2))
    public BigDecimal vdaDesconto; // VDA_DESCONTO (NUMERIC(18,2))
    public BigDecimal vdaTotal;    // VDA_TOTAL (NUMERIC(18,2))
    public String vdaObs;          // VDA_OBS (TEXT)

    public VendaModels() {
    }

    public VendaModels(long vdaCodigo, int usuCodigo, int cliCodigo, LocalDate vdaData, BigDecimal vdaValor, BigDecimal vdaDesconto, BigDecimal vdaTotal, String vdaObs) {
        this.vdaCodigo = vdaCodigo;
        this.usuCodigo = usuCodigo;
        this.cliCodigo = cliCodigo;
        this.vdaData = vdaData;
        this.vdaValor = vdaValor;
        this.vdaDesconto = vdaDesconto;
        this.vdaTotal = vdaTotal;
        this.vdaObs = vdaObs;
    }

    public long getVdaCodigo() {
        return vdaCodigo;
    }

    public void setVdaCodigo(long vdaCodigo) {
        this.vdaCodigo = vdaCodigo;
    }

    public int getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(int usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public int getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(int cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public LocalDate getVdaData() {
        return vdaData;
    }

    public void setVdaData(LocalDate vdaData) {
        this.vdaData = vdaData;
    }

    public BigDecimal getVdaValor() {
        return vdaValor;
    }

    public void setVdaValor(BigDecimal vdaValor) {
        this.vdaValor = vdaValor;
    }

    public BigDecimal getVdaDesconto() {
        return vdaDesconto;
    }

    public void setVdaDesconto(BigDecimal vdaDesconto) {
        this.vdaDesconto = vdaDesconto;
    }

    public BigDecimal getVdaTotal() {
        return vdaTotal;
    }

    public void setVdaTotal(BigDecimal vdaTotal) {
        this.vdaTotal = vdaTotal;
    }

    public String getVdaObs() {
        return vdaObs;
    }

    public void setVdaObs(String vdaObs) {
        this.vdaObs = vdaObs;
    }
}
