package uemg.classes;

public class Contato {
    private String nome;
    private String endereco;
    private String email;

    // Construtor
    public Contato(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
