package controllers;

import DTO.Professor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import BO.ProfessorBO;
import javafx.stage.Stage;


public class ControleTelaLogin {

    @FXML
    private TextField caixaUsuario;
    @FXML
    private PasswordField caixaSenha;
    @FXML
    private Button loginBotao;



    @FXML
    private void login(ActionEvent event) {
        try {
            String cpf = caixaUsuario.getText();
            int senha = Integer.parseInt(caixaSenha.getText());

            ProfessorBO professorBO = new ProfessorBO();
            Professor professor = professorBO.procurarPorCpf(cpf);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Login ou Senha incorreto");

            if (professor == null) {
                alert.showAndWait();
            } else {
                if (senha == professor.getSenha()) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaPrincipal.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    stage.setScene(new Scene(root));
                    stage.setTitle("Sistema Academia");
                    stage.show();

                } else {
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }


}
