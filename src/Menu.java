import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("==== Menu ====");
            System.out.println("1. Cadastrar Funcionario");
            System.out.println("2. Editar Funcionario");
            System.out.println("3. Listar Funcionarios");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inexistente");
            }
        } while(opcao != 0);
        scanner.close();
    }
}
