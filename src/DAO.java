import java.io.*;
import java.util.ArrayList;

public class DAO {
    private static final String FILE_NAME = "funcionario.txt";

    public static boolean cadastrar(Funcionario funcionario) {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(FILE_NAME))) {
            write.write(funcionario.toString());
            write.newLine();
            return true;
        }catch (IOException e){
            System.err.println("Erro ao cadastrar funcionario: " + e.getMessage());
            return false;
        }
    }
    public static ArrayList<Funcionario> listar(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] dados = line.split(",");
                Funcionario funcionario = new Funcionario(
                        dados[0], //CPF
                        dados[1], //Nome
                        dados[2], //Email
                        Integer.parseInt(dados[3]), //Matricula
                        dados[4]//Hora Trabalho
                );
                funcionarios.add(funcionario);
            }
        }catch (IOException e){
            System.err.println("Erro ao listar funcionarios: " + e.getMessage());
        }
        return funcionarios;
    }
    public static boolean editar(int matricula, Funcionario funcionarioAtualizado){
        try{
            ArrayList<Funcionario> funcionarios = listar();
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
                for(Funcionario f : funcionarios){
                    if(f.getMatricula() == matricula){
                        writer.write(funcionarioAtualizado.toString());
                    }else{
                        writer.write(f.toString());
                    }
                    writer.newLine();
                }
            }
            return true;
        }catch(IOException e){
            System.err.println("Erro ao editar funcionario: " + e.getMessage());
            return false;
        }
    }
}
