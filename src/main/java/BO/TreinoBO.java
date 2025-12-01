package BO;

import DTO.Aluno;
import DTO.Treino;
import DAO.TreinoDAO;

import java.util.List;

public class TreinoBO {

    public boolean inserir(Treino treino) {
        if (!existe(treino)) {
            TreinoDAO treinoDAO = new TreinoDAO();
            return treinoDAO.inserir(treino);
        }
        return false;
    }

    public boolean existe(Treino treino) {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.existe(treino);
    }

    public boolean alterar(Treino treino) {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.alterar(treino);
    }

    public boolean excluir(Treino treino) {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.excluir(treino);
    }

    public Treino procurarPorId(Treino treino) {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.procurarPorId(treino);
    }

    public List<Treino> pesquisarTreinosAluno(Aluno aluno){
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.pesquisarTreinosAluno(aluno);
    }

    public List<Treino> pesquisarTodos() {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.pesquisarTodos();
    }
}
