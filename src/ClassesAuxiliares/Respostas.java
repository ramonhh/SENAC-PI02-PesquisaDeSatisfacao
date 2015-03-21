/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAuxiliares;

/**
 *
 * @author Ramon Honorio
 */
public class Respostas {
    private int escolhasBom;
    private int escolhasRegular;
    private int escolhasRuim;
    private int escolhasPessimo;

    public Respostas() {
        escolhasBom = 0;
        escolhasRegular = 0;
        escolhasRuim = 0;
        escolhasPessimo = 0;
    }

    public int getEscolhasBom() {
        return escolhasBom;
    }

    public void setEscolhasBom(int escolhasBom) {
        this.escolhasBom = escolhasBom;
    }

    public int getEscolhasRegular() {
        return escolhasRegular;
    }

    public void setEscolhasRegular(int escolhasRegular) {
        this.escolhasRegular = escolhasRegular;
    }

    public int getEscolhasRuim() {
        return escolhasRuim;
    }

    public void setEscolhasRuim(int escolhasRuim) {
        this.escolhasRuim = escolhasRuim;
    }

    public int getEscolhasPessimo() {
        return escolhasPessimo;
    }

    public void setEscolhasPessimo(int escolhasPessimo) {
        this.escolhasPessimo = escolhasPessimo;
    }
    
    
}
