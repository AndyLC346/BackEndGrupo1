package pe.edu.upc.backendgrupo1.dtos;

public class TotalArchivosXUsersDTO {

    private String username;
    private Long totalArchivos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTotalArchivos() {
        return totalArchivos;
    }

    public void setTotalArchivos(Long totalArchivos) {
        this.totalArchivos = totalArchivos;
    }
}
