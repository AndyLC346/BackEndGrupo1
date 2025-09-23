package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.Users;

public class RecomendacionDTO {

    private int idRecomendacion;

    private String tituloRecomendacion;

    private String descripcionRecomendacion;

    private String categoriaRecomendacion;

    private Users usuario;

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
