package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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


    public void janelaConsultaAlunos(Stage stage){
        try {
            System.out.println("Alunos cadastrados");

            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaAlunosCadastrados.fxml"));
            Scene scene = new Scene(root);
            Popup popup = new Popup();
            stage.setScene(scene);
            stage.setTitle("Alunos cadastrados");
            stage.setResizable(false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void abrirJanela(String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Alunos cadastrados");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }






}
