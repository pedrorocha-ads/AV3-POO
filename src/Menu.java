import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Funcionário");
            System.out.println("2. Filme");
            System.out.println("3. Ator");
            System.out.println("4. Sessão");
            System.out.println("5. Ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuFuncionario();
                    break;
                case 2:
                    menuFilme();
                    break;
                case 3:
                    menuAtor();
                    break;
                case 4:
                    menuSessao();
                    break;
                case 5:
                    menuIngresso();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void menuFuncionario() {
        int opcao;
        do {
            System.out.println("===== Menu Funcionário =====");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Editar Funcionário");
            System.out.println("3. Consultar Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("0. Voltar");
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
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void menuFilme() {
        int opcao;
        do {
            System.out.println("===== Menu Filme =====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Editar Filme");
            System.out.println("3. Consultar Filme");
            System.out.println("4. Listar Filmes");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    editarFilme();
                    break;
                case 3:
                    consultarFilme();
                    break;
                case 4:
                    listarFilmes();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void menuAtor() {
        int opcao;
        do {
            System.out.println("===== Menu Ator =====");
            System.out.println("1. Cadastrar Ator");
            System.out.println("2. Editar Ator");
            System.out.println("3. Consultar Ator");
            System.out.println("4. Listar Atores");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAtor();
                    break;
                case 2:
                    editarAtor();
                    break;
                case 3:
                    consultarAtor();
                    break;
                case 4:
                    listarAtores();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void menuSessao() {
        int opcao;
        do {
            System.out.println("===== Menu Sessão =====");
            System.out.println("1. Cadastrar Sessão");
            System.out.println("2. Editar Sessão");
            System.out.println("3. Consultar Sessão");
            System.out.println("4. Listar Sessões");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarSessao();
                    break;
                case 2:
                    editarSessao();
                    break;
                case 3:
                    consultarSessao();
                    break;
                case 4:
                    listarSessoes();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void menuIngresso() {
        int opcao;
        do {
            System.out.println("===== Menu Ingresso =====");
            System.out.println("1. Cadastrar Ingresso");
            System.out.println("2. Editar Ingresso");
            System.out.println("3. Consultar Ingresso");
            System.out.println("4. Listar Ingressos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarIngresso();
                    break;
                case 2:
                    editarIngresso();
                    break;
                case 3:
                    consultarIngresso();
                    break;
                case 4:
                    listarIngressos();
                    break;
                case 0:
                    System.out.println("Voltando...");
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
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
    private static void cadastrarFilme() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Classificação: ");
        int classificacao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();
        Filme filme = new Filme(0, titulo, classificacao, genero, status);
        FilmeDAO.cadastrar(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }
    private static void editarFilme() {
        System.out.print("Digite o ID do filme: ");
        int idFilme = scanner.nextInt();
        scanner.nextLine();
        Filme filme = FilmeDAO.consultar(idFilme);
        if (filme != null) {
            System.out.print("Novo Título (atual: " + filme.getTitulo() + "): ");
            String titulo = scanner.nextLine();
            System.out.print("Nova Classificação (atual: " + filme.getClassificacao() + "): ");
            int classificacao = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Novo Gênero (atual: " + filme.getGenero() + "): ");
            String genero = scanner.nextLine();
            System.out.print("Novo Status (atual: " + filme.getStatus() + "): ");
            String status = scanner.nextLine();
            Filme filmeAtualizado = new Filme(
                    filme.getIdFilme(),
                    titulo.isEmpty() ? filme.getTitulo() : titulo,
                    classificacao == 0 ? filme.getClassificacao() : classificacao,
                    genero.isEmpty() ? filme.getGenero() : genero,
                    status.isEmpty() ? filme.getStatus() : status
            );
            if (FilmeDAO.editar(filme.getIdFilme(), filmeAtualizado)) {
                System.out.println("Filme atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar filme.");
            }
        } else {
            System.out.println("Filme não encontrado.");
        }
    }
    private static void consultarFilme() {
        System.out.print("Digite o ID do filme: ");
        int idFilme = scanner.nextInt();
        scanner.nextLine();
        Filme filme = FilmeDAO.consultar(idFilme);
        if (filme != null) {
            System.out.println(filme);
        } else {
            System.out.println("Filme não encontrado.");
        }
    }
    private static void listarFilmes() {
        List<Filme> filmes = FilmeDAO.listar();
        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }
    private static void cadastrarAtor() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Ator ator = new Ator(nome, cpf, email);
        AtorDAO.cadastrar(ator);
        System.out.println("Ator cadastrado com sucesso!");
    }
    private static void editarAtor() {
        System.out.print("Digite o nome do ator: ");
        String nome = scanner.nextLine();
        Ator ator = AtorDAO.consultar(Integer.parseInt(nome));
        if (ator != null) {
            System.out.print("Novo Nome (atual: " + ator.getNome() + "): ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo CPF (atual: " + ator.getCpf() + "): ");
            String cpf = scanner.nextLine();
            System.out.print("Novo Email (atual: " + ator.getEmail() + "): ");
            String email = scanner.nextLine();
            Ator atorAtualizado = new Ator(
                    novoNome.isEmpty() ? ator.getNome() : novoNome,
                    cpf.isEmpty() ? ator.getCpf() : cpf,
                    email.isEmpty() ? ator.getEmail() : email
            );
            if (AtorDAO.editar(Integer.parseInt(nome), atorAtualizado)) {
                System.out.println("Ator atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar ator.");
            }
        } else {
            System.out.println("Ator não encontrado.");
        }
    }
    private static void consultarAtor() {
        System.out.print("Digite o nome do ator: ");
        String nome = scanner.nextLine();
        Ator ator = AtorDAO.consultar(Integer.parseInt(nome));
        if (ator != null) {
            System.out.println(ator);
        } else {
            System.out.println("Ator não encontrado.");
        }
    }
    private static void listarAtores() {
        List<Ator> atores = AtorDAO.listar();
        for (Ator ator : atores) {
            System.out.println(ator);
        }
    }
        private static void cadastrarSessao() {
        System.out.print("ID da Sessão: ");
        int idSessao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data e Hora da Sessão (yyyy-MM-dd HH:mm): ");
        String dataHora = scanner.nextLine();
        System.out.print("ID do Filme: ");
        int idFilme = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID da Sala: ");
        int idSala = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID do Funcionário: ");
        int idFuncionario = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();

        Filme filme = FilmeDAO.consultar(idFilme);
        Sala sala = SalaDAO.consultar(idSala);
        Funcionario funcionario = FuncionarioDAO.consultar(idFuncionario);
        Date dataHoraSessao = null;
        try {
            dataHoraSessao = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataHora);
        } catch (ParseException e) {
            System.err.println("Erro ao converter data e hora: " + e.getMessage());
            return;
        }

        Sessao sessao = new Sessao(idSessao, dataHoraSessao, filme, sala, funcionario, status);
        SessaoDAO.cadastrar(sessao);
        System.out.println("Sessão cadastrada com sucesso!");
    }
    private static void editarSessao() {
        System.out.print("Digite o ID da sessão: ");
        int idSessao = scanner.nextInt();
        scanner.nextLine();
        Sessao sessao = SessaoDAO.consultar(idSessao);
        if (sessao != null) {
            System.out.print("Nova Data e Hora da Sessão (atual: " + sessao.getDataHoraSessao() + "): ");
            String dataHora = scanner.nextLine();
            System.out.print("Novo ID do Filme (atual: " + sessao.getFilme().getId() + "): ");
            int idFilme = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Novo ID da Sala (atual: " + sessao.getSala().getIdSala() + "): ");
            int idSala = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Novo ID do Funcionário (atual: " + sessao.getFuncionario() + "): ");
            int idFuncionario = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Novo Status (atual: " + sessao.getStatus() + "): ");
            String status = scanner.nextLine();

            Filme filme = FilmeDAO.consultar(idFilme);
            Sala sala = SalaDAO.consultar(idSala);
            Funcionario funcionario = FuncionarioDAO.consultar(idFuncionario);
            Date dataHoraSessao = null;
            try {
                dataHoraSessao = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataHora);
            } catch (ParseException e) {
                System.err.println("Erro ao converter data e hora: " + e.getMessage());
                return;
            }
            Sessao sessaoAtualizada = new Sessao(
                    sessao.getIdSessao(),
                    dataHora.isEmpty() ? sessao.getDataHoraSessao() : dataHoraSessao,
                    filme == null ? sessao.getFilme() : filme,
                    sala == null ? sessao.getSala() : sala,
                    funcionario == null ? sessao.getFuncionario() : funcionario,
                    status.isEmpty() ? sessao.getStatus() : status
            );
            if (SessaoDAO.editar(idSessao, sessaoAtualizada)) {
                System.out.println("Sessão atualizada com sucesso!");
            } else {
                System.out.println("Erro ao atualizar sessão.");
            }
        } else {
            System.out.println("Sessão não encontrada.");
        }
    }
    private static void consultarSessao() {
        System.out.print("Digite o ID da sessão: ");
        int idSessao = scanner.nextInt();
        Sessao sessao = SessaoDAO.consultar(idSessao);
        if (sessao != null) {
            System.out.println(sessao);
        } else {
            System.out.println("Sessão não encontrada.");
        }
    }
    private static void listarSessoes() {
        List<Sessao> sessoes = SessaoDAO.listar();
        for (Sessao sessao : sessoes) {
            System.out.println(sessao);
        }
    }
private static void cadastrarIngresso() {
    System.out.print("ID do Ingresso: ");
    int idIngresso = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Valor Pago: ");
    double valorPago = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("ID da Sessão: ");
    int idSessao = scanner.nextInt();
    scanner.nextLine();
    System.out.print("ID do Assento: ");
    int idAssento = scanner.nextInt();
    scanner.nextLine();

    Sessao sessao = SessaoDAO.consultar(idSessao);
    SalaAssento salaAssento = SalaAssentoDAO.consultar(idAssento);

    Ingresso ingresso = new Ingresso(idIngresso, valorPago, sessao, salaAssento);
    IngressoDAO.cadastrar(ingresso);
    System.out.println("Ingresso cadastrado com sucesso!");
}
private static void editarIngresso() {
    System.out.print("Digite o ID do ingresso: ");
    int idIngresso = scanner.nextInt();
    scanner.nextLine();
    Ingresso ingresso = IngressoDAO.consultar(idIngresso);
    if (ingresso != null) {
        System.out.print("Novo Valor Pago (atual: " + ingresso.getValorPago() + "): ");
        double valorPago = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Novo ID da Sessão (atual: " + ingresso.getSessao().getIdSessao() + "): ");
        int idSessao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo ID do Assento (atual: " + ingresso.getSalaAssento().getIdAssento() + "): ");
        int idAssento = scanner.nextInt();
        scanner.nextLine();

        Sessao sessao = SessaoDAO.consultar(idSessao);
        SalaAssento salaAssento = SalaAssentoDAO.consultar(idAssento);

        Ingresso ingressoAtualizado = new Ingresso(
                ingresso.getIdIngresso(),
                valorPago == 0 ? ingresso.getValorPago() : valorPago,
                sessao == null ? ingresso.getSessao() : sessao,
                salaAssento == null ? ingresso.getSalaAssento() : salaAssento
        );
        if (IngressoDAO.editar(idIngresso, ingressoAtualizado)) {
            System.out.println("Ingresso atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar ingresso.");
        }
    } else {
        System.out.println("Ingresso não encontrado.");
    }
}
private static void consultarIngresso() {
    System.out.print("Digite o ID do ingresso: ");
    int idIngresso = scanner.nextInt();
    Ingresso ingresso = IngressoDAO.consultar(idIngresso);
    if (ingresso != null) {
        System.out.println(ingresso);
    } else {
        System.out.println("Ingresso não encontrado.");
    }
}
private static void listarIngressos() {
    List<Ingresso> ingressos = IngressoDAO.listar();
    for (Ingresso ingresso : ingressos) {
        System.out.println(ingresso);
    }
}
}