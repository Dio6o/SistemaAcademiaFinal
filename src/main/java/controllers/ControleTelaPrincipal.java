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

    public void consultarExercicios(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaExerciciosCadastrados.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Exercícios Cadastrados");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarAluno(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaCadastroAluno.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Cadastro De Novo Aluno");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarProfessor(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaCadastroProfessor.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Cadastro De Novo Professor");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarTreino(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaCadastroTreino.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Cadastro De Novo Treino");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void iniciarCatraca(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaCatraca.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Catraca");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void enviarCodigo(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaEnviarCodigo.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Enviar código de Acesso");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarAluno(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaAlterarAluno.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Atualizar cadastro do aluno");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirAluno(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaExcluirAluno.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Excluir Aluno");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirProfessor(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaExcluirProfessores.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Excluir Professor");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirTreino(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/JanelaExcluirTreino.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Excluir Treino");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
