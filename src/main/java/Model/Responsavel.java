package Model;

public class Responsavel {
        //Definindo os atributos da classe responsavel
        private int id;
        private String nome;
        private String sobrenome;
        private String email;
        private int id_aluno;

        //Criando método construtor
        public Responsavel(int id, String nome, String sobrenome, String email, int id_aluno) {
            this.id = id;
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.email = email;
            this.id_aluno = id_aluno;
        }
        public Responsavel() {

        }
        //Gerando getters e setters
        public int getId() { return id; }
        public String getNome() { return nome; }
        public String getSobrenome() { return sobrenome; }
        public String getEmail() { return email; }
        public void setId(int id) {this.id = id;}
        public void setId_aluno(int id_aluno) {this.id_aluno = id_aluno;}
        public void setNome(String nome) { this.nome = nome; }
        public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
        public void setEmail(String email) { this.email = email; }
        public int getId_aluno() { return id_aluno; }

        //Criando método toString
        @Override
        public String toString() {
            return "Responsavel: " +this.nome + " " +this.sobrenome + "\nid: "+this.id + "\nemail: " + "\nid_aluno: " +this.id_aluno;
        }
    }

