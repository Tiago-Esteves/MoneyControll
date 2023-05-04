package model;
/**
 * @author tiago
 */

import java.util.Date;

public class Lancamento {
    private int ideObjeto;
    private int ideUsuario;
    private int ideTipo;
    private String descricao;
    private Date data;
    private float valor;

    public Lancamento(int ideObjeto, int ideUsuario, int ideTipo, String descricao, Date Data, float valor) {
        this.ideObjeto = ideObjeto;
        this.ideUsuario = ideUsuario;
        this.ideTipo = ideTipo;
        this.descricao = descricao;
        this.data = new Date();
        this.valor = valor;
    }
    
    public Lancamento(){
        this.data = new Date();
    }

    public int getIdeObjeto() {
        return ideObjeto;
    }

    public void setIdeObjeto(int ideObjeto) {
        this.ideObjeto = ideObjeto;
    }
    
    public int getIdeUsuario() {
        return ideUsuario;
    }

    public void setIdeUsuario(int ideUsuario) {
        this.ideUsuario = ideUsuario;
    }

    public int getIdeTipo() {
        return ideTipo;
    }

    public void setIdeTipo(int ideTipo) {
        this.ideTipo = ideTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date Data) {
        this.data = Data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
