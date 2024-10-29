package Model;

public class Admin {
    // Definindo os atributos da classe Admin
    private int id;
    private String nome;
    private String email;
    private String senha;

    // Criando o método construtor
    public Admin(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Método construtor que será executado quando não houver nenhum parâmetro passado
    public Admin() {

    }

    // Método construtor que será executado nos métodos, que não pede o id pois este será gerado automaticamente pelo banco
    public Admin(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Gerando métodos getters e setters
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

    public void setId(int id) {
        this.id = id;
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

    // Criando o método toString, que definirá como será a representação do objeto na tela
    public String toString() {
        return "Admin: "+ this.nome + "\nid: "+ this.id + "\nemail: "+ this.email + "\nsenha: "+ this.senha;

    }
}
