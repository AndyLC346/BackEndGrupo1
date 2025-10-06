package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "logaccesos")
public class LogAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLogAcceso;

    @Column(name="fechaAcceso", nullable = false)
    private LocalDate fechaAcceso;

    @Column(name="ipAcceso", length = 40, nullable = false)
    private String ipAcceso;

    @Column(name="navegadorAcceso", length = 50, nullable = false)
    private String navegadorAcceso;

    @Column(name="sistemaoperativoAcceso", length = 50, nullable = false)
    private String sistemaoperativoAcceso;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users usuario;

    public LogAcceso() {
    }

    public LogAcceso(int idLogAcceso, LocalDate fechaAcceso, String ipAcceso, String navegadorAcceso, String sistemaoperativoAcceso, Users usuario) {
        this.idLogAcceso = idLogAcceso;
        this.fechaAcceso = fechaAcceso;
        this.ipAcceso = ipAcceso;
        this.navegadorAcceso = navegadorAcceso;
        this.sistemaoperativoAcceso = sistemaoperativoAcceso;
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

    public String getSistemaoperativoAcceso() {
        return sistemaoperativoAcceso;
    }

    public void setSistemaoperativoAcceso(String sistemaoperativoAcceso) {
        this.sistemaoperativoAcceso = sistemaoperativoAcceso;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
