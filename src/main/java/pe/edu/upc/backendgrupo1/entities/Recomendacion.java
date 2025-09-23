package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recomendaciones")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecomendacion;

    @Column(name="tituloRecomendacion",length = 40, nullable = false)
    private String tituloRecomendacion;

    @Column(name="descripcionRecomendacion",length = 200, nullable = false)
    private String descripcionRecomendacion;

    @Column(name="categoriaRecomendacion",length = 50, nullable = false)
    private String categoriaRecomendacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    public Recomendacion() {
    }

    public Recomendacion(int idRecomendacion, String tituloRecomendacion, String descripcionRecomendacion, String categoriaRecomendacion, Users usuario) {
        this.idRecomendacion = idRecomendacion;
        this.tituloRecomendacion = tituloRecomendacion;
        this.descripcionRecomendacion = descripcionRecomendacion;
        this.categoriaRecomendacion = categoriaRecomendacion;
        this.usuario = usuario;
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

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
