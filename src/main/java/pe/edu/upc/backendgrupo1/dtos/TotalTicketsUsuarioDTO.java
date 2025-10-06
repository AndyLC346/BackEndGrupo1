package pe.edu.upc.backendgrupo1.dtos;

public class TotalTicketsUsuarioDTO {
    private int idUusuario;
    private String Username;
    private int Total_Tickets;

    public int getIdUusuario() {
        return idUusuario;
    }

    public void setIdUusuario(int idUusuario) {
        this.idUusuario = idUusuario;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getTotal_Tickets() {
        return Total_Tickets;
    }

    public void setTotal_Tickets(int total_Tickets) {
        Total_Tickets = total_Tickets;
    }
}
