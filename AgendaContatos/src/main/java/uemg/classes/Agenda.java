package uemg.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import uemg.classes.Contato;

public class Agenda {
    private List<Contato> contatos;

    // Construtor
    public Agenda() {
        contatos = new ArrayList<>();
    }

    // Adicionar um contato
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    // Remover um contato
    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }
    
    // Remover um contato por nome
    public void removerContatoPorNome(String nome) {
        Contato contato = pesquisarPorNome(nome);
        if (contato != null) {
            contatos.remove(contato);
            System.out.println("Contato removido: " + contato.getNome());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    // Remover um contato por CPF/CNPJ
    public void removerContatoPorCpfCnpj(String cpfCnpj) {
        Contato contato = pesquisarPorCpfCnpj(cpfCnpj);
        if (contato != null) {
            contatos.remove(contato);
            System.out.println("Contato removido: " + contato.getNome());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    // Pesquisar contato por nome
    public Contato pesquisarPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null; // Contato não encontrado
    }

    // Pesquisar contato por CPF/CNPJ
    public Contato pesquisarPorCpfCnpj(String cpfCnpj) {
        for (Contato contato : contatos) {
            if (contato instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) contato;
                if (pessoaFisica.getCpf().equals(cpfCnpj)) {
                    return pessoaFisica;
                }
            } else if (contato instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) contato;
                if (pessoaJuridica.getCnpj().equals(cpfCnpj)) {
                    return pessoaJuridica;
                }
            }
        }
        return null; // Contato não encontrado
    }

    // Ordenar contatos por CPF/CNPJ e tipo de contato
    public void ordenarContatos() {
        Collections.sort(contatos, new Comparator<Contato>() {
            @Override
            public int compare(Contato contato1, Contato contato2) {
                // Ordena por CPF/CNPJ
                if (contato1 instanceof PessoaFisica && contato2 instanceof PessoaJuridica) {
                    return -1; // Pessoa física antes de pessoa jurídica
                } else if (contato1 instanceof PessoaJuridica && contato2 instanceof PessoaFisica) {
                    return 1; // Pessoa jurídica depois de pessoa física
                } else {
                    // Mesmo tipo de contato, ordena por CPF/CNPJ
                    String cpfCnpj1 = "";
                    String cpfCnpj2 = "";

                    if (contato1 instanceof PessoaFisica) {
                        PessoaFisica pessoaFisica = (PessoaFisica) contato1;
                        cpfCnpj1 = pessoaFisica.getCpf();
                    } else if (contato1 instanceof PessoaJuridica) {
                        PessoaJuridica pessoaJuridica = (PessoaJuridica) contato1;
                        cpfCnpj1 = pessoaJuridica.getCnpj();
                    }

                    if (contato2 instanceof PessoaFisica) {
                        PessoaFisica pessoaFisica = (PessoaFisica) contato2;
                        cpfCnpj2 = pessoaFisica.getCpf();
                    } else if (contato2 instanceof PessoaJuridica) {
                        PessoaJuridica pessoaJuridica = (PessoaJuridica) contato2;
                        cpfCnpj2 = pessoaJuridica.getCnpj();
                    }

                    return cpfCnpj1.compareTo(cpfCnpj2);
                }
            }
        });
    }

    // Visualizar todos os contatos
    public void visualizarContatos() {
        for (Contato contato : contatos) {
            if (contato instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) contato;
                System.out.println("CPF: " + pessoaFisica.getCpf());
                System.out.println("Nome: " + pessoaFisica.getNome());
                System.out.println("Endereço: " + pessoaFisica.getEndereco());
                System.out.println("Email: " + pessoaFisica.getEmail());
                System.out.println("Data de Nascimento: " + pessoaFisica.getDataNascimento());
                System.out.println("Estado Civil: " + pessoaFisica.getEstadoCivil());
                System.out.println("-------------------------");
            } else if (contato instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) contato;
                System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
                System.out.println("Nome: " + pessoaJuridica.getNome());
                System.out.println("Endereço: " + pessoaJuridica.getEndereco());
                System.out.println("Email: " + pessoaJuridica.getEmail());
                System.out.println("Inscrição Estadual: " + pessoaJuridica.getInscricaoEstadual());
                System.out.println("Razão Social: " + pessoaJuridica.getRazaoSocial());
                System.out.println("-------------------------");
            }
        }
    }
}
