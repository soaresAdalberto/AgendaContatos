package uemg.classes;

import uemg.classes.Contato;

public class PessoaJuridica extends Contato {
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;

    // Construtor
    public PessoaJuridica(String cnpj, String nome, String endereco, String email, String inscricaoEstadual, String razaoSocial) {
        super(nome, endereco, email);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
