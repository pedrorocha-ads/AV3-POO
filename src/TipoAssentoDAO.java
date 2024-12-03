import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TipoAssentoDAO {
    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/assentos.txt";

    static {
        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void salvar(List<Assento> assentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Assento assento : assentos) {
                writer.write(assento.getIdAssento() + ";" + assento.getTipoAssento());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar assento: " + e.getMessage());
        }
    }

    public static List<Assento> carregar() {
        List<Assento> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                int idAssento = Integer.parseInt(split[0]);
                TipoAssento tipoAssento = TipoAssento.fromString(split[1]);
                Assento assento = new Assento(idAssento, tipoAssento);
                lista.add(assento);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar assento: " + e.getMessage());
        }
        return lista;
    }

    public static void cadastrar(Assento assento) {
        List<Assento> assentos = carregar();
        assentos.add(assento);
        salvar(assentos);
    }

    public static boolean editar(int idAssento, Assento assentoAtualizado) {
        List<Assento> assentos = carregar();
        boolean atualizado = false;

        for (int i = 0; i < assentos.size(); i++) {
            if (assentos.get(i).getIdAssento() == idAssento) {
                assentos.set(i, assentoAtualizado);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(assentos);
        }
        return atualizado;
    }

    public static Assento consultar(int idAssento) {
        List<Assento> assentos = carregar();
        for (Assento assento : assentos) {
            if (assento.getIdAssento() == idAssento) {
                return assento;
            }
        }
        return null;
    }

    public static List<Assento> listar() {
        return carregar();
    }
}