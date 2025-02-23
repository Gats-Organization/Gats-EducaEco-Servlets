package Model;

public class EscolaDTO {
    // Definindo os atributos da classe Escola
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int id_endereco;
    private String enderecoCompleto;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;


    // Criando o método construtor
    public EscolaDTO(int id, String nome, String email, String telefone, int id_endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id_endereco = id_endereco;
    }

    // Método construtor que será executado quando não houver nenhum parâmetro passado
    public EscolaDTO() {

    }

    // Método construtor que será executado nos métodos de inserção, que não pede o id pois este será gerado automaticamente pelo banco
    public EscolaDTO(String nome, String email, String telefone, String rua, int numero, String bairro, String cidade, String estado, String cep) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    // Método construtor que será executado nos métodos de atualização, que pede o id
    public EscolaDTO(int id, String nome, String email, String telefone , String rua, int numero, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public EscolaDTO(String nome, String email, String telefone, String enderecoCompleto) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.enderecoCompleto = enderecoCompleto;
    }

    public EscolaDTO(int id, String nome, String email, String telefone , String enderecoCompleto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.enderecoCompleto = enderecoCompleto;
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
    public int getNumero() { return numero; }
    public String getRua() { return rua; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }
    public String getTelefone() { return telefone; }
    public int getId_endereco() { return id_endereco;}
    public String getEnderecoCompleto() { return enderecoCompleto; }

    public void setEnderecoCompleto(String enderecoCompleto) { this.enderecoCompleto = enderecoCompleto; }
    public void setId_endereco(int id_endereco) { this.id_endereco = id_endereco; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setNome(String nome) { this.nome = nome; }
    public void setId(int id) { this.id = id; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setRua(String rua) { this.rua = rua; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setCep(String cep) { this.cep = cep; }
    public void setEstado(String estado) { this.estado = estado; }

    // Criando o método toString, que definirá como será a representação do objeto na tela
    public String toString() {
        return "Escola: "+ this.nome+ "\nid: "+this.id +"\nemail: "+this.email+"\ntelefone: "+this.telefone+"\nid_endereco: "+this.id_endereco;

    }
}
