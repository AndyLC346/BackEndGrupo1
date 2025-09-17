package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.RespuestaSoporte;
import pe.edu.upc.backendgrupo1.entities.TicketReporte;
import pe.edu.upc.backendgrupo1.repositories.IRespuestaSoporteRepository;
import pe.edu.upc.backendgrupo1.repositories.ITicketReporteRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRespuestaSoporteService;

import java.util.List;

@Service
public class RespuestaSoporteImplement implements IRespuestaSoporteService {
    @Autowired
    private IRespuestaSoporteRepository rsR;
    @Override
    public List<RespuestaSoporte> list(){return rsR.findAll();}
    @Override
    public void insert(RespuestaSoporte respuestaSoporte){rsR.save(respuestaSoporte);}
    @Override
    public RespuestaSoporte listId(int id) {return rsR.findById(id).orElse(null);}
    @Override
    public void delete(int id) {rsR.deleteById(id);}
    @Override
    public void update(RespuestaSoporte rs) {rsR.save(rs);}
}
