package Model;

public class EscolaDTO {
    //definição dos atributos da classe Escola
    private int id;
    private String nome;
    private String email;
    private int telefone;
    private int id_endereco;
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String enderecoCompleto = rua + "," + numero + "," + bairro + "," + cidade + "," + estado + "," + cep;

    //construtor da classe Escola
    public EscolaDTO(int id, String nome, String email, int telefone, int id_endereco, int numero, String rua, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id_endereco = id_endereco;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public EscolaDTO() {

    }

    public EscolaDTO(String nome, String email, int telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.rua = endereco;

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
    public int getNumero() { return numero; }
    public String getRua() { return rua; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }
    public int getTelefone() { return telefone; }
    public int getId_endereco() { return id_endereco;}
    public String getEnderecoCompleto() { return enderecoCompleto; }
    public void setEnderecoCompleto(String enderecoCompleto) { this.enderecoCompleto = enderecoCompleto; }
    public void setId_endereco(int id_endereco) { this.id_endereco = id_endereco; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(int telefone) { this.telefone = telefone; }
    public void setNome(String nome) { this.nome = nome; }
    public void setId(int id) { this.id = id; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setRua(String rua) { this.rua = rua; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setCep(String cep) { this.cep = cep; }
    public void setEstado(String estado) { this.estado = estado; }

    //gerando o toString
    @Override
    public String toString() {
        return "Escola: "+ this.nome+ "\nid: "+this.id +"\nemail: "+this.email+"\ntelefone: "+this.telefone+"\nid_endereco: "+this.id_endereco;

    }
}
