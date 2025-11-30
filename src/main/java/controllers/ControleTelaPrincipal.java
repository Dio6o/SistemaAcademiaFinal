package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ControleTelaPrincipal{

    @FXML
    public void consultarAlunos(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaAlunosCadastrados.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Alunos cadastrados");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void consultarProfessores(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaProfessoresCadastrados.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Professores Cadastrados");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void treinosAluno(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaTreinosAluno.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Treinos Cadastrados");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}
