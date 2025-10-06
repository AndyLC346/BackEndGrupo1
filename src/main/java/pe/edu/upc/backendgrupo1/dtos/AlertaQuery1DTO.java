package pe.edu.upc.backendgrupo1.dtos;



public class AlertaQuery1DTO {
    private int idUsuario;
    private int cantidadAlertasPendientes;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidadAlertasPendientes() {
        return cantidadAlertasPendientes;
    }

    public void setCantidadAlertasPendientes(int cantidadAlertasPendientes) {
        this.cantidadAlertasPendientes = cantidadAlertasPendientes;
    }
}
