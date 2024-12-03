import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalaAssentoDAO {
    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/salaAssentos.txt";

    public static void salvar(List<SalaAssento> salaAssentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (SalaAssento salaAssento : salaAssentos) {
                writer.write(salaAssento.getIdSalaAssento() + ";" + salaAssento.getAssento().getIdAssento() + ";" + salaAssento.getSala().getIdSala());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar salaAssentos: " + e.getMessage());
        }
    }

    public static List<SalaAssento> carregar() {
        List<SalaAssento> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                Assento assento = AssentoDAO.consultar(Integer.parseInt(split[1]));
                Sala sala = SalaDAO.consultar(Integer.parseInt(split[2]));
                SalaAssento salaAssento = new SalaAssento(
                        Integer.parseInt(split[0]), // ID do SalaAssento
                        assento, // Assento
                        sala // Sala
                );
                lista.add(salaAssento);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar salaAssentos: " + e.getMessage());
        }
        return lista;
    }

    public static void cadastrar(SalaAssento salaAssento) {
        List<SalaAssento> salaAssentos = carregar();
        salaAssentos.add(salaAssento);
        salvar(salaAssentos);
    }

    public static boolean editar(int idSalaAssento, SalaAssento salaAssentoAtualizado) {
        List<SalaAssento> salaAssentos = carregar();
        boolean atualizado = false;

        for (int i = 0; i < salaAssentos.size(); i++) {
            if (salaAssentos.get(i).getIdSalaAssento() == idSalaAssento) {
                salaAssentos.set(i, salaAssentoAtualizado);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(salaAssentos);
        }
        return atualizado;
    }

    public static SalaAssento consultar(int idSalaAssento) {
        List<SalaAssento> salaAssentos = carregar();
        for (SalaAssento salaAssento : salaAssentos) {
            if (salaAssento.getIdSalaAssento() == idSalaAssento) {
                return salaAssento;
            }
        }
        return null;
    }

    public static List<SalaAssento> listar() {
        return carregar();
    }
}