public class SalaAssento {
    private int idSalaAssento;
    private Assento assento;
    private Sala sala;

    public SalaAssento(int idSalaAssento, Assento assento, Sala sala) {
        this.idSalaAssento = idSalaAssento;
        this.assento = assento;
        this.sala = sala;
    }

    public static SalaAssento consultar(int idAssento) {
        return null;
    }

    public int getIdSalaAssento() {
        return idSalaAssento;
    }
    public void setIdSalaAssento(int idSalaAssento) {
        this.idSalaAssento = idSalaAssento;
    }
    public Assento getAssento() {
        return assento;
    }
    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public boolean cadastrar(SalaAssento salaAssento) {
        return false;
    }
    public boolean editar(SalaAssento salaAssento) {
        return false;
    }
    public boolean consultar(SalaAssento salaAssento) {
        return false;
    }
    public Sala listar(SalaAssento salaAssento){
        return null;
    }

    public String getIdAssento() {
        return null;
    }
}
