package controllers;

public class TreinoNode {

    private String descricao;
    private String nomeProfessor;

    public TreinoNode(String descricao) {
        setDescricao(descricao);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
