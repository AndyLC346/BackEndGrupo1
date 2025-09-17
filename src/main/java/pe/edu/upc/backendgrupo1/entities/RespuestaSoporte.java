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
    @Column(name="idUsuario",nullable=false)
    private int idSoporte;

    public RespuestaSoporte(int idRespuestaSoporte, String mensajeRespuestaSoporte, LocalDate fechacierreRespuestaSoporte, int idSoporte) {
        this.idRespuestaSoporte = idRespuestaSoporte;
        this.mensajeRespuestaSoporte = mensajeRespuestaSoporte;
        this.fechacierreRespuestaSoporte = fechacierreRespuestaSoporte;
        this.idSoporte = idSoporte;
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

    public int getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(int idSoporte) {
        this.idSoporte = idSoporte;
    }
}
