/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceAdmin;

import Database.*;
import Entidades.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Honorio
 */
public class Somatorias_Old {
    private static ConexaoSQL sql = new ConexaoSQL();
    private static ResultSet result;
    
    public static int pessimo, ruim, regular, bom, totalRespostas, totalPesquisas;
    public static float pessimoPorcent, ruimPorcent, regularPorcent, bomPorcent;
    
    public static Pergunta perguntas[];
    
    public static void main(String[] args) {
        quantidadePesquisas();
        System.out.println("Pesquisas realizadas: "+totalPesquisas);
        
        carregarSomatorias();
        calcularPorcentagens();
        imprimirClassificacaoNumero();
        imprimirClassificacaoPorcent();
        /*carregarIdPerguntas();
        System.out.println(perguntas[2].getDescricao());*/
        
    }
    
    public static void carregarSomatorias(){
        somatoriaPessimo();
        somatoriaRuim();
        somatoriaRegular();
        somatoriaBom();
        somatoriaTotal();
    }
    
    static void quantidadePesquisas(){
        result = sql.consulta(
                "SELECT COUNT(ID_PESQUISA) as 'qtd' \n" +
                "	FROM T_PESQUISA \n"
        );
        
        try {
            result.next();
            totalPesquisas = result.getInt("qtd");
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void somatoriaPessimo(){
        result = sql.consulta(
                "SELECT COUNT(RESPOSTA) as 'qtd'\n" +
                "	FROM T_QUESTIONARIO\n" +
                "	WHERE RESPOSTA = 'Péssimo'"
        );
        
        try {
            result.next();
            pessimo = result.getInt("qtd");
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void somatoriaRuim(){
        result = sql.consulta(
                "SELECT COUNT(RESPOSTA) as 'qtd'\n" +
                "	FROM T_QUESTIONARIO\n" +
                "	WHERE RESPOSTA = 'Ruim'"
        );
        
        try {
            result.next();
            ruim = result.getInt("qtd");
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void somatoriaRegular(){
        result = sql.consulta(
                "SELECT COUNT(RESPOSTA) as 'qtd'\n" +
                "	FROM T_QUESTIONARIO\n" +
                "	WHERE RESPOSTA = 'Regular'"
        );
        
        try {
            result.next();
            regular = result.getInt("qtd");
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void somatoriaBom(){
        result = sql.consulta(
                "SELECT COUNT(RESPOSTA) as 'qtd'\n" +
                "	FROM T_QUESTIONARIO\n" +
                "	WHERE RESPOSTA = 'Bom'"
        );
        
        try {
            result.next();
            bom = result.getInt("qtd");
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void somatoriaTotal(){
        result = sql.consulta(
                "SELECT COUNT(RESPOSTA) as 'total'\n" +
                "	FROM T_QUESTIONARIO"
        );
        
        try {
            result.next();
            totalRespostas = result.getInt("total");
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void calcularPorcentagens(){
        pessimoPorcent = pessimo * 100 / totalRespostas;
        ruimPorcent = ruim * 100 / totalRespostas;
        regularPorcent = regular * 100 / totalRespostas;
        bomPorcent = bom * 100 / totalRespostas;
    }
    
    static void imprimirClassificacaoPorcent(){
        System.out.println("------------ CLASSIFICAÇÃO GERAL (%) ------------");
        System.out.printf("Pessimo: %.1f%%\n", pessimoPorcent);
        System.out.printf("Ruim: %.1f%%\n", ruimPorcent);
        System.out.printf("Regular: %.1f%%\n", regularPorcent);
        System.out.printf("Bom: %.1f%%\n", bomPorcent);
    }
    
    static void imprimirClassificacaoNumero(){
        System.out.println("--- CLASSIFICAÇÃO GERAL (NUMERO DE SELEÇÕES) ---");
        System.out.println("Péssimo: "+pessimo);
        System.out.println("Ruim: "+ruim);
        System.out.println("Regular: "+regular);
        System.out.println("Bom: "+bom);
        System.out.println("Numero de respostas: "+totalRespostas);
    }
    
    static boolean carregarNumeroPerguntas(){
        result = sql.consulta("SELECT COUNT(ID_PERGUNTA) as 'num'\n"
                + "             FROM T_PERGUNTA\n");
        
        try {
            result.next();
            int n = result.getInt("num");
            perguntas = new Pergunta[n];
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    static void carregarIdPerguntas(){
        if(carregarNumeroPerguntas()){
            result = sql.consulta("SELECT ID_PERGUNTA, ORDEM, DESCRICAO FROM T_PERGUNTA ORDER BY ORDEM ASC\n");

            try {
                for (int i = 0; i < perguntas.length; i++) {
                    result.next();
                    perguntas[i] = new Pergunta(result.getString("ID_PERGUNTA"), result.getInt("ORDEM"), result.getString("DESCRICAO"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Somatorias_Old.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
