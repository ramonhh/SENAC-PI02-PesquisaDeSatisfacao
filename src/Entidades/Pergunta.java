/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import ClassesAuxiliares.Respostas;

/**
 *
 * @author Ramon Honorio
 */
public class Pergunta {
    private String id;
    private int ordem;
    private String descricao;
    public Respostas respostas = new Respostas();

    public Pergunta(String id, int ordem, String descricao) {
        this.id = id;
        this.ordem = ordem;
        this.descricao = descricao;
    }    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
