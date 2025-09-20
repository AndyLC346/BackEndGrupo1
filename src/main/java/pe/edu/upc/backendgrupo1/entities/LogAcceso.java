package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "logacceso")
public class LogAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLogAcceso;

    @Column(nullable = false)
    private LocalDate fechaAcceso;

    @Column(length = 40, nullable = false)
    private String ipAcceso;

    @Column(length = 50, nullable = false)
    private String navegadorAcceso;

    @Column(length = 50, nullable = false)
    private String sistemaoperativoAcesso;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private User usuario;

    public LogAcceso() {
    }

    public LogAcceso(int idLogAcceso, LocalDate fechaAcceso, String ipAcceso, String navegadorAcceso, String sistemaoperativoAcesso, User usuario) {
        this.idLogAcceso = idLogAcceso;
        this.fechaAcceso = fechaAcceso;
        this.ipAcceso = ipAcceso;
        this.navegadorAcceso = navegadorAcceso;
        this.sistemaoperativoAcesso = sistemaoperativoAcesso;
        this.usuario = usuario;
    }

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

    public String getSistemaoperativoAcesso() {
        return sistemaoperativoAcesso;
    }

    public void setSistemaoperativoAcesso(String sistemaoperativoAcesso) {
        this.sistemaoperativoAcesso = sistemaoperativoAcesso;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
