package controllers;

import DTO.Exercicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import BO.ExercicioBO;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleExerciciosCadastrados  implements Initializable {

    @FXML private TableView<Exercicio> tabelaExercicios;
    @FXML private TableColumn<Exercicio, Integer> idExercicio;
    @FXML private TableColumn<Exercicio, String> nomeExercicio;

    ObservableList<Exercicio> lista = FXCollections.observableArrayList(listaExercicios());

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idExercicio.setCellValueFactory(new PropertyValueFactory<Exercicio, Integer>("exercicioId"));
        nomeExercicio.setCellValueFactory(new PropertyValueFactory<Exercicio, String>("nome"));

        tabelaExercicios.setItems(FXCollections.observableArrayList(lista));

    }


    public List<Exercicio> listaExercicios() {
        ExercicioBO bo = new ExercicioBO();
        return bo.pesquisarTodos();
    }


}
