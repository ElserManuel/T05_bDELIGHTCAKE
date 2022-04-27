/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

public class Cliente {
    int IDCLI;
   String NOMCLI;
   String APECLI;
   String DNICLI;
   String TELCLI;
   String EMACLI;
   String ESTCLI;
   String CODUBI;

    public Cliente() {
    }

    public Cliente(int IDCLI, String NOMCLI, String APECLI, String DNICLI, String TELCLI, String EMACLI, String ESTCLI, String CODUBI) {
        this.IDCLI = IDCLI;
        this.NOMCLI = NOMCLI;
        this.APECLI = APECLI;
        this.DNICLI = DNICLI;
        this.TELCLI = TELCLI;
        this.EMACLI = EMACLI;
        this.ESTCLI = ESTCLI;
        this.CODUBI = CODUBI;
    }

    public int getIDCLI() {
        return IDCLI;
    }

    public void setIDCLI(int IDCLI) {
        this.IDCLI = IDCLI;
    }

    public String getNOMCLI() {
        return NOMCLI;
    }

    public void setNOMCLI(String NOMCLI) {
        this.NOMCLI = NOMCLI;
    }

    public String getAPECLI() {
        return APECLI;
    }

    public void setAPECLI(String APECLI) {
        this.APECLI = APECLI;
    }

    public String getDNICLI() {
        return DNICLI;
    }

    public void setDNICLI(String DNICLI) {
        this.DNICLI = DNICLI;
    }

    public String getTELCLI() {
        return TELCLI;
    }

    public void setTELCLI(String TELCLI) {
        this.TELCLI = TELCLI;
    }

    public String getEMACLI() {
        return EMACLI;
    }

    public void setEMACLI(String EMACLI) {
        this.EMACLI = EMACLI;
    }

    public String getESTCLI() {
        return ESTCLI;
    }

    public void setESTCLI(String ESTCLI) {
        this.ESTCLI = ESTCLI;
    }

    public String getCODUBI() {
        return CODUBI;
    }

    public void setCODUBI(String CODUBI) {
        this.CODUBI = CODUBI;
    }

   

  
}
