package uemg.classes;

import uemg.classes.Contato;

public class PessoaFisica extends Contato{
    private String cpf;
    private String dataNascimento;
    private String estadoCivil;

    // Construtor
    public PessoaFisica(String cpf, String nome, String endereco, String email, String dataNascimento, String estadoCivil) {
        super(nome, endereco, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
    }

    // Getters e Setters
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
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
