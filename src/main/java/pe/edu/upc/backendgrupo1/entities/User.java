package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name="username", nullable=false, length=30, unique = true)
    private String username;

    @Column(name="password", nullable=false, length=100)
    private String password;

    @Column(name="enabled", nullable=false)
    private boolean enabled;

    @Column(name="nombres", nullable=false, length=50)
    private String nombres;

    @Column(name="apellidos", nullable=false, length=50)
    private String apellidos;

    @Column(name="emailUser", nullable=false, length=50)
    private String emailUser;

    @Column(name="telefonoUser", nullable=false, length=9)
    private String telefonoUser;

    public User() {
    }

    public User(int idUser, String username, String password, boolean enabled, String nombres, String apellidos, String emailUser, String telefonoUser) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.emailUser = emailUser;
        this.telefonoUser = telefonoUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getTelefonoUser() {
        return telefonoUser;
    }

    public void setTelefonoUser(String telefonoUser) {
        this.telefonoUser = telefonoUser;
    }
}
