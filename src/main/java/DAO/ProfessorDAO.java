package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DTO.Professor;
import DAO.Conexao;

public class ProfessorDAO {

    final String NOMEDATABELA = "professores";

    public boolean inserir(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome, sobrenome, cpf, data_nascimento, cref, senha) VALUES (?, ?, ?, ?, ?, ?) ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getSobrenome());
            ps.setString(3, professor.getCpf());
            ps.setString(4, professor.getDataNascimento());
            ps.setString(5, professor.getCref());
            ps.setInt(6, professor.getSenha());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existe(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getNome());
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

    public boolean alterar(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE professor_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setInt(2, professor.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE professor_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, professor.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Professor procurarPorId(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE professor_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, professor.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professor obj = new Professor();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
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
    public Professor procurarPorNome(String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professor obj = new Professor();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
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
            return null;
        }
    }

    public Professor procurarPorCpf(String cpf) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professor obj = new Professor();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setSobrenome(rs.getString(3));
                obj.setCpf(rs.getString(4));
                obj.setSenha(rs.getInt(7));
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
            return null;
        }
    }

    public List<Professor> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Professor> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Professor> montarLista(ResultSet rs) {
        List<Professor> listObj = new ArrayList<Professor>();
        try {
            while (rs.next()) {
                Professor obj = new Professor();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setSobrenome(rs.getString(3));
                obj.setDataNascimento(rs.getString(5));
                obj.setCref(rs.getString(6));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
