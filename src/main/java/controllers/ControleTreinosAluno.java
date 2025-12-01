package controllers;

import BO.*;
import DTO.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleTreinosAluno implements Initializable {

    @FXML private TextField caixaBusca;
    @FXML private Label nomeLabel;
    @FXML private Button buscar;
    @FXML private TreeView<TreinoNode> tabelaTreinos;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<TreinoNode> rootItem = new TreeItem<>(new TreinoNode("Treinos"));
        tabelaTreinos.setRoot(rootItem);
    }

    @FXML
    public void buscarAluno(ActionEvent actionEvent) {
        try {
            String nome =  caixaBusca.getText();
            AlunoBO alunoBO = new AlunoBO();
            Aluno aluno = alunoBO.procurarPorNome(nome);

            if(aluno != null){
                mostrarTreino(aluno);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro ao buscar");
                alert.setHeaderText("Aluno não encontrado, tente novamente.");
                caixaBusca.clear();
                alert.showAndWait();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void mostrarTreino(Aluno aluno){

        TreeItem<TreinoNode> root = new TreeItem<>(new TreinoNode("Aluno: " + aluno.getNome()));
        root.setExpanded(true);

        TreinoBO treinoBO = new TreinoBO();
        ExercicioBO exercicioBO = new ExercicioBO();
        ExercicioTreinoBO exercicioTreinoBO = new ExercicioTreinoBO();
        ProfessorBO professorBO = new ProfessorBO();
        Professor professor;

        List<Treino> treinos = treinoBO.pesquisarTreinosAluno(aluno);

        for (Treino treino : treinos) {

            professor = professorBO.procurarPorId(new Professor(treino.getProfessor_id()));

            TreeItem<TreinoNode> treinoNode =
                    new TreeItem<>(new TreinoNode("Treino: " + treino.getNome_treino()+ ", Professor: "
                            + professor.getNome()));

            List<ExercicioTreino> exercicios = exercicioTreinoBO.pesquisarExerciciosTreino(treino);

            for (ExercicioTreino exercicioTreino : exercicios) {

                Exercicio exercicio = exercicioBO.procurarPorId(new Exercicio(exercicioTreino.getExercicio_id()));

                String texto = "Exercício: " + exercicio.getNome() + ", Sets: " +
                        exercicioTreino.getSets() + ", Repetições: " + exercicioTreino.getRepeticeos();

                TreeItem<TreinoNode> exNode = new TreeItem<>(new TreinoNode(texto));

                treinoNode.getChildren().add(exNode);
            }

            root.getChildren().add(treinoNode);
        }

        tabelaTreinos.setRoot(root);
        tabelaTreinos.setShowRoot(true);
    }
    @FXML
    public void itemEscolhido() {
        System.out.println("aaaaaaaaaaaaaaaa");
    }
}
