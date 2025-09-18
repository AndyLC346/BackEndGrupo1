package pe.edu.upc.backendgrupo1.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.backendgrupo1.entities.User;

public class RecomendacionDTO {

    private int idRecomendacion;

    private String tituloRecomendacion;

    private String descripcionRecomendacion;

    private String categoriaRecomendacion;

    private User user;

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
