package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name="username", nullable=false, length=30, unique = true)
    private String username;

    @Column(name="password", nullable=false, length=100)
    private String password;

    @Column(name="enabled", nullable=false)
    private Boolean enabled;

    @Column(name="nombres", nullable=false, length=50)
    private String nombres;

    @Column(name="apellidos", nullable=false, length=50)
    private String apellidos;

    @Column(name="emailUser", nullable=false, length=50)
    private String emailUser;

    @Column(name="telefonoUser", nullable=false, length=9)
    private String telefonoUser;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    public Users() {
    }

    public Users(Long idUser, String username, String password, Boolean enabled, String nombres, String apellidos, String emailUser, String telefonoUser, List<Role> roles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.emailUser = emailUser;
        this.telefonoUser = telefonoUser;
        this.roles = roles;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
