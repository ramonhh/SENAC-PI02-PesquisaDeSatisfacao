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
public class Questionario {
    private String id;
    private String[] resposta;

    public Questionario(String id, String[] resposta) {
        this.id = id;
        this.resposta = resposta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getResposta() {
        return resposta;
    }

    public void setResposta(String[] resposta) {
        this.resposta = resposta;
    }
    
    public void setResposta(String resposta, int posicao){
        this.resposta[posicao] = resposta;
    }
    
    
}
