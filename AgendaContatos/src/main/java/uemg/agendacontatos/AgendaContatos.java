package uemg.agendacontatos;

import uemg.classes.Agenda;
import uemg.classes.Contato;
import uemg.classes.PessoaFisica;
import uemg.classes.PessoaJuridica;
import java.util.Scanner;
import java.io.IOException;

public class AgendaContatos {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        //Instanciando um obj de agenda:
        Agenda agenda = new Agenda();
        
        //Variáveis:
        String cpf, nome, endereco, email, dataNascimento, estadoCivil;
        String cnpj, inscricaoEstadual, razaoSocial;
        
        //Scanner para leitura de dados do teclado:
        Scanner scan = new Scanner(System.in);
        
        //Contador:
        int op;
        
        do {
            do {
                System.out.println("       Agenda telefônica       ");
                System.out.println();
                
                System.out.println("Escolha uma opção abaixo:");
                System.out.println("1. Adicionar contato PF");
                System.out.println("2. Adicionar contato PF");
                System.out.println("3. Remover contato");
                System.out.println("4. Pesquisar por nome");
                System.out.println("5. Pesquisar por CPF/CNPJ");
                System.out.println("6. Imprimir contatos");
                System.out.println("7. Sair");
                System.out.println();
                
                op = scan.nextInt();
                
                if (op < 1 || op > 7) {
                    System.out.println("Opção inválida, favor escolher outra.");
                } 
            } while (op < 1 || op > 7);
            
            if (op == 7)
            {
                System.out.println("Obrigado por utilizar nossa agenda!");
            } else {
            
                switch(op)
                {
                    case 1 -> {
                        System.out.println("Entre com os dados abaixo:");
                        
                        Scanner s = new Scanner(System.in);
                        
                        System.out.println("CPF: ");
                        cpf = s.nextLine();
                        
                        System.out.println("Nome:");
                        nome = s.nextLine();
                        
                        System.out.println("Endereço: ");
                        endereco = s.nextLine();
                        
                        System.out.println("E-mail: ");
                        email = s.nextLine();
                        
                        System.out.println("Data de nascimento: ");
                        dataNascimento = s.nextLine();
                        
                        System.out.println("Estado civil: ");
                        estadoCivil = s.nextLine();
                        
                        PessoaFisica pessoa = new PessoaFisica(cpf, nome, endereco, email, dataNascimento, estadoCivil);
                        agenda.adicionarContato(pessoa);
                    }
                    
                    case 2 -> {
                        Scanner s = new Scanner(System.in);
                        
                        System.out.println("Entre com os dados abaixo:");
                        
                        System.out.println("CNPJ: ");
                        cnpj = s.nextLine();
                        
                        System.out.println("Nome:");
                        nome = s.nextLine();
                        
                        System.out.println("Endereço: ");
                        endereco = s.nextLine();
                        
                        System.out.println("E-mail: ");
                        email = s.nextLine();
                        
                        System.out.println("Inscrição estadual: ");
                        inscricaoEstadual = s.nextLine();
                        
                        System.out.println("Razão social: ");
                        razaoSocial = s.nextLine();
                        
                        PessoaJuridica pessoa = new PessoaJuridica(cnpj, nome, endereco, email, inscricaoEstadual, razaoSocial);
                        agenda.adicionarContato(pessoa);
                    }
                    
                    case 3 -> {
                        Scanner s = new Scanner(System.in);
                        
                        System.out.println("Você deseja remover por nome (1) ou CPF/CNPJ (2)? ");
                        int decisao = s.nextInt();
                        
                        if (decisao == 1){
                            System.out.println("Digite o nome: ");
                            nome = s.nextLine();
                            
                            agenda.removerContatoPorNome(nome);
                            
                        } else if (decisao == 2) {
                        
                            System.out.println("Digite o CPF/CNPJ: ");
                            String auxCpfCnpj = s.nextLine();
                            
                            agenda.removerContatoPorCpfCnpj(auxCpfCnpj);
                        }
                    }
                    
                    case 4 -> {
                        Scanner s = new Scanner(System.in);
                        
                        System.out.println("Digite o nome: ");
                        nome = s.nextLine();
                        
                        Contato contato = agenda.pesquisarPorNome(nome);
                        if (contato != null) {
                            System.out.println("Contato encontrado: " + contato.getNome());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                    }
                    
                    case 5 -> {
                        
                        Scanner s = new Scanner(System.in);

                        System.out.println("Digite o CPF ou CNPJ: ");
                        cnpj = s.nextLine();
                        
                        Contato contato = agenda.pesquisarPorCpfCnpj(cnpj);
                        if (contato != null) {
                            System.out.println("Contato encontrado: " + contato.getNome());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                    }
                    
                    case 6 -> {
                        Scanner s = new Scanner(System.in);
                        
                        agenda.ordenarContatos();

                        System.out.println("           AGENDA           ");
                        agenda.visualizarContatos();
                        
                        System.out.println("Deseja realizar uma nova operação? S/N");
                        String opc = s.nextLine();
                        
                        if (opc == "S" || opc == "s")
                        {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } else if (opc == "N" || opc == "n")
                        {
                            op = 7;
                        }
                    }
                }
            }
            
        } while (op != 7);
    }
}