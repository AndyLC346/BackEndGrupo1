package pe.edu.upc.backendgrupo1.dtos;

import pe.edu.upc.backendgrupo1.entities.Users;

import java.time.LocalDate;

public class CuentaDTO {

    private int idCuenta;
    private String servicioCuenta;
    private String nombreCuenta;
    private boolean estadoCuenta;
    private LocalDate fecharegistroCuenta;
    private Users usuario;

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

    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public LocalDate getFecharegistroCuenta() {
        return fecharegistroCuenta;
    }

    public void setFecharegistroCuenta(LocalDate fecharegistroCuenta) {
        this.fecharegistroCuenta = fecharegistroCuenta;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
