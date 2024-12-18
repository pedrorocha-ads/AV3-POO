import java.util.ArrayList;

public class Ator extends Pessoa {
    private int registro;

    public Ator(String cpf, String nome, String email) {
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
    public Ator consultar(int registro){
        return this;
    }
    public ArrayList<Ator> listar(Ator ator){
        return new ArrayList<Ator>();
    }
    public String toString(){
        return super.toString() + "\nRegistro: " + registro;
    }
}
