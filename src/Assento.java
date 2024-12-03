import java.util.ArrayList;

public class Assento {
    private int idAssento;
    private TipoAssento tipoAssento;

    public Assento(int idTipoAssento, String descricao, String status, int idAssento, TipoAssento tipoAssento) {
        this.idAssento = idAssento;
        this.tipoAssento = tipoAssento;
    }
    public int getIdAssento() {
        return idAssento;
    }
    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }
    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }
    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
    }
    public boolean cadastrar(Assento assento) {
        return false;
    }
    public boolean editar(Assento assento) {
        return false;
    }
    public Assento consultar(int IdAssento) {
        return this;
    }
    public static ArrayList<Assento> listar() {
        return new ArrayList<>();
    }
    public String toString() {
        return "Assento [ID: " + idAssento + ", Tipo: " + tipoAssento + "]";
    }

}
