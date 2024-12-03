import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeAtorDAO {
    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/FilmeAtor.txt";

    public static void salvar(List<FilmeAtor> filmeAtores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (FilmeAtor filmeAtor : filmeAtores) {
                writer.write(filmeAtor.getIdFilmeAtor() + ";" +
                        filmeAtor.getAtor().getRegistro() + ";" +
                        filmeAtor.getFilme().getIdFilme() + ";" +
                        filmeAtor.getPersonagem() + ";" +
                        filmeAtor.isPrincipal());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar FilmeAtor: " + e.getMessage());
        }
    }
    public static List<FilmeAtor> carregar(List<Ator> atores, List<Filme> filmes) {
        List<FilmeAtor> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                int idFilmeAtor = Integer.parseInt(split[0]);
                int registroAtor = Integer.parseInt(split[1]);
                int idFilme = Integer.parseInt(split[2]);
                String personagem = split[3];
                boolean principal = Boolean.parseBoolean(split[4]);

                Ator ator = atores.stream()
                        .filter(a -> a.getRegistro() == registroAtor)
                        .findFirst()
                        .orElse(null);

                Filme filme = filmes.stream()
                        .filter(f -> f.getIdFilme() == idFilme)
                        .findFirst()
                        .orElse(null);

                if (ator != null && filme != null) {
                    FilmeAtor filmeAtor = new FilmeAtor(idFilmeAtor, ator, filme, personagem, principal);
                    lista.add(filmeAtor);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar FilmeAtor: " + e.getMessage());
        }
        return lista;
    }
    public static void cadastrar(FilmeAtor filmeAtor, List<Ator> atores, List<Filme> filmes) {
        List<FilmeAtor> filmeAtores = carregar(atores, filmes);
        filmeAtores.add(filmeAtor);
        salvar(filmeAtores);
    }
    public static boolean editar(int idFilmeAtor, FilmeAtor filmeAtorAtualizado, List<Ator> atores, List<Filme> filmes) {
        List<FilmeAtor> filmeAtores = carregar(atores, filmes);
        boolean atualizado = false;

        for (int i = 0; i < filmeAtores.size(); i++) {
            if (filmeAtores.get(i).getIdFilmeAtor() == idFilmeAtor) {
                filmeAtores.set(i, filmeAtorAtualizado);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(filmeAtores);
        }
        return atualizado;
    }
    public static FilmeAtor consultar(int idFilmeAtor, List<Ator> atores, List<Filme> filmes) {
        List<FilmeAtor> filmeAtores = carregar(atores, filmes);
        for (FilmeAtor filmeAtor : filmeAtores) {
            if (filmeAtor.getIdFilmeAtor() == idFilmeAtor) {
                return filmeAtor;
            }
        }
        return null;
    }
    public static List<FilmeAtor> listar(List<Ator> atores, List<Filme> filmes) {
        return carregar(atores, filmes);
    }
}
