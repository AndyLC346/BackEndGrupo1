package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.User;

import java.time.LocalDate;

public class CuentaDTO {

    private int idCuenta;
    private String servicioCuenta;
    private String nombreCuenta;
    private String estadoCuenta;
    private LocalDate fecharegistroCuenta;
    private User usuario;

    // Getters y Setters

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getServicioCuenta() {
        return servicioCuenta;
    }

    public void setServicioCuenta(String servicioCuenta) {
        this.servicioCuenta = servicioCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public LocalDate getFecharegistroCuenta() {
        return fecharegistroCuenta;
    }

    public void setFecharegistroCuenta(LocalDate fecharegistroCuenta) {
        this.fecharegistroCuenta = fecharegistroCuenta;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
