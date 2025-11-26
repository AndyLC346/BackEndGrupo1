package pe.edu.upc.backendgrupo1.dtos;


import pe.edu.upc.backendgrupo1.entities.Users;

public class RolDTO {

    private Long id;
    private String rol;
    private Users usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
