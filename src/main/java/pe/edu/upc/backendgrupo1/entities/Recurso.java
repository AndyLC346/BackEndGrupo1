package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="recursoseducativos")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecurso;

    @Column(name="tituloRecurso", nullable=false, length=50)
    private String tituloRecurso;

    @Column(name="descripcionRecurso", nullable=false, length=100)
    private String descripcionRecurso;

    @Column(name="tipoRecurso", nullable=false, length=50)
    private String tipoRecurso;

    @Column(name="nivelRecurso", nullable=false, length=50)
    private String nivelRecurso;
 
    @Column(name="urlRecurso", nullable=false, length=100)
    private String urlRecurso;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User usuario;

    public Recurso() {
    }

    public Recurso(int idRecurso, String tituloRecurso, String descripcionRecurso, String tipoRecurso, String nivelRecurso, String urlRecurso, User usuario) {
        this.idRecurso = idRecurso;
        this.tituloRecurso = tituloRecurso;
        this.descripcionRecurso = descripcionRecurso;
        this.tipoRecurso = tipoRecurso;
        this.nivelRecurso = nivelRecurso;
        this.urlRecurso = urlRecurso;
        this.usuario = usuario;
    }

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

    public String getNivelRecurso() {
        return nivelRecurso;
    }

    public void setNivelRecurso(String nivelRecurso) {
        this.nivelRecurso = nivelRecurso;
    }

    public String getUrlRecurso() {
        return urlRecurso;
    }

    public void setUrlRecurso(String urlRecurso) {
        this.urlRecurso = urlRecurso;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
