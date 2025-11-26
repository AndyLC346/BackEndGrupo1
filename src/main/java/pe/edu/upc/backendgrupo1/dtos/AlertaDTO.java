package pe.edu.upc.backendgrupo1.dtos;

//add secuirty
import pe.edu.upc.backendgrupo1.entities.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class AlertaDTO {

    private int idAlerta;

    private String mensajeAlerta;

    private String tipoAlerta;

    private LocalDate fechaAlerta;

    private LocalTime horaAlerta;

    private boolean vistoAlerta;

    private Users usuario;

    public LocalDate getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(LocalDate fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    public LocalTime getHoraAlerta() {
        return horaAlerta;
    }

    public void setHoraAlerta(LocalTime horaAlerta) {
        this.horaAlerta = horaAlerta;
    }

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    public void setMensajeAlerta(String mensajeAlerta) {
        this.mensajeAlerta = mensajeAlerta;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }


    public boolean isVistoAlerta() {
        return vistoAlerta;
    }

    public void setVistoAlerta(boolean vistoAlerta) {
        this.vistoAlerta = vistoAlerta;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
