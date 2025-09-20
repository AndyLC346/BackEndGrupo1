package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recomendaciones")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecomendacion;

    @Column(length = 40, nullable = false)
    private String tituloRecomendacion;

    @Column(length = 200, nullable = false)
    private String descripcionRecomendacion;

    @Column(length = 50, nullable = false)
    private String categoriaRecomendacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private User user;

    public Recomendacion() {
    }

    public Recomendacion(int idRecomendacion, String tituloRecomendacion, String descripcionRecomendacion, String categoriaRecomendacion, User user) {
        this.idRecomendacion = idRecomendacion;
        this.tituloRecomendacion = tituloRecomendacion;
        this.descripcionRecomendacion = descripcionRecomendacion;
        this.categoriaRecomendacion = categoriaRecomendacion;
        this.user = user;
    }

    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public String getTituloRecomendacion() {
        return tituloRecomendacion;
    }

    public void setTituloRecomendacion(String tituloRecomendacion) {
        this.tituloRecomendacion = tituloRecomendacion;
    }

    public String getDescripcionRecomendacion() {
        return descripcionRecomendacion;
    }

    public void setDescripcionRecomendacion(String descripcionRecomendacion) {
        this.descripcionRecomendacion = descripcionRecomendacion;
    }

    public String getCategoriaRecomendacion() {
        return categoriaRecomendacion;
    }

    public void setCategoriaRecomendacion(String categoriaRecomendacion) {
        this.categoriaRecomendacion = categoriaRecomendacion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
