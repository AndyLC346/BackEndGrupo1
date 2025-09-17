package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="RespuestaSoporte")
public class RespuestaSoporte {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idRespuestaSoporte;

    @Column(name="tipoSoporte",nullable = false,length = 200)
    private String mensajeRespuestaSoporte;

    @Column(name="fechacreacionSoporte",nullable = false)
    private LocalDate fechacierreRespuestaSoporte;

    @ManyToOne
    @JoinColumn(name="idSoporte")
    private TicketReporte  treporte;

    public RespuestaSoporte() {
    }

    public RespuestaSoporte(int idRespuestaSoporte, String mensajeRespuestaSoporte, LocalDate fechacierreRespuestaSoporte, TicketReporte treporte) {
        this.idRespuestaSoporte = idRespuestaSoporte;
        this.mensajeRespuestaSoporte = mensajeRespuestaSoporte;
        this.fechacierreRespuestaSoporte = fechacierreRespuestaSoporte;
        this.treporte = treporte;
    }

    public int getIdRespuestaSoporte() {
        return idRespuestaSoporte;
    }

    public void setIdRespuestaSoporte(int idRespuestaSoporte) {
        this.idRespuestaSoporte = idRespuestaSoporte;
    }

    public String getMensajeRespuestaSoporte() {
        return mensajeRespuestaSoporte;
    }

    public void setMensajeRespuestaSoporte(String mensajeRespuestaSoporte) {
        this.mensajeRespuestaSoporte = mensajeRespuestaSoporte;
    }

    public LocalDate getFechacierreRespuestaSoporte() {
        return fechacierreRespuestaSoporte;
    }

    public void setFechacierreRespuestaSoporte(LocalDate fechacierreRespuestaSoporte) {
        this.fechacierreRespuestaSoporte = fechacierreRespuestaSoporte;
    }

    public TicketReporte getTreporte() {
        return treporte;
    }

    public void setTreporte(TicketReporte treporte) {
        this.treporte = treporte;
    }
}
