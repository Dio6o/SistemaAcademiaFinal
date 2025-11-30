package BO;

import DTO.Professor;
import DAO.ProfessorDAO;
import java.util.List;

public class ProfessorBO {

    public boolean inserir(Professor professor) {
        if (!existe(professor)) {
            ProfessorDAO professorDAO = new ProfessorDAO();
            return professorDAO.inserir(professor);
        }
        return false;
    }

    public boolean existe(Professor professor) {
        ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.existe(professor);
    }

    public boolean alterar(Professor professor) {
        ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.alterar(professor);
    }

    public boolean excluir(Professor professor) {
        ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.excluir(professor);
    }

    public Professor procurarPorId(Professor professor) {
        ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.procurarPorId(professor);
    }

    public Professor procurarPorNome(String nome) {
        ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.procurarPorNome(nome);
    }

    public List<Professor> pesquisarTodos() {
        ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.pesquisarTodos();
    }


}
