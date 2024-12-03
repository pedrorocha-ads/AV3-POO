import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngressoDAO {
    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/ingressos.txt";

    static {
        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void salvar(List<Ingresso> ingressos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Ingresso ingresso : ingressos) {
                writer.write(ingresso.getIdIngresso() + ";" +
                        ingresso.getValorPago() + ";" +
                        ingresso.getSessao().getIdSessao() + ";" +
                        ingresso.getSalaAssento().getIdSalaAssento());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar Ingresso: " + e.getMessage());
        }
    }

    public static List<Ingresso> carregar() {
        List<Ingresso> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                if (split.length == 4) {
                    int idIngresso = Integer.parseInt(split[0]);
                    double valorPago = Double.parseDouble(split[1]);
                    Sessao sessao = SessaoDAO.consultar(Integer.parseInt(split[2]));  // ID da Sessão
                    SalaAssento salaAssento = SalaAssentoDAO.consultar(Integer.parseInt(split[3])); // ID do SalaAssento

                    if (sessao != null && salaAssento != null) {
                        Ingresso ingresso = new Ingresso(idIngresso, valorPago, sessao, salaAssento);
                        lista.add(ingresso);
                    } else {
                        System.out.println("Sessão ou SalaAssento inválido no arquivo: " + linha);
                    }
                } else {
                    System.out.println("Linha inválida no arquivo: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar Ingresso: " + e.getMessage());
        }
        return lista;
    }

    public static void cadastrar(Ingresso ingresso) {
        List<Ingresso> ingressos = carregar();
        ingressos.add(ingresso);
        salvar(ingressos);
    }

    public static boolean editar(int idIngresso, Ingresso ingressoAtualizado) {
        List<Ingresso> ingressos = carregar();
        boolean atualizado = false;

        for (int i = 0; i < ingressos.size(); i++) {
            if (ingressos.get(i).getIdIngresso() == idIngresso) {
                ingressos.set(i, ingressoAtualizado);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(ingressos);
        }
        return atualizado;
    }

    public static Ingresso consultar(int idIngresso) {
        List<Ingresso> ingressos = carregar();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getIdIngresso() == idIngresso) {
                return ingresso;
            }
        }
        return null;
    }

    public static List<Ingresso> listar() {
        return carregar();
    }
}