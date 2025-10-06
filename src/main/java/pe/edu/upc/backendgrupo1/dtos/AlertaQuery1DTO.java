package pe.edu.upc.backendgrupo1.dtos;

import java.time.LocalDate;

public class AlertaQuery1DTO {
    private int idUsuario;
    private int cantidadUusarios;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidadUusarios() {
        return cantidadUusarios;
    }

    public void setCantidadUusarios(int cantidadUusarios) {
        this.cantidadUusarios = cantidadUusarios;
    }
}
