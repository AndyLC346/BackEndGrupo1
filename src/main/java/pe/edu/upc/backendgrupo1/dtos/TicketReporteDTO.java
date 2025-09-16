package pe.edu.upc.backendgrupo1.dtos;

import java.time.LocalDate;

public class TicketReporteDTO {
    private int idSoporte;
    private String tipoSoporte;
    private String asuntoSoporte;
    private String descripcionSoporte;
    private String estadoSoporte;
    private LocalDate fechacreacionSoporte;
    private int idUsuario;

    public int getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(int idSoporte) {
        this.idSoporte = idSoporte;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechacreacionSoporte() {
        return fechacreacionSoporte;
    }

    public void setFechacreacionSoporte(LocalDate fechacreacionSoporte) {
        this.fechacreacionSoporte = fechacreacionSoporte;
    }

    public String getEstadoSoporte() {
        return estadoSoporte;
    }

    public void setEstadoSoporte(String estadoSoporte) {
        this.estadoSoporte = estadoSoporte;
    }

    public String getDescripcionSoporte() {
        return descripcionSoporte;
    }

    public void setDescripcionSoporte(String descripcionSoporte) {
        this.descripcionSoporte = descripcionSoporte;
    }

    public String getAsuntoSoporte() {
        return asuntoSoporte;
    }

    public void setAsuntoSoporte(String asuntoSoporte) {
        this.asuntoSoporte = asuntoSoporte;
    }

    public String getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(String tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }
}
