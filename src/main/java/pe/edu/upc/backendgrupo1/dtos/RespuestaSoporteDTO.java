package pe.edu.upc.backendgrupo1.dtos;

import java.time.LocalDate;

public class RespuestaSoporteDTO {
    private int idRespuestaSoporte;
    private String mensajeRespuestaSoporte;
    private LocalDate fechacierreRespuestaSoporte;
    private int idSoporte;

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

    public int getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(int idSoporte) {
        this.idSoporte = idSoporte;
    }
}
