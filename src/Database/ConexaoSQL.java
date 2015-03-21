package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoSQL {
    //Status da conexao
    private String status = "Não conectado";
    private static Connection conexao;
    private static Statement query;
    
    //Atributos da conexao;
    private String servidor;
    private int porta;
    private String banco;
    private String login;
    private String senha;

    public ConexaoSQL(String servidor, int porta, String banco, String login, String senha) {
        this.servidor = servidor;
        this.porta = porta;
        this.banco = banco;
        this.login = login;
        this.senha = senha;
        
        conectar();
    }
    
    public ConexaoSQL(){
        
        //pcMaikon();
        pcRamon();
        
        conectar();
    }
    
    void pcRamon(){
        this.servidor = "WIN-F9KH5MLL0II\\SQLEXPRESS";
        this.porta = 60256;
        this.banco = "DBPesquisaSatisfacao";
        this.login = "ramonh";
        this.senha = "1234";
    }
    
    void pcMaikon(){
        this.servidor = "CAPIROTO\\SQLEXPRESS";
        this.porta = 1433;
        this.banco = "PI2";
        this.login = "maikon";
        this.senha = "1234";
    }
    
    public void conectar() {
        try {            
            String URL =  "jdbc:sqlserver://"+servidor+":"+porta+";databaseName=" + banco +
                          ";user=" + login + ";password="+senha;
 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexao = DriverManager.getConnection(URL);
 
            //Executa pedido SQL
            query = conexao.createStatement();
            status = "Conectado";
            
            System.out.println("A conexão com o banco de dados foi efetuada com sucesso.");
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe não encontrada. [DATABASE]");
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, "ClassNotFoundException", ex);
        } catch (SQLException ex) {
            System.err.println("Houve um erro durante a conexão com o banco de dados.");
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, "SQLException", ex);
        }
    }
    
    public ResultSet consulta(String consulta){
        try {
            ResultSet rs = query.executeQuery(consulta);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, "SQLException", ex);
        }
        
        return null;
    }
    
    public void executar(String comando){
        try {
           query.execute(comando);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, "SQLException", ex);
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters() da Conexao">
    public String getStatus() {
        return status;
    }
    
    public String getServidor() {
        return servidor;
    }
    
    public int getPorta() {
        return porta;
    }
    
    public String getBanco() {
        return banco;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    
//</editor-fold>

    public Connection getConexao() {
        return conexao;
    }

    public Statement getStatement() {
        return query;
    }
    
}
