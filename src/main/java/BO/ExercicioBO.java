package BO;

import DTO.Exercicio;
import DAO.ExercicioDAO;
import java.util.List;

public class ExercicioBO {

    public boolean inserir(Exercicio exercicio) {
        if (!existe(exercicio)) {
            ExercicioDAO exercicioDAO = new ExercicioDAO();
            return exercicioDAO.inserir(exercicio);
        }
        return false;
    }

    public boolean existe(Exercicio exercicio) {
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        return exercicioDAO.existe(exercicio);
    }

    public boolean alterar(Exercicio exercicio) {
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        return exercicioDAO.alterar(exercicio);
    }

    public boolean excluir(Exercicio exercicio) {
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        return exercicioDAO.excluir(exercicio);
    }

    public Exercicio procurarPorId(Exercicio exercicio) {
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        return exercicioDAO.procurarPorId(exercicio);
    }

    public Exercicio procurarPorNome(String nome) {
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        return exercicioDAO.procurarPorNome(nome);
    }

    public List<Exercicio> pesquisarTodos() {
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        return exercicioDAO.pesquisarTodos();
    }
}
