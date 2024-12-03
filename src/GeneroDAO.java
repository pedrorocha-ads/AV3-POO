import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/Genero.txt";

    public static void salvar(List<Genero> generos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Genero genero : generos) {
                writer.write(genero.getId() + ";" + genero.getDescricao() + ";" + genero.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar Gênero: " + e.getMessage());
        }
    }
    public static List<Genero> carregar() {
        List<Genero> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                int id = Integer.parseInt(split[0]);
                String descricao = split[1];
                String status = split[2];
                Genero genero = new Genero(id, descricao, status);
                lista.add(genero);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar Gênero: " + e.getMessage());
        }
        return lista;
    }
    public static void cadastrar(Genero genero) {
        List<Genero> generos = carregar();
        generos.add(genero);
        salvar(generos);
    }
    public static boolean editar(int id, Genero generoAtualizado) {
        List<Genero> generos = carregar();
        boolean atualizado = false;

        for (int i = 0; i < generos.size(); i++) {
            if (generos.get(i).getId() == id) {
                generos.set(i, generoAtualizado);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(generos);
        }
        return atualizado;
    }
    public static Genero consultar(int id) {
        List<Genero> generos = carregar();
        for (Genero genero : generos) {
            if (genero.getId() == id) {
                return genero;
            }
        }
        return null;
    }
    public static List<Genero> listar() {
        return carregar();
    }
}