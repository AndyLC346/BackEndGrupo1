package pe.edu.upc.backendgrupo1.servicesimplement;

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
        LogAcceso existente = laR.findById(la.getIdLogAcceso())
                .orElseThrow(() -> new RuntimeException(
                        "No existe el LogAcceso con id " + la.getIdLogAcceso()));

        existente.setFechaAcceso(la.getFechaAcceso());
        existente.setIp(la.getIp());
        existente.setNavegador(la.getNavegador());
        existente.setSistemaOperativo(la.getSistemaOperativo());

        if (la.getUser() != null && la.getUser().getIdUser() != null) {
            existente.setUser(la.getUser());
        }

        laR.save(existente); // guarda los cambios
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
