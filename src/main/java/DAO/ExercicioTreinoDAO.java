package DAO;

import DTO.ExercicioTreino;
import DAO.Conexao;
import DTO.Treino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExercicioTreinoDAO {

    final String NOMEDATABELA = "exercicios_treino";

    public boolean inserir(ExercicioTreino exercicioTreino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (treino_id, exercicio_id, sets, repeticoes) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, exercicioTreino.getTreino_id());
            ps.setInt(2, exercicioTreino.getExercicio_id());
            ps.setInt(3, exercicioTreino.getSets());
            ps.setInt(4, exercicioTreino.getRepeticeos());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existe(ExercicioTreino exercicioTreino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE treino_id = ? and exercicio_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, exercicioTreino.getTreino_id());
            ps.setInt(2, exercicioTreino.getExercicio_id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean excluir(ExercicioTreino exercicioTreino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE treino_id = ? and exercicio_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, exercicioTreino.getTreino_id());
            ps.setInt(2, exercicioTreino.getExercicio_id());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ExercicioTreino procurarPorId(ExercicioTreino exercicioTreino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE treino_id = ? and exercicio_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, exercicioTreino.getTreino_id());
            ps.setInt(2, exercicioTreino.getExercicio_id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ExercicioTreino obj = new ExercicioTreino();
                obj.setTreino_id(rs.getInt(1));
                obj.setExercicio_id(rs.getInt(2));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ExercicioTreino> pesquisarExerciciosTreino(Treino treino) {
       try {
           Connection conn = Conexao.conectar();
           String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE treino_id = ?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, treino.getTreino_id());
           ResultSet rs = ps.executeQuery();
           List<ExercicioTreino> listaTreino = montarLista(rs);
           return listaTreino;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
    }

    public List<ExercicioTreino> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ExercicioTreino> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ExercicioTreino> montarLista(ResultSet rs) {
        List<ExercicioTreino> listObj = new ArrayList<ExercicioTreino>();
        try {
            while (rs.next()) {
                ExercicioTreino obj = new ExercicioTreino();
                obj.setTreino_id(rs.getInt(1));
                obj.setExercicio_id(rs.getInt(2));
                obj.setSets(rs.getInt(3));
                obj.setRepeticeos(rs.getInt(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
