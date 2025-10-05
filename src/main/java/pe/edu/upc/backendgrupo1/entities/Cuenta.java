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
    private boolean estadoCuenta;

    @Column(name = "fecharegistroCuenta")
    private LocalDate fecharegistroCuenta;

    @ManyToOne
    @JoinColumn(name="idUser")
    private Users usuario;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String servicioCuenta, String nombreCuenta, boolean estadoCuenta, LocalDate fecharegistroCuenta, Users usuario) {
        this.idCuenta = idCuenta;
        this.servicioCuenta = servicioCuenta;
        this.nombreCuenta = nombreCuenta;
        this.estadoCuenta = estadoCuenta;
        this.fecharegistroCuenta = fecharegistroCuenta;
        this.usuario = usuario;
    }

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
