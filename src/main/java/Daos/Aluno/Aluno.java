package Daos.Aluno;

public class Aluno {
    //Definindo os atributos da Classe Aluno
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private int xp;
    private int id_turma;


    //definindo método construtor
    public Aluno(int id, String nome, String sobrenome, String email, String senha, int xp, int id_turma) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.xp = xp;
        this.id_turma = id_turma;
    }



    //gerando getters e setters
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public int getXp() {
        return this.xp;
    }

    public int getId_turma() {
        return this.id_turma;
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

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    //gerando toString

    public String toString() {
        return "Aluno: "+ this.nome + " " + this.sobrenome + "\nid: "+ this.id + "\nemail: "+ this.email+ "\nsenha: "+ this.senha + "\nxp: "+this.xp+"\nidTurma: "+this.id_turma;

    }
}
