package Entidades;

/**
 *
 * @author Maikon Evangelista
 */
public class Cliente {
    private String id;
    private String nome;
    private String cpf;

    public Cliente(String id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public Cliente(Cliente cliente) {
        this.nome = cliente.nome;
        this.cpf = cliente.cpf;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCPF(){
        return cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
