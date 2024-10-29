package Model;

public class Responsavel {
    // Definindo os atributos da classe Responsavel
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private int id_aluno;

    // Criando o método construtor
    public Responsavel(int id, String nome, String sobrenome, String email, int id_aluno) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.id_aluno = id_aluno;
    }

    // Método construtor que será executado quando não houver nenhum parâmetro passado
    public Responsavel() {

    }

    // Método construtor que será executado nos métodos, que não pede o id pois este será gerado automaticamente pelo banco
    public Responsavel(String nome, String sobrenome, String email, int id_aluno) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.id_aluno = id_aluno;
    }

    //Gerando métodos getters e setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getEmail() { return email; }
    public int getId_aluno() { return id_aluno; }

    public void setId(int id) {this.id = id;}
    public void setId_aluno(int id_aluno) {this.id_aluno = id_aluno;}
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }

    // Criando o método toString, que definirá como será a representação do objeto na tela
    public String toString() {
        return "Responsavel: " +this.nome + " " +this.sobrenome + "\nid: "+this.id + "\nemail: " + "\nid_aluno: " +this.id_aluno;
    }
}

