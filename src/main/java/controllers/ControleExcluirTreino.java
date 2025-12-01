package controllers;

import BO.AlunoBO;
import BO.ProfessorBO;
import BO.TreinoBO;
import DTO.Aluno;
import DTO.Treino;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControleExcluirTreino implements Initializable {

    @FXML
    private ComboBox<Aluno> alunos;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoPesquisar;

    @FXML
    private ComboBox<Treino> treinos;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarAlunos();
    }

    @FXML
    void excluir(ActionEvent event) {
        Treino treinoSelecionado = treinos.getSelectionModel().getSelectedItem();
        if (treinoSelecionado != null) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmação");
            alerta.setHeaderText("Tem certeza que deseja excluir esse treino?, essa ação não pode ser desfeita.");
            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.get() == ButtonType.OK) {
                TreinoBO treinoBO = new TreinoBO();
                if (treinoBO.excluir(treinos.getValue())){
                    mostrarAlerta("Treino excluido com sucesso!");
                } else {
                    mostrarAlerta("Erro ao excluir treino!");
                }
            } else {
                alunos.setValue(null);
                treinos.setValue(null);
            }
        }
    }

    @FXML
    void pesquisar(ActionEvent event) {
        Aluno aluno = alunos.getSelectionModel().getSelectedItem();
        if (aluno != null) {
            TreinoBO treinoBO = new TreinoBO();
            treinos.setItems(FXCollections.observableArrayList(treinoBO.pesquisarTreinosAluno(aluno)));
        }
    }

    public void carregarAlunos() {
        try {
            AlunoBO alunoBO = new AlunoBO();
            List<Aluno> lista = alunoBO.pesquisarTodos();

            alunos.setItems(FXCollections.observableArrayList(lista));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarAlerta(String mensagem){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(mensagem);
        alerta.setHeaderText(mensagem);
        alerta.showAndWait();
    }

}
