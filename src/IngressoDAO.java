import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngressoDAO {
    private static final String FILE_NAME = "Ingresso.txt";


    public static void salvar(List<Ingresso> ingressos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Ingresso ingresso : ingressos) {
                writer.write(ingresso.getIdIngresso() + ";" +
                        ingresso.getValorPago() + ";" +
                        ingresso.getSessao().getIdSessao() + ";" +  // Supondo que Sessao tenha o método getIdSessao
                        ingresso.getSalaAssento().getIdSalaAssento()); // Supondo que SalaAssento tenha o método getIdSalaAssento
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
                int idIngresso = Integer.parseInt(split[0]);
                double valorPago = Double.parseDouble(split[1]);
                int idSessao = Integer.parseInt(split[2]);  // ID da Sessão
                int idSalaAssento = Integer.parseInt(split[3]); // ID do SalaAssento

                // Reconstituir objetos relacionados (Sessao e SalaAssento)
                Sessao sessao = SessaoDAO.consultar(idSessao); // Supondo SessaoDAO implementado
                SalaAssento salaAssento = SalaAssentoDAO.consultar(idSalaAssento); // Supondo SalaAssentoDAO implementado

                Ingresso ingresso = new Ingresso(idIngresso, valorPago, sessao, salaAssento);
                lista.add(ingresso);
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