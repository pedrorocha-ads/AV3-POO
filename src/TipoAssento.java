import java.util.ArrayList;

public class TipoAssento {
    private int idTipoAssento;
    private String descricao;
    private String status;

    public TipoAssento(int idTipoAssento, String descricao) {
        this.idTipoAssento = idTipoAssento;
        this.descricao = descricao;
        this.status = status;
    }

    public static TipoAssento fromString(String tipoAssentoStr) {
        return null;
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
    public TipoAssento consultar(TipoAssento tipoAssento){
        return this;
    }
    public static ArrayList<TipoAssento> listar(){
        return new ArrayList<>();
    }
    public String toString() {
        return "TipoAssento {" +
                "ID: " + idTipoAssento +
                ", Descrição: '" + descricao + '\'' +
                ", Status: '" + status + '\'' +
                '}';
    }
}
