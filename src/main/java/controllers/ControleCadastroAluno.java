package controllers;

import BO.AlunoBO;
import DTO.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleCadastroAluno implements Initializable {

    @FXML private TextField nome;
    @FXML private TextField sobrenome;
    @FXML private TextField dataNascimento;
    @FXML private TextField cpf;
    @FXML private ComboBox<String> planos;
    @FXML private CheckBox pagamento;
    @FXML private Button botaoCadastro;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        planos.getItems().addAll(
                "1 - Mensal",
                "2 - Trimestral",
                "3 - Semestral",
                "4 - Anual"
        );
    }

    @FXML
    public void cadastrar(ActionEvent event) {

        try {
            if (nome.getText().isEmpty()) {
                mostrarErro();
            }

            String nomeA = nome.getText();
            String sobrenomeA = sobrenome.getText();
            String cpfA = cpf.getText();
            String dataNascimentoA = dataNascimento.getText();

            int planoA = 0;

            if (planos.getSelectionModel().getSelectedIndex() == -1) {
                mostrarErro();
            } else if (planos.getSelectionModel().getSelectedIndex() == 0) {
                planoA = 30;
            }else if (planos.getSelectionModel().getSelectedIndex() == 1) {
                planoA = 90;
            }else if (planos.getSelectionModel().getSelectedIndex() == 2) {
                planoA = 120;
            }else if (planos.getSelectionModel().getSelectedIndex() == 3) {
                planoA = 365;
            }


            Aluno aluno = new Aluno();
            aluno.setNome(nomeA);
            aluno.setSobrenome(sobrenomeA);
            aluno.setCpf(cpfA);
            aluno.setDataNascimento(dataNascimentoA);
            aluno.setPlano(planoA);
            if (pagamento.isSelected()) {
                aluno.setStatus(true);
            }

            AlunoBO alunoBO = new AlunoBO();
            boolean sucesso = alunoBO.inserir(aluno);

            if(sucesso){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Aluno cadastrado com sucesso!");
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
        alert.setHeaderText("Erro ao cadastrar aluno.");
        alert.showAndWait();
    }

    private void limparCampos(){
        nome.clear();
        sobrenome.clear();
        cpf.clear();
        dataNascimento.clear();
        planos.setValue(null);
        pagamento.setSelected(false);
    }
}
