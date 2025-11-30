package controllers;

import DTO.Aluno;
import BO.AlunoBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleAlunosCadastrados implements Initializable {

    @FXML private TableView<Aluno> alunos;
    @FXML private TableColumn<Aluno, Integer> idAluno;
    @FXML private TableColumn<Aluno, String> nomeAluno;
    @FXML private TableColumn<Aluno, String> sobrenomeAluno;
    @FXML private TableColumn<Aluno, String> dataNascimentoAluno;
    @FXML private TableColumn<Aluno, String> statusAluno;

    ObservableList<Aluno> lista = FXCollections.observableArrayList(listaAlunos());

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idAluno.setCellValueFactory(new PropertyValueFactory<Aluno, Integer>("id"));
        nomeAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
        sobrenomeAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("sobrenome"));
        dataNascimentoAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("dataNascimento"));
        //statusAluno.setCellValueFactory(new PropertyValueFactory<Aluno, Boolean>("status"));
        statusAluno.setCellValueFactory(cellData -> {
            boolean status = cellData.getValue().getStatus();
            return new javafx.beans.property.SimpleStringProperty(status ? "Ativo" : "Vencido");
        });

        alunos.setItems(FXCollections.observableArrayList(lista));
    }



    private List<Aluno> listaAlunos(){
        AlunoBO alunoBO = new AlunoBO();
        return alunoBO.pesquisarTodos();
    }

}
