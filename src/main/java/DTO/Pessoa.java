package DTO;

public class Pessoa {

    private int id;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() < 3){
            throw new IllegalArgumentException("Nome deve ter no minimo 3 caracteres!");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento.length() < 10){
            throw new IllegalArgumentException("Data de nascimento inválida!");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getSobrenome() {

        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pessoa{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", sobrenome='").append(sobrenome).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", dataNascimento='").append(dataNascimento).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
