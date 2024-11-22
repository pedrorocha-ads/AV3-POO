import java.util.ArrayList;

public class Assento {
    private int idAssento;
    private TipoAssento tipoassento;

    public Assento(int idTipoAssento, String descricao, String status, int idAssento, TipoAssento tipoAssento) {
        this.idAssento = idAssento;
        this.tipoAssento = tipoassento;
    }
    public int getIdAssento() {
        return idAssento;
    }
    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }
    public TipoAssento getTipoAssento() {
        return tipoassento;
    }
    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoassento = tipoAssento;
    }
    public boolean cadastrar(Assento assento) {
        return false;
    }
    public boolean editar(Assento assento) {
        return false;
    }
    public Assento consultar(Assento assento){
        return assento;
    }
    public ArrayList listar(Assento assento){
        return new ArrayList<Assento>();
    }
}
