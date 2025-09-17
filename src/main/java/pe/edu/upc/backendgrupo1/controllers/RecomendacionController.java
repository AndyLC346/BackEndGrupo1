package pe.edu.upc.backendgrupo1.controllers;

import jakarta.persistence.*;

@Entity
@Table(name = "recomendaciones")
public class RecomendacionController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecomendacion;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255)
    private String descripcion;

    public Long getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(Long idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
