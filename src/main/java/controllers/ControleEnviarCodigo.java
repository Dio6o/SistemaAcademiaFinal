package controllers;

import BO.AlunoBO;
import DTO.Aluno;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class ControleEnviarCodigo implements Initializable {

    @FXML private ComboBox<Aluno> alunos;
    @FXML private TextField emailAluno;
    @FXML private Button botaoEnviar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarAlunos();

    }

    public void enviarEmail(ActionEvent actionEvent) {
        Aluno aluno = alunos.getValue();
        String email = emailAluno.getText();

        String de = "lohn.diogo@gmail.com";
        String senha = "pmoq lkow wzbi edeb";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        GeradorQrCode geradorQrCode = new GeradorQrCode();
        geradorQrCode.criarCodigoQR(aluno);
        if (geradorQrCode.criarCodigoQR(aluno)) {


            Session session = Session.getInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(de, senha);
                        }
                    });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(de));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email, false));



                MimeBodyPart imagemCodigo = new MimeBodyPart();
                String endereco = "C:\\Users\\77777777777777777777\\IdeaProjects\\SistemaAcademiaFinal\\src\\main\\resources\\imgs\\codigo.png";
                DataSource source = new FileDataSource(endereco);

                message.setSubject("Código para entrada na academia.");

                MimeBodyPart corpo = new MimeBodyPart();
                corpo.setText("Este é o seu código para entrar na academia!");

                imagemCodigo.setDataHandler(new DataHandler(source));
                imagemCodigo.setFileName("codigoQR.png");

                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(imagemCodigo);
                multipart.addBodyPart(corpo);

                message.setContent(multipart);

                Transport.send(message);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Email enviado");
                alert.setHeaderText("Email enviado com sucesso!");
                alert.showAndWait();
                alunos.setValue(null);
                emailAluno.clear();

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    private void carregarAlunos() {
        try {
            AlunoBO alunoBO = new AlunoBO();
            List<Aluno> lista = alunoBO.pesquisarTodos();

            alunos.setItems(FXCollections.observableArrayList(lista));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
