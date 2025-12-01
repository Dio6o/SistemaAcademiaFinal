package controllers;

import BO.ProfessorBO;
import DTO.Professor;
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

public class ControleExcluirProfessor implements Initializable {

    @FXML
    private ComboBox<Professor> professores;

    @FXML
    private Button botaoExcluir;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarProfessores();
    }

    public void carregarProfessores() {
        try {
            ProfessorBO professorBO = new ProfessorBO();
            List<Professor> lista = professorBO.pesquisarTodos();

            professores.setItems(FXCollections.observableArrayList(lista));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void excluir(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmação");
        alerta.setHeaderText("Tem certeza que deseja excluir esse professor?, essa ação não pode ser desfeita.");
        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.get() == ButtonType.OK) {
            ProfessorBO professorBO = new ProfessorBO();
            if (professorBO.excluir(professores.getValue())){
                mostrarAlerta("Professor excluido com sucesso!");
                professores.setValue(null);
            } else {
                mostrarAlerta("Erro ao excluir professor!");
            }
        } else {
            professores.setValue(null);
        }

    }

    public void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(mensagem);
        alerta.showAndWait();
        professores.setValue(null);
    }
}
