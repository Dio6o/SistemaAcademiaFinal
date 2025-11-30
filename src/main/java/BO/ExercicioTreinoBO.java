package BO;

import DTO.ExercicioTreino;
import DAO.ExercicioTreinoDAO;
import DTO.Treino;

import java.util.List;


public class ExercicioTreinoBO {

    public boolean inserir(ExercicioTreino exercicio) {
        if (!existe(exercicio)) {
            ExercicioTreinoDAO exercicioDAO = new ExercicioTreinoDAO();
            return exercicioDAO.inserir(exercicio);
        }
        return false;
    }

    public boolean existe(ExercicioTreino exercicio) {
        ExercicioTreinoDAO exercicioDAO = new ExercicioTreinoDAO();
        return exercicioDAO.existe(exercicio);
    }


    public boolean excluir(ExercicioTreino exercicio) {
        ExercicioTreinoDAO exercicioDAO = new ExercicioTreinoDAO();
        return exercicioDAO.excluir(exercicio);
    }

    public ExercicioTreino procurarPorId(ExercicioTreino exercicio) {
        ExercicioTreinoDAO exercicioDAO = new ExercicioTreinoDAO();
        return exercicioDAO.procurarPorId(exercicio);
    }


    public List<ExercicioTreino> pesquisarTodos() {
        ExercicioTreinoDAO exercicioDAO = new ExercicioTreinoDAO();
        return exercicioDAO.pesquisarTodos();
    }

    public List<ExercicioTreino> pesquisarExerciciosTreino(Treino treino) {
        ExercicioTreinoDAO exercicioDAO = new ExercicioTreinoDAO();
        return exercicioDAO.pesquisarExerciciosTreino(treino);
    }
}
