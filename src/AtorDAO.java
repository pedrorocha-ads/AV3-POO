import java.io.*;
import java.util.ArrayList;
import java.util.List;

    public class AtorDAO {
        private static final String FILE_NAME = "atores.txt";

        public static void salvar(List<Ator> atores) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Ator ator : atores) {
                    writer.write(ator.getCpf() + ";" + ator.getNome() + ";" + ator.getEmail() + ";" + ator.getRegistro());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao gravar atores: " + e.getMessage());
            }
        }
        public static List<Ator> carregar() {
            List<Ator> lista = new ArrayList<>();
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
                return lista;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] split = linha.split(";");
                    Ator ator = new Ator(
                            split[0], // CPF
                            split[1], // Nome
                            split[2] // Email
                            // Registro
                    );
                    lista.add(ator);
                }
            } catch (IOException e) {
                System.err.println("Erro ao carregar atores: " + e.getMessage());
            }
            return lista;
        }
        public static void cadastrar(Ator ator) {
            List<Ator> atores = carregar();
            atores.add(ator);
            salvar(atores);
        }
        public static boolean editar(int registro, Ator atorAtualizado) {
            List<Ator> atores = carregar();
            boolean atualizado = false;

            for (int i = 0; i < atores.size(); i++) {
                if (atores.get(i).getRegistro() == registro) {
                    atores.set(i, atorAtualizado);
                    atualizado = true;
                    break;
                }
            }

            if (atualizado) {
                salvar(atores);
            }
            return atualizado;
        }
        public static Ator consultar(int registro) {
            List<Ator> atores = carregar();
            for (Ator ator : atores) {
                if (ator.getRegistro() == registro) {
                    return ator;
                }
            }
            return null;
        }
        public static List<Ator> listar() {
            return carregar();
        }
    }
