import java.util.ArrayList;

public class Sala {
    private int idSala;
    private int capacidadeSala;
    private String descricao;
    private String status;

    public Sala(int idSala, int capacidadeSala, String status, String descricao) {
        this.idSala = idSala;
        this.capacidadeSala = capacidadeSala;
        this.status = status;
        this.descricao = descricao;
    }
    public int getIdSala() {
        return idSala;
    }
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    public int getCapacidadeSala() {
        return capacidadeSala;
    }
    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public boolean cadastrar(Sala sala){
        return false;
    }
    public boolean editar(Sala sala){
        return false;
    }
    public boolean consultar(Sala sala){
        return false;
    }
    public ArrayList<Sala> listar(){
        return null;
    }
}
