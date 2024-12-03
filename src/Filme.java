import java.util.ArrayList;

public class Filme {
    private int idFilme;
    private String titulo;
    private int classificacao;
    private String genero;
    private String status;

    public Filme(int idFilme, String titulo, int classificacao, String genero, String status) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = status;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Filme [ID: " + idFilme + ", Titulo: " + titulo + ", Classificacao: " + classificacao + ", Genero: " + genero + ", Status: " + status + "]";
    }

    public String getId() {
        return idFilme + "";
    }
}