package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="archivos")
public class Archivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArchivos;

    @Column(name="nombreArchivo", nullable=false, length=100, unique = true)
    private String nombreArchivo;

    @Column(name="tipoArchivo", nullable=false, length=50)
    private String tipoArchivo;

    @Column(name="fechaArchivo", nullable=false)
    private LocalDate fechaArchivo;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User usuario;

    public Archivos() {
    }

    public Archivos(int idArchivos, String nombreArchivo, String tipoArchivo, LocalDate fechaArchivo, User usuario) {
        this.idArchivos = idArchivos;
        this.nombreArchivo = nombreArchivo;
        this.tipoArchivo = tipoArchivo;
        this.fechaArchivo = fechaArchivo;
        this.usuario = usuario;
    }

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
