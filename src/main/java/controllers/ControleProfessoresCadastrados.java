package controllers;

import BO.ProfessorBO;
import DTO.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleProfessoresCadastrados implements Initializable {

    @FXML private TableView<Professor> professores;
    @FXML private TableColumn<Professor, Integer> idProfessor;
    @FXML private TableColumn<Professor, String> nomeProfessor;
    @FXML private TableColumn<Professor, String> sobrenomeProfessor;
    @FXML private TableColumn<Professor, String> dataNascimentoProfessor;
    @FXML private TableColumn<Professor, String> cref;

    ObservableList<Professor> lista = FXCollections.observableArrayList(listaProfessors());

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idProfessor.setCellValueFactory(new PropertyValueFactory<Professor, Integer>("id"));
        nomeProfessor.setCellValueFactory(new PropertyValueFactory<Professor, String>("nome"));
        sobrenomeProfessor.setCellValueFactory(new PropertyValueFactory<Professor, String>("sobrenome"));
        dataNascimentoProfessor.setCellValueFactory(new PropertyValueFactory<Professor, String>("dataNascimento"));
        cref.setCellValueFactory(new PropertyValueFactory<Professor, String>("cref"));
        professores.setItems(FXCollections.observableArrayList(lista));
    }



    private List<Professor> listaProfessors(){
        ProfessorBO professorBO = new ProfessorBO();
        return professorBO.pesquisarTodos();
    }

}
