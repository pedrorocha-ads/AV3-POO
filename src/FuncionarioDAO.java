import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private static final String DIRECTORY = "database";
    private static final String FILE_NAME = DIRECTORY + "/funcionarios.txt";

    public static void salvar(List<Funcionario> funcionarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Funcionario f : funcionarios) {
                writer.write(f.getCpf() + ";" + f.getNome() + ";" + f.getEmail() + ";" +
                        f.getMatricula() + ";" + f.getHorarioTrabalho());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar funcionários: " + e.getMessage());
        }
    }
    public static List<Funcionario> carregar() {
        List<Funcionario> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Aviso: O arquivo '" + FILE_NAME + "' não existe. Criando um novo.");
            return lista;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] split = linha.split(";");
                Funcionario funcionario = new Funcionario(
                        split[0], // CPF
                        split[1], // Nome
                        split[2], // Email
                        Integer.parseInt(split[3]), // Matrícula
                        split[4]  // Horário de Trabalho
                );
                lista.add(funcionario);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar funcionários: " + e.getMessage());
        }
        return lista;
    }
    public static void cadastrar(Funcionario funcionario) {
        List<Funcionario> funcionarios = carregar();
        funcionarios.add(funcionario);
        salvar(funcionarios);
    }
    public static boolean editar(int matricula, Funcionario funcionarioAtualizado) {
        List<Funcionario> funcionarios = carregar();
        boolean atualizado = false;

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula() == matricula) {
                funcionarios.set(i, funcionarioAtualizado);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            salvar(funcionarios);
        }
        return atualizado;
    }
    public static Funcionario consultar(int matricula) {
        List<Funcionario> funcionarios = carregar();
        for (Funcionario f : funcionarios) {
            if (f.getMatricula() == matricula) {
                return f;
            }
        }
        return null;
    }
    public static List<Funcionario> listar() {
        return carregar();
    }
}
