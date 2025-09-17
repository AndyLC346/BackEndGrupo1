package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="TicketReporte")
public class TicketReporte {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idSoporte;
    @Column(name="tipoSoporte",nullable = false,length = 10)
    private String tipoSoporte;
    @Column(name="asuntoSoporte",nullable = false,length = 40)
    private String asuntoSoporte;
    @Column(name="descripcionSoporte",nullable = false,length = 200)
    private String descripcionSoporte;
    @Column(name="estadoSoporte",nullable = false,length = 20)
    private String estadoSoporte;
    @Column(name="fechacreacionSoporte",nullable = false)
    private LocalDate fechacreacionSoporte;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User usuario;


    public TicketReporte() {
    }

    public TicketReporte(int idSoporte, String tipoSoporte, String asuntoSoporte, String descripcionSoporte, String estadoSoporte, LocalDate fechacreacionSoporte, User usuario) {
        this.idSoporte = idSoporte;
        this.tipoSoporte = tipoSoporte;
        this.asuntoSoporte = asuntoSoporte;
        this.descripcionSoporte = descripcionSoporte;
        this.estadoSoporte = estadoSoporte;
        this.fechacreacionSoporte = fechacreacionSoporte;
        this.usuario = usuario;
    }

    public int getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(int idSoporte) {
        this.idSoporte = idSoporte;
    }

    public String getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(String tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    public String getAsuntoSoporte() {
        return asuntoSoporte;
    }

    public void setAsuntoSoporte(String asuntoSoporte) {
        this.asuntoSoporte = asuntoSoporte;
    }

    public String getDescripcionSoporte() {
        return descripcionSoporte;
    }

    public void setDescripcionSoporte(String descripcionSoporte) {
        this.descripcionSoporte = descripcionSoporte;
    }

    public String getEstadoSoporte() {
        return estadoSoporte;
    }

    public void setEstadoSoporte(String estadoSoporte) {
        this.estadoSoporte = estadoSoporte;
    }

    public LocalDate getFechacreacionSoporte() {
        return fechacreacionSoporte;
    }

    public void setFechacreacionSoporte(LocalDate fechacreacionSoporte) {
        this.fechacreacionSoporte = fechacreacionSoporte;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
