/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceAdmin;

import Database.ConexaoSQL;
import Entidades.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Honorio
 */
public class Somatorias {
    private static ConexaoSQL sql = new ConexaoSQL();
    private static ResultSet result;
    
    private static Pergunta[] pergunta;
    private static int qtdPesquisas;
    
    public static void main(String[] args) {
        carregarNumeroEscolhas();
        imprimir();
    }
    
    private static void carregarNumeroEscolhas(){
        carregarPerguntas();
        quantidadePesquisas();
        result = sql.consulta(""
                + "SELECT T_PERGUNTA.ORDEM, T_QUESTIONARIO.ID_PERGUNTA, RESPOSTA, NUMERO_ESCOLHAS = COUNT(RESPOSTA)\n" +
                "	FROM T_QUESTIONARIO\n" +
                "	LEFT JOIN T_PERGUNTA\n" +
                "	ON T_QUESTIONARIO.ID_PERGUNTA = T_PERGUNTA.ID_PERGUNTA\n" +
                "	GROUP BY T_PERGUNTA.ORDEM, RESPOSTA, T_QUESTIONARIO.ID_PERGUNTA\n" +
                "	ORDER BY T_PERGUNTA.ORDEM");
        
        try {
            while(result.next()){
                for (int i = 0; i < pergunta.length; i++) {
                    if(pergunta[i].getOrdem() == result.getInt("ORDEM")){
                        int num = result.getInt("NUMERO_ESCOLHAS");
                        switch(result.getString("RESPOSTA")){
                            case "Bom":
                                pergunta[i].respostas.setEscolhasBom(num);
                                break;
                            case "Regular":
                                pergunta[i].respostas.setEscolhasRegular(num);
                                break;
                            case "Ruim":
                                pergunta[i].respostas.setEscolhasRuim(num);
                                break;
                            case "Péssimo":
                                pergunta[i].respostas.setEscolhasPessimo(num);
                                break;
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void imprimir(){
        System.out.println("--------------------------");
        System.out.println("| Pesquisas realizadas: "+qtdPesquisas);
        for (int i = 0; i < pergunta.length; i++) {
            System.out.println("| "+pergunta[i].getOrdem()+") "+pergunta[i].getDescricao());
            System.out.printf("| Bom: %d    Regular: %d    Ruim: %d    Péssimo: %d\n",
                    pergunta[i].respostas.getEscolhasBom(),
                    pergunta[i].respostas.getEscolhasRegular(),
                    pergunta[i].respostas.getEscolhasRuim(),
                    pergunta[i].respostas.getEscolhasPessimo());
        }
        System.out.println("--------------------------");
    }
    
    static void carregarPerguntas(){
        if(carregarNumeroPerguntas()){
            result = sql.consulta("SELECT ID_PERGUNTA, ORDEM, DESCRICAO FROM T_PERGUNTA ORDER BY ORDEM ASC\n");

            try {
                for (int i = 0; i < pergunta.length; i++) {
                    result.next();
                    pergunta[i] = new Pergunta(result.getString("ID_PERGUNTA"), result.getInt("ORDEM"), result.getString("DESCRICAO"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    static boolean carregarNumeroPerguntas(){
        result = sql.consulta("SELECT COUNT(ID_PERGUNTA) as 'num'\n"
                + "             FROM T_PERGUNTA\n");
        
        try {
            result.next();
            int n = result.getInt("num");
            pergunta = new Pergunta[n];
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    static void quantidadePesquisas(){
        result = sql.consulta(
                "SELECT COUNT(ID_PESQUISA) as 'qtd' \n" +
                "	FROM T_PESQUISA \n"
        );
        
        try {
            result.next();
            qtdPesquisas = result.getInt("qtd");
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}