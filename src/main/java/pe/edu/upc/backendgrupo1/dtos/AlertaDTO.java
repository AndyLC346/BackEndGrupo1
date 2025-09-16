package pe.edu.upc.backendgrupo1.dtos;

import java.time.LocalDate;

public class AlertaDTO {

    private int alertaid;
    private String tipo;
    private String mensaje;
    private boolean estado;
    private LocalDate fechagenerada;


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
}
