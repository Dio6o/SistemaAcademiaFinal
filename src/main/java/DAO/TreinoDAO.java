package DAO;

import DTO.Aluno;
import DTO.Treino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {

    final String NOMEDATABELA = "treinos";

    public boolean inserir(Treino treino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (treino_id, aluno_id, professor_id, nome_treino) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, treino.getTreino_id());
            ps.setInt(2, treino.getAluno_id());
            ps.setInt(3, treino.getProfessor_id());
            ps.setString(4, treino.getNome_treino());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean existe(Treino treino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE treino_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, treino.getTreino_id());
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

    public boolean alterar(Treino treino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET treino_id = ? WHERE treino_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, treino.getTreino_id());
            ps.setInt(2, treino.getTreino_id());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Treino treino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE treino_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, treino.getTreino_id());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Treino procurarPorId(Treino treino) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE treino_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, treino.getTreino_id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Treino obj = new Treino();
                obj.setTreino_id(rs.getInt(1));
                obj.setNome_treino(rs.getString(2));
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


    public List<Treino> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Treino> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Treino> pesquisarTreinosAluno(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE aluno_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getId());
            ResultSet rs = ps.executeQuery();
            List<Treino> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Treino> montarLista(ResultSet rs) {
        List<Treino> listObj = new ArrayList<Treino>();
        try {
            while (rs.next()) {
                Treino obj = new Treino();
                obj.setTreino_id(rs.getInt(1));
                obj.setNome_treino(rs.getString(4));
                obj.setProfessor_id(rs.getInt(3));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
