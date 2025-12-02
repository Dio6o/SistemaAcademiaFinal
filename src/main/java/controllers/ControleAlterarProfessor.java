package controllers;

import BO.AlunoBO;
import BO.ProfessorBO;
import DTO.Aluno;
import DTO.Professor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleAlterarProfessor implements Initializable {
    @FXML
    private Button botaoPesquisar;

    @FXML
    private Button botaoSalvar;

    @FXML
    private TextField cpf;

    @FXML
    private TextField cref;

    @FXML
    private TextField dataNascimento;

    @FXML
    private TextField nome;

    @FXML
    private ComboBox<Professor> professores;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField sobrenome;

    private int idProfessor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarProfessores();
    }

    public void salvar(){
        if (nome.getText() != null && sobrenome.getText() != null && senha.getText() != null && cref.getText() != null){
            Professor professor = new Professor(idProfessor,nome.getText(), sobrenome.getText(), cpf.getText(),
                    dataNascimento.getText(), Integer.parseInt(senha.getText()) ,cref.getText());
            ProfessorBO professorBO = new ProfessorBO();
            if (professorBO.alterar(professor)){
                mostrarAlerta("Professor cadastrado com sucesso!");
                professores.setValue(null);
                nome.clear();
                sobrenome.clear();
                cpf.clear();
                dataNascimento.clear();
                cref.clear();
                senha.clear();

            } else {
                mostrarAlerta("Erro ao cadastrar professor!");
            }
        } else {
            mostrarAlerta("Preencha todos os campos!");
        }
    }

    public void pesquisarProfessor(){
        Professor professor = professores.getValue();
        if(professor != null){
            nome.setText(professor.getNome());
            sobrenome.setText(professor.getSobrenome());
            cpf.setText(professor.getCpf());
            dataNascimento.setText(professor.getDataNascimento());
            cref.setText(professor.getCref());
            senha.setText(String.valueOf(professor.getSenha()));
            idProfessor = professor.getId();
        } else {
            mostrarAlerta("Professor não selecionado!");
        }
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

    public void mostrarAlerta(String conteudo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(conteudo);
        alert.setHeaderText(conteudo);
        alert.showAndWait();
    }
}
