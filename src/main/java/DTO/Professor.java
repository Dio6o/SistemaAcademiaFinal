package DTO;

public class Professor extends Pessoa {

    private String cref;
    private int senha;

    public Professor() {}

    public Professor(int id){
        setId(id);
    }

    public Professor(String nome, String sobreNome, String cpf, String datNascimento, String cref) {
        setNome(nome);
        setSobrenome(sobreNome);
        setCpf(cpf);
        setDataNascimento(datNascimento);
        setCref(cref);
    }

    public Professor(int id, String nome, String sobreNome, String cpf, String datNascimento,int senha, String cref) {
        setId(id);
        setNome(nome);
        setSobrenome(sobreNome);
        setCpf(cpf);
        setDataNascimento(datNascimento);
        setSenha(senha);
        setCref(cref);
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Professor{");
        sb.append(super.toString());
        sb.append("cref='").append(cref).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
