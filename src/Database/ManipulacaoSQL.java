/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Entidades.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Honorio
 */
public class ManipulacaoSQL {
    private static ConexaoSQL sql = new ConexaoSQL();
    private ResultSet result;
    
    // -------------- PASSAGEIRO ---------------
    
    public boolean inserirPassageiro(Cliente cliente){
        cliente.setNome(cliente.getNome().toUpperCase());
        if(!existePassageiro(cliente)){
            sql.executar(
                "INSERT INTO [dbo].[T_PASSAGEIRO]\n" +
                "           ([ID_PASSAGEIRO]\n" +
                "           ,[NOME_COMPLETO]\n" +
                "           ,[CPF])\n" +
                "     VALUES\n" +
                "           (NEWID()\n" +
                "           ,'"+cliente.getNome()+"'\n" +
                "           ,'"+cliente.getCPF()+"')"
            );
            System.out.println(">> Novo passageiro cadastrado!");
            
            result = sql.consulta(""
                + "SELECT * FROM T_PASSAGEIRO "
                + "WHERE CPF = '"+cliente.getCPF()+"'");
            
            String idGerado = "";
            try {
                if(result.next());
                    idGerado = result.getString("ID_PASSAGEIRO");
            } catch (SQLException ex) {
                Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(">> ID gerado para o passageiro: "+idGerado);
            
            cliente.setId(idGerado);
            return true;
        } else {
            System.out.println(">> Passageiro informado já existe no banco.");
            cliente.setCPF("");
            return false;
        }
    }
    
    public boolean existePassageiro(Cliente cliente){
        result = sql.consulta(""
                + "SELECT * FROM T_PASSAGEIRO "
                + "WHERE CPF = '"+cliente.getCPF()+"'");
        
        try {
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void imprimirPassageiros(){
        result = sql.consulta(""
                + "SELECT * FROM T_PASSAGEIRO "
                + "ORDER BY NOME_COMPLETO ASC");
        
        System.out.println("-------TABELA DE PASSAGEIROS-------");
        try {
            System.err.println("ID_PASSAGEIRO\t\t\t\tNOME_COMPLETO\t\tCPF");
            while(result.next()){
                System.out.print(result.getString("ID_PASSAGEIRO"));
                System.out.print("\t"+result.getString("NOME_COMPLETO"));
                System.out.println("\t"+result.getString("CPF"));
            }
            System.out.println("-----------------------------------");
        } catch (SQLException ex) {
            Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    // --------------- TAXISTA ------------------
    
    public boolean autenticarTaxista(Taxista login){        
        try {
            Taxista autentic = new Taxista(
                    result.getString("ID_TAXISTA"),
                    result.getString("NOME_COMPLETO"),
                    result.getString("CPF"),
                    result.getString("SENHA"));

            if(login.getSenha().equals(autentic.getSenha())){
                login.setNome(autentic.getNome());
                login.setId(autentic.getId());
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean existeTaxista(Taxista login){
        result = sql.consulta(""
                + "SELECT * FROM T_TAXISTA "
                + "WHERE CPF = '"+login.getCpf()+"'");
        
        try { 
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // --------- PESQUISA / QUESTIONARIO --------
    
    public void cadastrarQuestionario(Taxista taxista, Cliente passageiro, Pergunta[] perguntas, Questionario questionario) {
        
        try {
            // Inicio da transacao
            transacaoInicio();
        
            // Cadastrando o passageiro no banco
            inserirPassageiro(passageiro);

            // Recebendo as respostas
            String[] respostas = questionario.getResposta();

            // Preparando uma instancia para efetuar registro em T_PESQUISA
            Pesquisa pesquisa = new Pesquisa();
            pesquisa.setDataAtual();
            pesquisa.setSugestao(respostas[respostas.length-1]);

            //<editor-fold defaultstate="collapsed" desc="Efetuando registro em T_PESQUISA">
            sql.executar(
                    "INSERT INTO [dbo].[T_PESQUISA] \n" +
                            "                ([ID_PESQUISA]\n" +
                            "                ,[ID_PASSAGEIRO]\n" +
                            "                ,[ID_TAXISTA]\n" +
                            "                ,[DATA_REALIZACAO]\n" +
                            "                ,[SUGESTAO])\n" +
                            "            VALUES\n" +
                            "                (NEWID()\n" +
                            "                ,'"+passageiro.getId()+"'\n" +
                            "                ,'"+taxista.getId()+"'\n" +
                            "                ,'"+pesquisa.getData()+"'\n" +
                            "                ,'"+pesquisa.getSugestao()+"'"
                            + ")");
            System.out.println(">> Registro em T_PESQUISA realizado com sucesso.");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Atribuindo o ID_PESQUISA p/ a instancia 'pesquisa'">
            result = sql.consulta(""
                    + "SELECT * FROM T_PESQUISA "
                    + "WHERE ID_PASSAGEIRO = '"+passageiro.getId()+"'");
            try {
                if(result.next()){
                    String novoId = result.getString("ID_PESQUISA");
                    pesquisa.setId(novoId);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Efetuando registro em T_QUESTIONARIO">
            for (int i = 0; i < perguntas.length; i++) {
                sql.executar(
                        "INSERT INTO [dbo].[T_QUESTIONARIO]\n" +
                    "           ([ID_QUESTIONARIO]\n" +
                    "           ,[ID_PESQUISA]\n" +
                    "           ,[ID_PERGUNTA]\n" +
                    "           ,[RESPOSTA])\n" +
                    "     VALUES\n" +
                    "           (NEWID()\n" +
                    "           ,'"+pesquisa.getId()+"'\n" +
                    "           ,'"+perguntas[i].getId()+"'\n" +
                    "           ,'"+respostas[i]+"'"
                    + ")");
            }
            System.out.println(">> Registro em T_QUESTIONARIO realizado com sucesso.");
    //</editor-fold>
            
            transacaoCommit();
            
        } catch (SQLException ex) {
            try {
                transacaoRollback();
                Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                System.out.println(">> Falha ao efetuar o rollback.");
                Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    // --------------- PERGUNTAS ------------------
    public Pergunta[] carregarPerguntas(){
        Pergunta perguntas[] = new Pergunta[5];
        
        result = sql.consulta("SELECT COUNT(ORDEM) AS 'CONT' FROM T_PERGUNTA");
        try {
            if(result.next()) {
                perguntas = new Pergunta[result.getInt("CONT")];
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        result = sql.consulta("SELECT * FROM T_PERGUNTA ORDER BY ORDEM ASC");
        
        try {
            int i = 0;
            while(i < perguntas.length){
                result.next();
                perguntas[i] = new Pergunta(result.getString("ID_PERGUNTA"), 
                                            result.getInt("ORDEM"), 
                                            result.getString("DESCRICAO"));
                i++;
            }
            return perguntas;
        } catch (SQLException ex) {
            Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, "SQLException [CARREGAR PERGUNTAS]", ex);
        } catch (NullPointerException ex){
            Logger.getLogger(ManipulacaoSQL.class.getName()).log(Level.SEVERE, "NullPointerException [CARREGAR PERGUNTAS]", ex);
        }
        
        return perguntas;
    }
    
    // --------------- CONEXAO SQL ------------------
    public void transacaoInicio() throws SQLException {
        sql.getConexao().setAutoCommit(false);
        sql.getConexao().createStatement();
    }
    
    public void transacaoCommit() throws SQLException{
        sql.getConexao().commit();
        System.out.println(">> Commit realizado com sucesso.");
    }
    
    public void transacaoRollback() throws SQLException{
        System.out.println(">> Falha ao cadastrar questionário. Desfazendo alterações...");
        sql.getConexao().rollback();
        System.out.println(">> Rollback realizado com sucesso.");
    }
        
}
