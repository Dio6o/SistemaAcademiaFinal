package DTO;

public class ExercicioTreino {

    private int treino_id;
    private int exercicio_id;
    private int sets;
    private int repeticeos;

    public ExercicioTreino() {}

    public ExercicioTreino(int treino_id, int exercicio_id) {
        setTreino_id(treino_id);
        setExercicio_id(exercicio_id);
    }

    public ExercicioTreino(int treino_id, int exercicio_id, int sets, int repeticoes) {
        setTreino_id(treino_id);
        setExercicio_id(exercicio_id);
        setSets(sets);
        setRepeticeos(repeticoes);
    }

    public int getTreino_id() {
        return treino_id;
    }

    public void setTreino_id(int treino_id) {
        this.treino_id = treino_id;
    }

    public int getExercicio_id() {
        return exercicio_id;
    }

    public void setExercicio_id(int exercicio_id) {
        this.exercicio_id = exercicio_id;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRepeticeos() {
        return repeticeos;
    }

    public void setRepeticeos(int repeticeos) {
        this.repeticeos = repeticeos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExercicioTreino{");
        sb.append("treino_id=").append(treino_id);
        sb.append(", exercicio_id=").append(exercicio_id);
        sb.append(", sets=").append(sets);
        sb.append(", repeticeos=").append(repeticeos);
        sb.append('}');
        return sb.toString();
    }
}
