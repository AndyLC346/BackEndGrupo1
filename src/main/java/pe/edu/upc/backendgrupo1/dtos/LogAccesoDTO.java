package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.User;
import java.time.LocalDate;

public class LogAccesoDTO {
    private int idLogAcceso;
    private LocalDate fechaAcceso;
    private String ipAcceso;
    private String navegadorAcceso;
    private String sistemaoperativoAcceso;
    private User user;

    public int getIdLogAcceso() {
        return idLogAcceso;
    }

    public void setIdLogAcceso(int idLogAcceso) {
        this.idLogAcceso = idLogAcceso;
    }

    public LocalDate getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(LocalDate fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public String getIpAcceso() {
        return ipAcceso;
    }

    public void setIpAcceso(String ipAcceso) {
        this.ipAcceso = ipAcceso;
    }

    public String getNavegadorAcceso() {
        return navegadorAcceso;
    }

    public void setNavegadorAcceso(String navegadorAcceso) {
        this.navegadorAcceso = navegadorAcceso;
    }

    public String getSistemaoperativoAcceso() {
        return sistemaoperativoAcceso;
    }

    public void setSistemaoperativoAcceso(String sistemaoperativoAcceso) {
        this.sistemaoperativoAcceso = sistemaoperativoAcceso;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
