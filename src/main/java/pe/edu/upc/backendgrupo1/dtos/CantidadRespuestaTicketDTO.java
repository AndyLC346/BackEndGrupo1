package pe.edu.upc.backendgrupo1.dtos;

public class CantidadRespuestaTicketDTO {
    private int idTicket;
    private String Asunto;
    private String Estado;
    private String Creador;
    private int IdRespuestaSoporte;

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String asunto) {
        Asunto = asunto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getCreador() {
        return Creador;
    }

    public void setCreador(String creador) {
        Creador = creador;
    }

    public int getIdRespuestaSoporte() {
        return IdRespuestaSoporte;
    }

    public void setIdRespuestaSoporte(int idRespuestaSoporte) {
        IdRespuestaSoporte = idRespuestaSoporte;
    }
}
