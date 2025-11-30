import DTO.Aluno;
import BO.AlunoBO;
import DAO.Conexao;

public class Main {
    public static void main(String[] args) {

        AlunoBO alunoBO = new AlunoBO();

        System.out.print(alunoBO.pesquisarTodos().getFirst().getNome());

    }

}
