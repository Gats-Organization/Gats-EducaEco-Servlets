package Model;

public class Aluno {
    //Definindo os atributos da Classe Aluno
    private int id;
    private String nome;
    private String sobrenome;
    private int xp;
    private String email;
    private String senha;
    private int id_turma;


    //definindo método construtor
    public Aluno(int id, String nome, String sobrenome, int xp, String email, String senha, int id_turma) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.xp = xp;
        this.email = email;
        this.senha = senha;
        this.id_turma = id_turma;
    }
    public Aluno() {

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

    public void setId(int id) {
        this.id = id;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public void setIdTurma(int idTurma) {
        this.id_turma = idTurma;
    }

    //gerando toString

    public String toString() {
        return "Aluno: "+ this.nome + " " + this.sobrenome + "\nid: "+ this.id + "\nemail: "+ this.email+ "\nsenha: "+ this.senha + "\nxp: "+this.xp+"\nidTurma: "+this.id_turma;

    }
}
