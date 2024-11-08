package Model;

public class Turma {
    // Definindo atributos da classe Turma
    private int id;
    private int serie;
    private String nomenclatura;
    private int ano;
    private int id_professor;
    private int id_escola;

    // Criando o método construtor
    public Turma(int id,  int serie, String nomenclatura, int ano, int id_professor, int id_escola) {
        this.id = id;
        this.serie = serie;
        this.nomenclatura = nomenclatura;
        this.ano = ano;
        this.id_professor = id_professor;
        this.id_escola = id_escola;
    }

    // Método construtor que será executado quando não houver nenhum parâmetro passado
    public Turma() {

    }

    // Método construtor que será executado nos métodos, que não pede o id pois este será gerado automaticamente pelo banco
    public Turma(int serie, String nomenclatura, int ano, int id_professor, int id_escola) {
        this.serie = serie;
        this.nomenclatura = nomenclatura;
        this.ano = ano;
        this.id_professor = id_professor;
        this.id_escola = id_escola;
    }

    // Gerando métodos getters e setters
    public int getId() {
        return id;
    }
    public String getNomenclatura() {
            return nomenclatura;
        }
    public int getSerie() {
        return serie;
    }
    public int getAno() {
        return ano;
    }
    public int getId_professor() {
        return id_professor;
    }
    public int getId_escola() {
        return id_escola;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }
    public void setId(int id) { this.id = id; }
    public void setNomenclatura(String nomenclatura) { this.nomenclatura = nomenclatura; }
    public void setSerie(int serie) { this.serie = serie; }
    public void setAno(int ano) { this.ano = ano; }
    public void setId_escola(int id_escola) { this.id_escola = id_escola; }

    // Criando o método toString, que definirá como será a representação do objeto na tela
    public String toString() {
        return "Turma: " +this.serie + " " + this.nomenclatura + " " +this.ano + "\nid: " +this.id + "\nid_professor: " +this.id_professor + "\nid_escola: " +this.id_escola;
    }
}


