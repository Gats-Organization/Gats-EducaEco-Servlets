package Model;

public class Responsavel {
        //Definindo os atributos da classe responsavel
        private int id;
        private String nome;
        private String sobrenome;
        private String email;
        private String senha;
        private int id_aluno;

        //Criando método construtor
        public Responsavel(int id, String nome, String sobrenome, String email,String senha, int id_aluno) {
            this.id = id;
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.email = email;
            this.senha = senha;
            this.id_aluno = id_aluno;
        }
        //Gerando getters e setters
        public int getId() {
            return id;
        }
        public String getNome() {
            return nome;
        }
        public String getSobrenome() {
            return sobrenome;
        }
        public String getEmail() {
            return email;
        }
        public String getSenha() {
            return senha;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }
        public int getId_aluno() {
            return id_aluno;
        }

        //Criando método toString
        @Override
        public String toString() {
            return "Responsavel: " +this.nome + " " +this.sobrenome + "\nid: "+this.id + "\nemail: " +this.email + "\nsenha: " +this.senha + "\nid_aluno: " +this.id_aluno;
        }
    }

