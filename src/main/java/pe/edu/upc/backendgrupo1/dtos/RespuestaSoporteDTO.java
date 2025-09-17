package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.TicketReporte;

import java.time.LocalDate;

public class RespuestaSoporteDTO {

    private int idRespuestaSoporte;

    private String mensajeRespuestaSoporte;

    private LocalDate fechacierreRespuestaSoporte;

    private TicketReporte treporte;

    public int getIdRespuestaSoporte() {
        return idRespuestaSoporte;
    }

    public void setIdRespuestaSoporte(int idRespuestaSoporte) {
        this.idRespuestaSoporte = idRespuestaSoporte;
    }

    public String getMensajeRespuestaSoporte() {
        return mensajeRespuestaSoporte;
    }

    public void setMensajeRespuestaSoporte(String mensajeRespuestaSoporte) {
        this.mensajeRespuestaSoporte = mensajeRespuestaSoporte;
    }

    public LocalDate getFechacierreRespuestaSoporte() {
        return fechacierreRespuestaSoporte;
    }

    public void setFechacierreRespuestaSoporte(LocalDate fechacierreRespuestaSoporte) {
        this.fechacierreRespuestaSoporte = fechacierreRespuestaSoporte;
    }

    public TicketReporte getTreporte() {
        return treporte;
    }

    public void setTreporte(TicketReporte treporte) {
        this.treporte = treporte;
    }
}
