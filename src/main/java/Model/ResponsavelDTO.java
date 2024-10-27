package Model;

public class ResponsavelDTO {
        //Definindo os atributos da classe responsavel
        private int id;
        private String nome;
        private String sobrenome;
        private String email;
        private int id_aluno;
        private String nomeAluno;
        private String sobrenomeAluno;

        //Criando método construtor
        public ResponsavelDTO(int id, String nome, String sobrenome, String email, int id_aluno, String nomeAluno, String sobrenomeAluno) {
            this.id = id;
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.email = email;
            this.id_aluno = id_aluno;
            this.nomeAluno = nomeAluno;
            this.sobrenomeAluno = sobrenomeAluno;
        }
    String nomeCompleto = getNomeAluno() + getSobrenomeAluno();
        public ResponsavelDTO() {

        }

    public ResponsavelDTO(String nome, String sobrenome, String email, String nomeCompleto) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.email = email;
            this.nomeCompleto = nomeCompleto;
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
        public String getNomeAluno() { return nomeAluno; }
        public String getSobrenomeAluno() { return sobrenomeAluno; }
        public String getNomeCompleto() {
        return nomeCompleto;
    }
        public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
        public void setId(int id) {this.id = id;}
        public void setId_aluno(int id_aluno) {this.id_aluno = id_aluno;}
        public void setNome(String nome) { this.nome = nome; }
        public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
        public void setEmail(String email) { this.email = email; }
        public int getId_aluno() { return id_aluno; }
        public void setNomeAluno(String nomeAluno) { this.nomeAluno = nomeAluno; }
        public void setSobrenomeAluno(String sobrenomeAluno) { this.sobrenomeAluno = sobrenomeAluno; }


        //Criando método toString
        @Override
        public String toString() {
            return "Responsavel: " +this.nome + " " +this.sobrenome + "\nid: "+this.id + "\nemail: " + "\nid_aluno: " +this.id_aluno;
        }
    }

