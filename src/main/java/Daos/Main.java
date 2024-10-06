package Daos;
import Daos.AlunoDAO;
import Daos.JDBC.Conexao;
import Model.Aluno;
public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        AlunoDAO alunoDao = new AlunoDAO();
        int resulta = alunoDao.inserirAluno(11,"Jussara","Silva",300,"jussara.silva@gats.com","Gats2024@",3);
        if(resulta>0){
            System.out.println("Aluno inserido com sucesso!");
        }
        else {
            System.out.println("Falha ao inserir aluno!");
        }
    }
}
