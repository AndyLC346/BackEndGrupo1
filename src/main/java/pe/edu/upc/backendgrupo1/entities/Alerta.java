package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Column(name="fechayhoraAlerta", nullable=false)
    private LocalDate fechayhoraAlerta;

    @Column(name="vistoAlerta", nullable=false)
    private boolean vistoAlerta;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User usuario;

    public Alerta() {
    }

    public Alerta(int idAlerta, String mensajeAlerta, String tipoAlerta, LocalDate fechayhoraAlerta, boolean vistoAlerta, User usuario) {
        this.idAlerta = idAlerta;
        this.mensajeAlerta = mensajeAlerta;
        this.tipoAlerta = tipoAlerta;
        this.fechayhoraAlerta = fechayhoraAlerta;
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
