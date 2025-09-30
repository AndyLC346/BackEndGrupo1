package pe.edu.upc.backendgrupo1.dtos;

import java.time.LocalDate;

public class AlertaQuery1DTO {
    private int idAlerta;

    private String mensajeAlerta;

    private String tipoAlerta;

    private LocalDate fechayhoraAlerta;

    private boolean vistoAlerta;

    private Long idUser;

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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
