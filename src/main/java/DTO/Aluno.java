package DTO;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.sql.Date;

public class Aluno extends Pessoa {

    private int plano;
    private boolean status;
    private Date ultimoPagamento;

    public Aluno(){}

    public Aluno(int id){
        setId(id);
    }

    public Aluno(String nome){
        setNome(nome);
    }

    public Aluno(int id, String nome){
        setId(id);
        setNome(nome);
    }

    public Aluno(String nome, String sobrenome){
        setNome(nome);
        setSobrenome(sobrenome);
    }

    public Aluno(String nome, String sobreNome, String cpf, String dataNascimento){
        setNome(nome);
        setSobrenome(sobreNome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
    }

    public Aluno(int id, String nome, String sobreNome, String cpf, String dataNascimento){
        setId(id);
        setNome(nome);
        setSobrenome(sobreNome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
    }

    public Aluno(int id, String nome, String sobreNome, String cpf, String dataNascimento, boolean status, int plano){
        setId(id);
        setNome(nome);
        setSobrenome(sobreNome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        setStatus(status);
        setPlano(plano);
    }

    public int getPlano() {
        return plano;
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getUltimoPagamento() {
        return ultimoPagamento;
    }

    public void setUltimoPagamento(Date ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aluno{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

}
