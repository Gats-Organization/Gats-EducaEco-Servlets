package Model;


    public class Turma {
        //definindo atributos da classe Turma
        private int id;
        private String nomenclatura;
        private int serie;
        private int ano;
        private int id_professor;
        private int id_escola;

        //Criando método construtor
        public Turma(int id, String nomenclatura, int serie, int ano, int id_professor, int id_escola) {
            this.id = id;
            this.nomenclatura = nomenclatura;
            this.serie = serie;
            this.ano = ano;
            this.id_professor = id_professor;
            this.id_escola = id_escola;
        }

        public Turma() {

        }
        //gerando getters e setters
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
        //Criando toString
        @Override
        public String toString() {
            return "Turma: " +this.serie + " " + this.nomenclatura + " " +this.ano + "\nid: " +this.id + "\nid_professor: " +this.id_professor + "\nid_escola: " +this.id_escola;

        }
    }


