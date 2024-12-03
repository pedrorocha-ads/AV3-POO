import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private static final String FILE_NAME = "Filmes.txt";

    public static void salvar(List<Filme> filmes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Filme filme : filmes) {
                writer.write(filme.getIdFilme() + ";" +
                        filme.getTitulo() + ";" +
                        filme.getClassificacao() + ";" +
                        filme.getGenero() + ";" +
                        filme.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar filmes: " + e.getMessage());
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
                int idFilme = Integer.parseInt(split[0]);
                String titulo = split[1];
                int classificacao = Integer.parseInt(split[2]);
                Genero genero = Genero.listar().get(Integer.parseInt(split[3]));
                String status = split[4];

                Filme filme = new Filme(idFilme, titulo, classificacao, genero, status);
                lista.add(filme);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar filmes: " + e.getMessage());
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
