package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.User;

import java.time.LocalDate;

public class TicketReporteDTO {
    private int idSoporte;
    private String tipoSoporte;
    private String asuntoSoporte;
    private String descripcionSoporte;
    private String estadoSoporte;
    private LocalDate fechacreacionSoporte;
    private User usuario;

    public int getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(int idSoporte) {
        this.idSoporte = idSoporte;
    }

    public String getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(String tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    public String getAsuntoSoporte() {
        return asuntoSoporte;
    }

    public void setAsuntoSoporte(String asuntoSoporte) {
        this.asuntoSoporte = asuntoSoporte;
    }

    public String getDescripcionSoporte() {
        return descripcionSoporte;
    }

    public void setDescripcionSoporte(String descripcionSoporte) {
        this.descripcionSoporte = descripcionSoporte;
    }

    public String getEstadoSoporte() {
        return estadoSoporte;
    }

    public void setEstadoSoporte(String estadoSoporte) {
        this.estadoSoporte = estadoSoporte;
    }

    public LocalDate getFechacreacionSoporte() {
        return fechacreacionSoporte;
    }

    public void setFechacreacionSoporte(LocalDate fechacreacionSoporte) {
        this.fechacreacionSoporte = fechacreacionSoporte;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
