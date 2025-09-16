package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuenta;

    @Column(name = "servicioCuenta", length = 40)
    private String servicioCuenta;

    @Column(name = "nombreCuenta", length = 20)
    private String nombreCuenta;

    @Column(name = "estadoCuenta", length = 20)
    private String estadoCuenta;

    @Column(name = "fecharegistroCuenta")
    private LocalDate fecharegistroCuenta;

    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
