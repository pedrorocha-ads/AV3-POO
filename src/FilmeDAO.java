import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/filmes.txt";

    public static void salvar(List<Filme> filmes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Filme filme : filmes) {
                writer.write(filme.getIdFilme() + ";" + filme.getTitulo() + ";" + filme.getClassificacao() + ";" + filme.getGenero() + ";" + filme.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar filmes: " + e.getMessage());
        }
    }

    public static List<Filme> carregar() {
        List<Filme> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                if (split.length == 5) {
                    Filme filme = new Filme(
                            Integer.parseInt(split[0]), // ID do Filme
                            split[1], // Título
                            Integer.parseInt(split[2]), // Classificação
                            split[3], // Gênero
                            split[4] // Status
                    );
                    lista.add(filme);
                } else {
                    System.err.println("Linha inválida no arquivo: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar filmes: " + e.getMessage());
        }
        return lista;
    }

    public static void cadastrar(Filme filme) {
        List<Filme> filmes = carregar();
        filmes.add(filme);
        salvar(filmes);
    }

    public static boolean editar(int idFilme, Filme filmeAtualizado) {
        List<Filme> filmes = carregar();
        boolean atualizado = false;

        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getIdFilme() == idFilme) {
                filmes.set(i, filmeAtualizado);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(filmes);
        }
        return atualizado;
    }

    public static Filme consultar(int idFilme) {
        List<Filme> filmes = carregar();
        for (Filme filme : filmes) {
            if (filme.getIdFilme() == idFilme) {
                return filme;
            }
        }
        return null;
    }

    public static List<Filme> listar() {
        return carregar();
    }
}