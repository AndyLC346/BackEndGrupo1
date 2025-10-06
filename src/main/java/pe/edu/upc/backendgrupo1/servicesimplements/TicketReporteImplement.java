package pe.edu.upc.backendgrupo1.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.TicketReporte;
import pe.edu.upc.backendgrupo1.repositories.ITicketReporteRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.ITicketReporteService;


import java.util.List;

@Service
public class TicketReporteImplement implements ITicketReporteService {
    @Autowired
    private ITicketReporteRepository tR;
    @Override
    public List<TicketReporte> list(){return tR.findAll();}
    @Override
    public void insert(TicketReporte ticketReporte){tR.save(ticketReporte);}
    @Override
    public TicketReporte listId(int id) {return tR.findById(id).orElse(null);}
    @Override
    public void delete(int id) {tR.deleteById(id);}
    @Override
    public void update(TicketReporte t) {tR.save(t);}
    @Override
    public List<String[]> TotalTicketsPorUsuario() { return tR.contarTicketsPorUsuario();}
    @Override
    public List<String[]> CantidadRespuestaTicket() { return tR.cantidadRespuestaPorTicket();}
    @Override
    public List<TicketReporte> listEstado(String estadoSoporte){return tR.findByEstadoSoporte(estadoSoporte);}
    @Override
    public List<TicketReporte> listTipo(String tipoSoporte) {return tR.findByTipoSoporte(tipoSoporte);}
}
