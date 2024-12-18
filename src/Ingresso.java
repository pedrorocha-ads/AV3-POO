import java.util.ArrayList;

public class Ingresso {
    private int idIngresso;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;

    public Ingresso(int idIngresso, double valorPago, Sessao sessao, SalaAssento salaAssento) {
        this.idIngresso = idIngresso;
        this.valorPago = valorPago;
        this.sessao = sessao;
        this.salaAssento = salaAssento;
    }
    public int getIdIngresso() {
        return idIngresso;
    }
    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }
    public double getValorPago() {
        return valorPago;
    }
    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    public SalaAssento getSalaAssento() {
        return salaAssento;
    }
    public void setSalaAssento(SalaAssento salaAssento) {
        this.salaAssento = salaAssento;
    }
    public Sessao getSessao() {
        return sessao;
    }
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    public boolean cadastrar(Ingresso ingresso) {
        return false;
    }
    public boolean editar(Ingresso ingresso) {
        return false;
    }
    public Ingresso consultar(int idiIngresso) {
        return this;
    }
    public static ArrayList<Ingresso> listar() {
        return new ArrayList<>();
    }
    public String toString() {
        return "Ingresso {" +
                "ID: " + idIngresso +
                ", Valor Pago: R$ " + String.format("%.2f", valorPago) +
                ", Sala/Assento: " + (salaAssento != null ? salaAssento : "N/A") +
                ", Sessão: " + (sessao != null ? sessao : "N/A") +
                '}';
    }
}
