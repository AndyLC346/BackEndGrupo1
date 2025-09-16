package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.User;

import java.time.LocalDate;

public class ArchivosDTO {

    private int idArchivos;
    private String nombreArchivo;
    private String tipoArchivo;
    private LocalDate fechaArchivo;
    private User usuario;

    public int getIdArchivos() {
        return idArchivos;
    }

    public void setIdArchivos(int idArchivos) {
        this.idArchivos = idArchivos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public LocalDate getFechaArchivo() {
        return fechaArchivo;
    }

    public void setFechaArchivo(LocalDate fechaArchivo) {
        this.fechaArchivo = fechaArchivo;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
