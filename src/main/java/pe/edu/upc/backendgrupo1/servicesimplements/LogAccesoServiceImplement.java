package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.LogAcceso;
import pe.edu.upc.backendgrupo1.repositories.ILogAccesoRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.ILogAccesoService;

import java.util.List;

@Service
public class LogAccesoServiceImplement implements ILogAccesoService {

    @Autowired
    private ILogAccesoRepository laR;

    @Override
    public List<LogAcceso> list() {
        return laR.findAll();
    }

    @Override
    public void insert(LogAcceso la) {
        laR.save(la);
    }

    @Override
    public void update(LogAcceso la) {
        if (laR.existsById(la.getIdLogAcceso())) {
            laR.save(la);
        } else {
            throw new RuntimeException("El logacceso con el ID " + la.getIdLogAcceso() + " no existe");
        }
    }

    @Override
    public void delete(Long id) {
        laR.deleteById(id);
    }

    @Override
    public LogAcceso searchId(Long id) {
        return laR.findById(id).orElse(null);
    }

}
