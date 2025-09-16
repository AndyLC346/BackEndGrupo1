package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuditoria;

    @Column(name = "fechaAuditoria")
    private LocalDateTime fechaAuditoria;

    @Column(name = "tipoAuditoria", length = 20)
    private String tipoAuditoria;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;

    // Getters y Setters
    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public LocalDateTime getFechaAuditoria() {
        return fechaAuditoria;
    }

    public void setFechaAuditoria(LocalDateTime fechaAuditoria) {
        this.fechaAuditoria = fechaAuditoria;
    }

    public String getTipoAuditoria() {
        return tipoAuditoria;
    }

    public void setTipoAuditoria(String tipoAuditoria) {
        this.tipoAuditoria = tipoAuditoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
