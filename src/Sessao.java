import java.util.ArrayList;
import java.util.Date;

public class Sessao {
    private int idSessao;
    private Date dataHoraSessao;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;
    private String status;

    public Sessao(int idSessao, Date dataHoraSessao, Filme filme, Sala sala, Funcionario funcionario, String status) {
        this.idSessao = idSessao;
        this.dataHoraSessao = dataHoraSessao;
        this.filme = filme;
        this.sala = sala;
        this.funcionario = funcionario;
        this.status = status;
    }
    public int getIdSessao() {
        return idSessao;
    }
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }
    public Date getDataHoraSessao() {
        return dataHoraSessao;
    }
    public void setDataHoraSessao(Date dataHoraSessao) {
        this.dataHoraSessao = dataHoraSessao;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public boolean cadastrar(Sessao sessao){
        return false;
    }
    public boolean editar(Sessao sessao){
        return false;
    }
    public Sessao consultar(Sessao sessao){
        return sessao;
    }
    public Sessao listar(Sessao sessao){
        return sessao;
    }
    public ArrayList<Sessao> listar(){
        return new ArrayList<>();
    }
    public String ToString(){
        return "Sessao ID: " + idSessao + ", Data/Hora: " + dataHoraSessao + ", Filme: " + filme + ", Sala: " + sala + ", Funcionario: " + funcionario + ", Status: " + status;
    }
}
