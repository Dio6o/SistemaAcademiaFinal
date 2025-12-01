package controllers;

import BO.AlunoBO;
import DTO.Aluno;
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

public class ControleExcluirAluno implements Initializable {

    @FXML
    private ComboBox<Aluno> alunos;

    @FXML
    private Button botaoExcluir;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarAlunos();
    }

    @FXML
    void excluir(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmação");
        alerta.setHeaderText("Tem certeza que deseja excluir esse aluno?, essa ação não pode ser desfeita.");
        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.get() == ButtonType.OK) {
            AlunoBO alunoBO = new AlunoBO();
            if (alunoBO.excluir(alunos.getValue())){
                mostrarAlerta("Aluno excluido com sucesso!");
            } else {
                mostrarAlerta("Erro ao excluir aluno!");
            }
        } else {
            alunos.setValue(null);
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

    public void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(mensagem);
        alerta.showAndWait();
        alunos.setValue(null);
    }

}
