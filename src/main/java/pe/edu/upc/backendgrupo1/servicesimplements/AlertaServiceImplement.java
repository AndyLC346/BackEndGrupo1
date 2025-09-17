package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Alerta;
import pe.edu.upc.backendgrupo1.repositories.IAlertaRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IAlertaService;

import java.util.List;

@Service
public class AlertaServiceImplement implements IAlertaService {

    @Autowired
    private IAlertaRepository aR;

    @Override
    public List<Alerta> list() {
        return aR.findAll();
    }

    @Override
    public void insert(Alerta alerta) {
        aR.save(alerta);
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public void update(Alerta alerta) {
        aR.save(alerta);
    }

    @Override
    public Alerta listId(int id) {
        return aR.findById(id).orElse(null);
    }
}
