import java.util.ArrayList;

public class Ator extends Pessoa {
    private int registro;

    public Ator(String cpf, String nome, String email, int registro) {
        super(cpf, nome, email);
        this.registro = registro;
    }
    public int getRegistro() {
        return registro;
    }
    public void setRegistro(int registro) {
        this.registro = registro;
    }
    public boolean cadastrar(Ator ator){
        return true;
    }
    public boolean editar(Ator ator){
        return true;
    }
    public ArrayList<Ator> listar(Ator ator){
        return new ArrayList<Ator>();
    }

}
