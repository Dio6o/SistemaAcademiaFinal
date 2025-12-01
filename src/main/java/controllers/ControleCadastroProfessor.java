package controllers;

import BO.ProfessorBO;
import DTO.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleCadastroProfessor implements Initializable {

    @FXML private TextField nome;
    @FXML private TextField sobrenome;
    @FXML private TextField dataNascimento;
    @FXML private TextField cpf;
    @FXML private TextField cref;
    @FXML private TextField senha;
    @FXML private Button botaoCadastro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    public void cadastrar(ActionEvent event) {
        try {
            if (nome.getText().isEmpty() || senha.getText().isEmpty()) {
                mostrarErro();
            }

            String nomeP = nome.getText();
            String sobrenomeP = sobrenome.getText();
            String cpfP = cpf.getText();
            String dataNascimentoP = dataNascimento.getText();
            String crefP = cref.getText();
            int senhaP = Integer.parseInt(senha.getText());

            Professor professor = new Professor();
            professor.setNome(nomeP);
            professor.setSobrenome(sobrenomeP);
            professor.setCpf(cpfP);
            professor.setDataNascimento(dataNascimentoP);
            professor.setCref(crefP);
            professor.setSenha(senhaP);


            ProfessorBO professorBO = new ProfessorBO();
            boolean sucesso = professorBO.inserir(professor);

            if(sucesso){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Professor cadastrado com sucesso!");
                alert.showAndWait();

                limparCampos();

            } else {
                mostrarErro();
            }

        } catch (Exception e){
            e.printStackTrace();
            mostrarErro();
        }
    }

    private void mostrarErro(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Erro ao cadastrar professor.");
        alert.showAndWait();
    }

    private void limparCampos(){
        nome.clear();
        sobrenome.clear();
        cpf.clear();
        dataNascimento.clear();
        cref.clear();
        senha.clear();
    }

}
