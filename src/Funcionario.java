import java.util.ArrayList;
import java.util.Date;

public class Funcionario extends Pessoa{
    private int matricula;
    private String horarioTrabalho;

    public Funcionario(String cpf, String nome, String email, int matricula, String horarioTrabalho) {
        super(cpf, nome, email);
        this.matricula = matricula;
        this.horarioTrabalho = horarioTrabalho;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }
    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }
    public boolean cadastrar(Funcionario funcionario) {
        return true;
    }
    public boolean editar(Funcionario funcionario) {
        return true;
    }
    public Funcionario consultar(int matricula) {
        return this; //retornar informações do funcionario
    }
    public static ArrayList<Funcionario> listar() {
        return new ArrayList<>();
    }
    public String toString() {
        return super.toString() + ", Funcionario [Matricula: " + matricula + ", Horario: " + horarioTrabalho + "]";
    }
}
