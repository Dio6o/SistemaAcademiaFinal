package DAO;

public class Exercicio {

    private int exercicioId;
    private String nome;
    private String enderecoImagem;

    public Exercicio() {}

    public Exercicio(int id) {
        setExercicioId(id);
    }

    public Exercicio(String nome) {
        setNome(nome);
    }

    public Exercicio(int exercicioId,String nome) {
        setExercicioId(exercicioId);
        setNome(nome);
    }

    public Exercicio(String nome, String enderecoImagem) {
        setNome(nome);
        setEnderecoImagem(enderecoImagem);
    }

    public int getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(int exercicioId) {
        this.exercicioId = exercicioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoImagem() {
        return enderecoImagem;
    }

    public void setEnderecoImagem(String enderecoImagem) {
        this.enderecoImagem = enderecoImagem;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Exercicio{");
        sb.append("exercicioId=").append(exercicioId);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", enderecoImagem='").append(enderecoImagem).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
