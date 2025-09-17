package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "log_acceso")
public class LogAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogAcceso;

    private LocalDate fechaAcceso;

    private String ip;

    private String navegador;

    private String sistemaOperativo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public LogAcceso() {
    }

    public LogAcceso(Long idLogAcceso, LocalDate fechaAcceso, String ip, String navegador, String sistemaOperativo, User user) {
        this.idLogAcceso = idLogAcceso;
        this.fechaAcceso = fechaAcceso;
        this.ip = ip;
        this.navegador = navegador;
        this.sistemaOperativo = sistemaOperativo;
        this.user = user;
    }

    public Long getIdLogAcceso() {
        return idLogAcceso;
    }

    public void setIdLogAcceso(Long idLogAcceso) {
        this.idLogAcceso = idLogAcceso;
    }

    public LocalDate getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(LocalDate fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
