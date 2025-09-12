package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="alertas")
public class Alerta {

    public int getIdAlerta() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAlertaid() {
        return alertaid;
    }

    public void setAlertaid(String alertaid) {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name="alertaid", nullable=false, length=30, unique = true)
    private String alertaid;


    @Column(name="tipo", nullable=false, length=50)
    private String tipo;

    @Column(name="mensaje", nullable=false, length=50)
    private String mensaje;

    @Column(name="estado", nullable=false)
    private boolean estado;

    @Column(name="emailUser", nullable=false, length=50)
    private LocalDate fechagenerada;


    public Alerta() {

    }


}
