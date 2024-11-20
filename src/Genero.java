public class Genero implements Ator{
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
    public consultar(Genero genero){
        return genero;
    }

}
