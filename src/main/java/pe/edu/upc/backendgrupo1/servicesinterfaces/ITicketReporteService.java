package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.TicketReporte;
import java.util.List;

public interface ITicketReporteService {
    List<TicketReporte> list();
    void insert(TicketReporte t);
    TicketReporte listId(int id);
    void delete(int id);
    void update(TicketReporte t);
    List<String[]> TotalTicketsPorUsuario();
}
