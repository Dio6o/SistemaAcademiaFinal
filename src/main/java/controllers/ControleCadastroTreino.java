package controllers;

import BO.*;
import DTO.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControleCadastroTreino implements Initializable {

    @FXML
    private TextField nome;
    @FXML
    private ComboBox<Aluno> alunos;
    @FXML
    private ComboBox<Professor> professores;
    @FXML
    private ListView<Exercicio> listaExercicios;
    @FXML private Button cadastrar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarAlunos();
        carregarProfessores();
        carregarExercicios();

        listaExercicios.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    private ObservableList<Exercicio> exerciciosSelecionados = FXCollections.observableArrayList();

    private void carregarAlunos() {
        try {
            AlunoBO alunoBO = new AlunoBO();
            List<Aluno> lista = alunoBO.pesquisarTodos();

            alunos.setItems(FXCollections.observableArrayList(lista));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarProfessores() {
        try {
            ProfessorBO professorBO = new ProfessorBO();
            List<Professor> lista = professorBO.pesquisarTodos();

            professores.setItems(FXCollections.observableArrayList(lista));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarExercicios() {
        try {
            ExercicioBO exercicioBO = new ExercicioBO();
            List<Exercicio> exercicios = exercicioBO.pesquisarTodos();

            listaExercicios.setItems(FXCollections.observableArrayList(exercicios));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void cadastrar(ActionEvent event) {

        try {
            String nomeT = nome.getText();
            Aluno aluno = alunos.getValue();
            Professor professor = professores.getValue();

            if (nomeT.isEmpty() || aluno == null) {
                mostrarErro();
            }

            TreinoBO treinoBO = new TreinoBO();
            Treino treino = new Treino();
            treino.setTreino_id(treinoBO.pesquisarTodos().size());
            treino.setNome_treino(nomeT);
            treino.setAluno_id(aluno.getId());
            treino.setProfessor_id(professor.getId());

            System.out.println(treino);
            treinoBO.inserir(treino);

            List<Exercicio> selecionados = new ArrayList<>(listaExercicios.getSelectionModel().getSelectedItems());

            if (selecionados.isEmpty()) {
                mostrarErro();
            }

            ExercicioTreinoBO exercicioTreinoBO = new ExercicioTreinoBO();

            for (Exercicio exercicio : selecionados) {

                ExercicioTreino et = new ExercicioTreino();
                et.setTreino_id(treino.getTreino_id());
                et.setExercicio_id(exercicio.getExercicioId());

                exercicioTreinoBO.inserir(et);
                System.out.print("loop");
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Treino Cadastrado");
            alert.setHeaderText("Treino Cadastrado com sucesso");
            alert.showAndWait();
            limparCampos();

        } catch (Exception e) {
            e.printStackTrace();
            mostrarErro();
        }
    }

    private void limparCampos() {
        nome.clear();
        alunos.setValue(null);
        professores.setValue(null);
        listaExercicios.getSelectionModel().clearSelection();
    }

    private void mostrarErro() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Erro no cadastro do treino");
        alert.showAndWait();
    }

}

