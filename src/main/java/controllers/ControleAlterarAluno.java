package controllers;

import BO.AlunoBO;
import DTO.Aluno;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControleAlterarAluno implements Initializable {


    @FXML
    private ComboBox<Aluno> alunos;

    @FXML
    private Button botaoPesquisar;

    @FXML
    private Button botaoSalvar;

    @FXML
    private TextField cpf;

    @FXML
    private TextField dataNascimento;

    @FXML
    private TextField nome;

    @FXML
    private TextField sobrenome;

    @FXML
    private CheckBox status;

    @FXML
    private ComboBox<String> plano;

    private int idAluno;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarAlunos();
        plano.getItems().addAll(
                "1- Mensal",
                "2- Trimestral",
                "3- Semestral",
                "4- Anual"
        );
    }


    @FXML
    public void pesquisarAluno(ActionEvent event) {
        Aluno aluno = alunos.getValue();
        if (aluno != null) {
            AlunoBO alunoBO = new AlunoBO();
            aluno = alunoBO.procurarPorId(aluno.getId());
            nome.setText(aluno.getNome());
            sobrenome.setText(aluno.getSobrenome());
            cpf.setText(aluno.getCpf());
            dataNascimento.setText(aluno.getDataNascimento());
            status.setSelected(aluno.getStatus());
            idAluno = aluno.getId();
        } else {
            mostrarAlerta("Aluno não selecionado!");
        }
    }

    @FXML
    public void salvar(ActionEvent event) {
        int planoEscolhido = 0;
        if (nome.getText() != null && sobrenome.getText() != null) {
            if (plano.getValue() != null) {
                planoEscolhido = switch (plano.getValue()) {
                    case "1- Mensal" -> 30;
                    case "2- Trimestral" -> 90;
                    case "3- Semestral" -> 180;
                    case "4- Anual" -> 365;
                    default -> planoEscolhido;
                };
            } else {
                mostrarAlerta("Selecione um plano!");
            }
            Aluno aluno = new Aluno(idAluno, nome.getText(), sobrenome.getText(), cpf.getText(),
                    dataNascimento.getText(), status.isSelected(), planoEscolhido);

            AlunoBO alunoBO = new AlunoBO();
            if (alunoBO.alterar(aluno)){
                mostrarAlerta("Edição feita com sucesso!");
                nome.clear();
                sobrenome.clear();
                cpf.clear();
                dataNascimento.clear();
                status.setSelected(false);
                alunos.setValue(null);
            }
        } else{
            mostrarAlerta("Campos nececessários não preenchidos!");
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

    public void mostrarAlerta(String conteudo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(conteudo);
        alert.setHeaderText(conteudo);
        alert.showAndWait();
    }

}
