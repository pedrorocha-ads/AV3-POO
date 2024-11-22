import java.util.ArrayList;

public class Sessao {
    private int idSessao;
    private dataSessaoHora datetime;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;
    private String status;

    public Sessao(String cpf, String nome, String email, int matricula, date horarioTrabalho, int idSessao, dataSessaoHora datetime, Filme filme, Sala sala, Funcionario funcionario, String status) {
        super(cpf, nome, email, matricula, horarioTrabalho);
        this.idSessao = idSessao;
        this.datetime = datetime;
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
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public dataSessaoHora getDatetime() {
        return datetime;
    }
    public void setDatetime(dataSessaoHora datetime) {
        this.datetime = datetime;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public boolean cadastrar(Sessao sessao){
        return false;
    }
    public boolean editar(Sessao sessao){
        return false;
    }
    public Sessao consultar(Sessao sessao){
        return null;
    }
    public Sessao listar(Sessao sessao){
        return null;
    }
    public ArrayList<Sessao> listar(){
        return new ArrayList<>();
    }
}
