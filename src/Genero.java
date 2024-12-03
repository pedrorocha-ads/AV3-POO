import java.util.ArrayList;

public class Genero {
    private int id;
    private String descricao;
    private String status;

    public Genero(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean cadastrar(Genero genero){
        return false;
    }
    public boolean editar(Genero genero){
        return false;
    }
    public Genero consultar(Genero genero){
        return this;
    }
    public static ArrayList<Genero> listar(){
        return new ArrayList<>();
    }
    public String toString(){
        return "Genero [ID=" + id + ", Descricao=" + descricao + ", Status=" + status + "]";
    }
    public static TipoAssento valueOf(String s) {
        return null;
    }


}
