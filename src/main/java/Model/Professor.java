package Model;

public class Professor {
    //Definindo os atributos da classe Professor
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    //Criando construtor
    public Professor(int id, String nome, String sobrenome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }
    public Professor() {

    }
    //Gerando getters e setters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
        return "Professor: "+ this.nome + " " + this.sobrenome + "\nId: "+ this.id + "\nEmail: " + this.email + "\nSenha: " + this.senha;
    }
}
