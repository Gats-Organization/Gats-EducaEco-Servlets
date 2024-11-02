package Model;

public class Escola {
    // Definindo os atributos da classe Escola
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int id_endereco;

    // Criando o método construtor
    public Escola(int id, String nome, String email, String telefone, int id_endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id_endereco = id_endereco;
    }

    // Método construtor que será executado quando não houver nenhum parâmetro passado
    public Escola() {

    }

    // Método construtor que será executado nos métodos, que não pede o id pois este será gerado automaticamente pelo banco
    public Escola(String nome, String email, String telefone, int id_endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id_endereco = id_endereco;
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
    public String getTelefone() {
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
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Criando o método toString, que definirá como será a representação do objeto na tela
    public String toString() {
        return "Escola: "+ this.nome+ "\nid: "+this.id +"\nemail: "+this.email+"\ntelefone: "+this.telefone+"\nid_endereco: "+this.id_endereco;
    }
}
