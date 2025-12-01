package controllers;

import BO.AlunoBO;
import DTO.Aluno;
import com.github.sarxos.webcam.Webcam;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControleCatraca implements Initializable {

    @FXML
    private ImageView catraca;

    private Webcam webcam;
    private boolean running = true;
    private volatile boolean lendo = true;
    private String ultimoQR = "";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniciarWebcam();
    }

    public void iniciarWebcam() {
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam.open();

        Thread cameraThread = new Thread(() -> {

            while (running) {

                BufferedImage bufferedImage = webcam.getImage();

                if (bufferedImage != null) {

                    Image fxImage = SwingFXUtils.toFXImage(bufferedImage, null);

                    Platform.runLater(() -> catraca.setImage(fxImage));

                    lerQRCode(bufferedImage);
                }

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        cameraThread.setDaemon(true);
        cameraThread.start();
    }
    private void lerQRCode(BufferedImage imagem) {

        if (!lendo) return;

        try {
            LuminanceSource source = new BufferedImageLuminanceSource(imagem);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);

            Result resultado = new MultiFormatReader().decode(bitmap, hints);

            if (resultado != null) {

                String codigoQrAtual = resultado.getText();
                if (codigoQrAtual.equals(ultimoQR)) {
                    return;
                }

                ultimoQR = codigoQrAtual;
                lendo = false;

                String[] dadosQR = codigoQrAtual.split(",");
                int idAluno = Integer.parseInt(dadosQR[0]);

                AlunoBO alunoBO = new AlunoBO();
                Aluno aluno = alunoBO.procurarPorId(idAluno);
                System.out.println(aluno);
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    if (aluno != null && aluno.getStatus()) {
                        alert.setTitle("Acesso Liberado");
                        alert.setHeaderText("Bem-vindo, " + aluno.getNome());
                    } else {
                        alert.setTitle("Acesso Negado");
                        alert.setHeaderText("Aluno não autorizado");
                    }

                    alert.show();
                });

                new Thread(() -> {
                    try { Thread.sleep(2000); }
                    catch (InterruptedException ignored) {}
                    lendo = true;
                }).start();

            }

        } catch (NotFoundException e) {
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
