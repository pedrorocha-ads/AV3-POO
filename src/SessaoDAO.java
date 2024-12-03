import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessaoDAO {
    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/sessoes.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void salvar(List<Sessao> sessoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Sessao sessao : sessoes) {
                writer.write(sessao.getIdSessao() + ";" +
                        DATE_FORMAT.format(sessao.getDataHoraSessao()) + ";" +
                        sessao.getFilme().getIdFilme() + ";" +
                        sessao.getSala().getIdSala() + ";" +
                        sessao.getFuncionario().getMatricula() + ";" +
                        sessao.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar Sessão: " + e.getMessage());
        }
    }
    public static List<Sessao> carregar() {
        List<Sessao> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                int idSessao = Integer.parseInt(split[0]);
                Date dataHoraSessao = DATE_FORMAT.parse(split[1]);
                Filme filme = FilmeDAO.consultar(Integer.parseInt(split[2]));
                Sala sala = SalaDAO.consultar(Integer.parseInt(split[3]));
                Funcionario funcionario = FuncionarioDAO.consultar(Integer.parseInt(split[4]));
                String status = split[5];

                Sessao sessao = new Sessao(idSessao, dataHoraSessao, filme, sala, funcionario, status);
                lista.add(sessao);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Erro ao carregar Sessão: " + e.getMessage());
        }
        return lista;
    }
    public static void cadastrar(Sessao sessao) {
        List<Sessao> sessoes = carregar();
        sessoes.add(sessao);
        salvar(sessoes);
    }
    public static boolean editar(int idSessao, Sessao sessaoAtualizada) {
        List<Sessao> sessoes = carregar();
        boolean atualizado = false;

        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getIdSessao() == idSessao) {
                sessoes.set(i, sessaoAtualizada);
                atualizado = true;
                break;
            }
        }
        if (atualizado) {
            salvar(sessoes);
        }
        return atualizado;
    }
    public static Sessao consultar(int idSessao) {
        List<Sessao> sessoes = carregar();
        for (Sessao sessao : sessoes) {
            if (sessao.getIdSessao() == idSessao) {
                return sessao;
            }
        }
        return null;
    }
    public static List<Sessao> listar() {
        return carregar();
    }
}