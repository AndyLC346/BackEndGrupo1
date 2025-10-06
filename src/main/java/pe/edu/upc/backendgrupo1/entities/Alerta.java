package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlerta;

    @Column(name="mensajeAlerta", nullable=false, length=50)
    private String mensajeAlerta;

    @Column(name="tipoAlerta", nullable=false, length=10)
    private String tipoAlerta;

    @Column(name="fechaAlerta", nullable=false)
    private LocalDate fechaAlerta;

    @Column(name="horaAlerta", nullable=false)
    private LocalTime horaAlerta;

    @Column(name="vistoAlerta", nullable=false)
    private boolean vistoAlerta;

    @ManyToOne
    @JoinColumn(name="idUser")
    private Users usuario;

    public Alerta() {
    }

    public Alerta(int idAlerta, String mensajeAlerta, String tipoAlerta, LocalDate fechaAlerta, LocalTime horaAlerta, boolean vistoAlerta, Users usuario) {
        this.idAlerta = idAlerta;
        this.mensajeAlerta = mensajeAlerta;
        this.tipoAlerta = tipoAlerta;
        this.fechaAlerta = fechaAlerta;
        this.horaAlerta = horaAlerta;
        this.vistoAlerta = vistoAlerta;
        this.usuario = usuario;
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
