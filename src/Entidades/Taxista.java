/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Ramon Honorio
 */
public class Taxista {
    private String id;
    private String nome;
    private String cpf;
    private String senha;
    
    public Taxista (String id, String nome, String cpf, String senha){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public Taxista(String cpf, String senha){
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public Taxista(Taxista t){
        this.id = t.getId();
        this.nome = t.nome;
        this.cpf = t.cpf;
        this.senha = t.senha;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
