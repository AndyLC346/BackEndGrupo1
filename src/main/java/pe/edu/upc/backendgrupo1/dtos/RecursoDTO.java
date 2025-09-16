package pe.edu.upc.backendgrupo1.dtos;

public class RecursoDTO {
    private int idRecurso;
    private String tituloRecurso;
    private String descripcionRecurso;
    private String tipoRecurso;
    private String estadnivelRecursoo;
    private String urlRecurso;

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTituloRecurso() {
        return tituloRecurso;
    }

    public void setTituloRecurso(String tituloRecurso) {
        this.tituloRecurso = tituloRecurso;
    }

    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getEstadnivelRecursoo() {
        return estadnivelRecursoo;
    }

    public void setEstadnivelRecursoo(String estadnivelRecursoo) {
        this.estadnivelRecursoo = estadnivelRecursoo;
    }

    public String getUrlRecurso() {
        return urlRecurso;
    }

    public void setUrlRecurso(String urlRecurso) {
        this.urlRecurso = urlRecurso;
    }
}
