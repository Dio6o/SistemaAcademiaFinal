package controllers;

import java.io.IOException;
import java.nio.file.Paths;

import DTO.Aluno;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class GeradorQrCode {

    public boolean criarCodigoQR(Aluno aluno){
        try {
            String conteudo = aluno.getId()  + "," + aluno.getNome() + "," + aluno.getSobrenome();

            String endereco = "C:\\Users\\77777777777777777777\\IdeaProjects\\SistemaAcademiaFinal\\src\\main\\resources\\imgs\\codigo.png";

            BitMatrix codigo = new MultiFormatWriter().encode(conteudo, BarcodeFormat.QR_CODE, 500, 500);
            MatrixToImageWriter.writeToPath(codigo, "png", Paths.get(endereco));
            return true;
        } catch (WriterException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}