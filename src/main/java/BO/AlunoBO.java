package BO;

import DTO.Aluno;
import DAO.AlunoDAO;
import java.util.List;

public class AlunoBO {

    public boolean inserir(Aluno aluno) {
        if (!existe(aluno)) {
            AlunoDAO alunoDAO = new AlunoDAO();
            return alunoDAO.inserir(aluno);
        }
        return false;
    }

    public boolean existe(Aluno aluno) {
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.existe(aluno);
    }

    public boolean alterar(Aluno aluno) {
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.alterar(aluno);
    }

    public boolean excluir(Aluno aluno) {
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.excluir(aluno);
    }

    public Aluno procurarPorId(int id) {
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.procurarPorId(id);
    }

    public Aluno procurarPorNome(String nome) {
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.procurarPorNome(nome);
    }

    public List<Aluno> pesquisarTodos() {
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.pesquisarTodos();
    }


}
