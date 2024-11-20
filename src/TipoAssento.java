import java.util.ArrayList;

public class TipoAssento {
    private int idTipoAssento;
    private String descricao;
    private String status;

    public TipoAssento(int idTipoAssento, String descricao, String status) {
        this.idTipoAssento = idTipoAssento;
        this.descricao = descricao;
        this.status = status;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getIdTipoAssento() {
        return idTipoAssento;
    }
    public void setIdTipoAssento(int idTipoAssento) {
        this.idTipoAssento = idTipoAssento;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public boolean cadastrar(TipoAssento tipoAssento) {
        return false;
    }
    public boolean editar(TipoAssento tipoAssento) {
        return false;
    }
    public consultar(TipoAssento tipoAssento){
        return false;
    }
    public listar(TipoAssento tipoAssento){
        return new ArrayList<TipoAssento>();
    }
}
