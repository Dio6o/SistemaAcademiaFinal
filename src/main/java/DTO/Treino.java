package DTO;

public class Treino {

    private int treino_id;
    private int aluno_id;
    private int professor_id;
    private String nome_treino;
    private String data_treino;

    public Treino() {}

    public Treino(int treino_id) {
        setTreino_id(treino_id);
    }

    public Treino(int aluno_id, int professor_id, String nome_treino) {
        setAluno_id(aluno_id);
        setProfessor_id(professor_id);
        setNome_treino(nome_treino);
    }

    public Treino(int treino_id, int aluno_id, int professor_id, String nome_treino) {
        setTreino_id(treino_id);
        setAluno_id(aluno_id);
        setProfessor_id(professor_id);
        setNome_treino(nome_treino);
    }

    public Treino(int aluno_id, int professor_id, String nome_treino, String data_treino) {
        setAluno_id(aluno_id);
        setProfessor_id(professor_id);
        setNome_treino(nome_treino);
        setData_treino(data_treino);
    }

    public Treino(int treino_id, int aluno_id, int professor_id, String nome_treino, String data_treino) {
        setTreino_id(treino_id);
        setAluno_id(aluno_id);
        setProfessor_id(professor_id);
        setNome_treino(nome_treino);
        setData_treino(data_treino);
    }

    public int getTreino_id() {
        return treino_id;
    }

    public void setTreino_id(int treino_id) {
        this.treino_id = treino_id;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public String getNome_treino() {
        return nome_treino;
    }

    public void setNome_treino(String nome_treino) {
        this.nome_treino = nome_treino;
    }

    public String getData_treino() {
        return data_treino;
    }

    public void setData_treino(String data_treino) {
        this.data_treino = data_treino;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Treino {");
        sb.append(" id=").append(getTreino_id());
        sb.append(", aluno_id=").append(getAluno_id());
        sb.append(", professor=").append(getProfessor_id());
        sb.append(", data treino=").append(getData_treino());
        sb.append(", nome treino='").append(getNome_treino()).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
