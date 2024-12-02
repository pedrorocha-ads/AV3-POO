import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Editar Funcionário");
            System.out.println("3. Consultar Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    editarFuncionario();
                    break;
                case 3:
                    consultarFuncionario();
                    break;
                case 4:
                    listarFuncionarios();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarFuncionario() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Horário de Trabalho: ");
        String horario = scanner.nextLine();

        Funcionario funcionario = new Funcionario(cpf, nome, email, matricula, horario);
        FuncionarioDAO.cadastrar(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void editarFuncionario() {
        System.out.print("Digite a matrícula do funcionário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = FuncionarioDAO.consultar(matricula);
        if (funcionario != null) {
            System.out.print("Novo Nome (atual: " + funcionario.getNome() + "): ");
            String nome = scanner.nextLine();
            System.out.print("Novo Email (atual: " + funcionario.getEmail() + "): ");
            String email = scanner.nextLine();
            System.out.print("Novo Horário de Trabalho (atual: " + funcionario.getHorarioTrabalho() + "): ");
            String horario = scanner.nextLine();

            Funcionario funcionarioAtualizado = new Funcionario(
                    funcionario.getCpf(),
                    nome.isEmpty() ? funcionario.getNome() : nome,
                    email.isEmpty() ? funcionario.getEmail() : email,
                    funcionario.getMatricula(),
                    horario.isEmpty() ? funcionario.getHorarioTrabalho() : horario
            );

            if (FuncionarioDAO.editar(matricula, funcionarioAtualizado)) {
                System.out.println("Funcionário atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar funcionário.");
            }
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void consultarFuncionario() {
        System.out.print("Digite a matrícula do funcionário: ");
        int matricula = scanner.nextInt();

        Funcionario funcionario = FuncionarioDAO.consultar(matricula);
        if (funcionario != null) {
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void listarFuncionarios() {
        List<Funcionario> funcionarios = FuncionarioDAO.listar();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            funcionarios.forEach(System.out::println);
        }
    }
}
