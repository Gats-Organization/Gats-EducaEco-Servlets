package Model;

public class Admin {
    //Definir os atributos da classe Admin
    private int id;
    private String nome;
    private String email;
    private String senha;

    //Criando método construtor
    public Admin(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    //gerando getters e setters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    //Criando toString
    @Override
    public String toString() {
        return "Admin: "+ this.nome + "\nid: "+ this.id + "\nemail: "+ this.email + "\nsenha: "+ this.senha;

    }
}
