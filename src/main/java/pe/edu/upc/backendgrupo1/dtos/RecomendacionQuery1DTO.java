package pe.edu.upc.backendgrupo1.dtos;

public class RecomendacionQuery1DTO {
    private String username;
    private String categoriaRecomendacion;
    private int cantidadRecomendaciones;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategoriaRecomendacion() {
        return categoriaRecomendacion;
    }

    public void setCategoriaRecomendacion(String categoriaRecomendacion) {
        this.categoriaRecomendacion = categoriaRecomendacion;
    }

    public int getCantidadRecomendaciones() {
        return cantidadRecomendaciones;
    }

    public void setCantidadRecomendaciones(int cantidadRecomendaciones) {
        this.cantidadRecomendaciones = cantidadRecomendaciones;
    }
}
