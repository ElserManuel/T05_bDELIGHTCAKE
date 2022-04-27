/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private int IDPRO;
    private String NOMPRO;
    private Double PREPRO;
   
    private String DESPRO;
    private String ESTPRO;
    private List<Producto> producto;

    public int getIDPRO() {
        return IDPRO;
    }

    public void setIDPRO(int IDPRO) {
        this.IDPRO = IDPRO;
    }

    public String getNOMPRO() {
        return NOMPRO;
    }

    public void setNOMPRO(String NOMPRO) {
        this.NOMPRO = NOMPRO;
    }

    public Double getPREPRO() {
        return PREPRO;
    }

    public void setPREPRO(Double PREPRO) {
        this.PREPRO = PREPRO;
    }

    public String getDESPRO() {
        return DESPRO;
    }

    public void setDESPRO(String DESPRO) {
        this.DESPRO = DESPRO;
    }

    public String getESTPRO() {
        return ESTPRO;
    }

    public void setESTPRO(String ESTPRO) {
        this.ESTPRO = ESTPRO;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    
    
  
}
