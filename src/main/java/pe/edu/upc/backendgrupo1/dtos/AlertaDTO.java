package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.User;

import java.time.LocalDate;

public class AlertaDTO {

    private int idAlerta;

    private String mensajeAlerta;

    private String tipoAlerta;

    private LocalDate fechayhoraAlerta;

    private boolean vistoAlerta;

    private User usuario;


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

    public LocalDate getFechayhoraAlerta() {
        return fechayhoraAlerta;
    }

    public void setFechayhoraAlerta(LocalDate fechayhoraAlerta) {
        this.fechayhoraAlerta = fechayhoraAlerta;
    }

    public boolean isVistoAlerta() {
        return vistoAlerta;
    }

    public void setVistoAlerta(boolean vistoAlerta) {
        this.vistoAlerta = vistoAlerta;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
