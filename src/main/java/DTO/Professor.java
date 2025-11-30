package DTO;

public class Professor extends Pessoa {

    private String cref;

    public Professor() {}

    public Professor(String nome, String sobreNome, String cpf, String datNascimento, String cref) {
        setNome(nome);
        setSobrenome(sobreNome);
        setCpf(cpf);
        setDataNascimento(datNascimento);
        setCref(cref);
    }

    public Professor(int id, String nome, String sobreNome, String cpf, String datNascimento, String cref) {
        setId(id);
        setNome(nome);
        setSobrenome(sobreNome);
        setCpf(cpf);
        setDataNascimento(datNascimento);
        setCref(cref);
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
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
