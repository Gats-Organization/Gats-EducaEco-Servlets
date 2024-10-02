package Daos.Escola;

public class Escola {
    //definição dos atributos da classe Escola
    private int id;
    private String nome;
    private String email;
    private int telefone;
    private int id_endereco;

    //construtor da classe Escola
    public Escola(int id, String nome, String email, int telefone, int id_endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id_endereco = id_endereco;
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
    public int getTelefone() {
        return telefone;
    }
    public int getId_endereco() {
        return id_endereco;
    }
    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    //gerando o toString
    @Override
    public String toString() {
        return "Escola: "+ this.nome+ "\nid: "+this.id +"\nemail: "+this.email+"\ntelefone: "+this.telefone+"\nid_endereco: "+this.id_endereco;

    }
}
