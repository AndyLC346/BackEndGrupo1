package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alertaid;

    @Column(name="tipo", nullable=false, length=50)
    private String tipo;

    @Column(name="mensaje", nullable=false, length=50)
    private String mensaje;

    @Column(name="estado", nullable=false)
    private boolean estado;

    @Column(name="emailUser", nullable=false, length=50)
    private LocalDate fechagenerada;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User usuario;

    public Alerta() {
    }

    public Alerta(int alertaid, String tipo, String mensaje, boolean estado, LocalDate fechagenerada, User usuario) {
        this.alertaid = alertaid;
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.estado = estado;
        this.fechagenerada = fechagenerada;
        this.usuario = usuario;
    }

    public int getAlertaid() {
        return alertaid;
    }

    public void setAlertaid(int alertaid) {
        this.alertaid = alertaid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechagenerada() {
        return fechagenerada;
    }

    public void setFechagenerada(LocalDate fechagenerada) {
        this.fechagenerada = fechagenerada;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
