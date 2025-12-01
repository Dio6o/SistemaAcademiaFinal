
import DTO.Aluno;
import controllers.GeradorQrCode;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


import java.util.Properties;

public class EnviarEmail {

    public boolean enviarEmail(Aluno aluno, String email) {
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

                return true;

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } else {
            // setup alert box latter
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        EnviarEmail enviarEmail = new EnviarEmail();

        Aluno aluno = new Aluno( "Diogo", "Lohn");
        String email =  "lohn.diogo@gmail.com";

        if (enviarEmail.enviarEmail(aluno, email)){
            System.out.println("Email enviado com sucesso!");
        } else {
            System.out.println("erro ao enviar email!");
        }

    }
}
