import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    private static final String FILE_NAME = "Sala.txt";


    public static void salvar(List<Sala> salas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Sala sala : salas) {
                writer.write(sala.getIdSala() + ";" +
                        sala.getCapacidadeSala() + ";" +
                        sala.getStatus() + ";" +
                        sala.getDescricao());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar Sala: " + e.getMessage());
        }
    }
    public static List<Sala> carregar() {
        List<Sala> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                int idSala = Integer.parseInt(split[0]);
                int capacidadeSala = Integer.parseInt(split[1]);
                String status = split[2];
                String descricao = split[3];

                Sala sala = new Sala(idSala, capacidadeSala, status, descricao);
                lista.add(sala);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar Sala: " + e.getMessage());
        }
        return lista;
    }
    public static void cadastrar(Sala sala) {
        List<Sala> salas = carregar();
        salas.add(sala);
        salvar(salas);
    }
    public static boolean editar(int idSala, Sala salaAtualizada) {
        List<Sala> salas = carregar();
        boolean atualizado = false;

        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getIdSala() == idSala) {
                salas.set(i, salaAtualizada);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(salas);
        }
        return atualizado;
    }
    public static Sala consultar(int idSala) {
        List<Sala> salas = carregar();
        for (Sala sala : salas) {
            if (sala.getIdSala() == idSala) {
                return sala;
            }
        }
        return null;
    }
    public static List<Sala> listar() {
        return carregar();
    }
}