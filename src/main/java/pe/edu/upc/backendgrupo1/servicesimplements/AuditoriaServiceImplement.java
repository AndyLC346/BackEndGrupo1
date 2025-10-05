package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Auditoria;
import pe.edu.upc.backendgrupo1.repositories.IAuditoriaRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IAuditoriaService;

import java.util.List;

@Service
public class AuditoriaServiceImplement implements IAuditoriaService {

    @Autowired
    private IAuditoriaRepository aR;

    @Override
    public List<Auditoria> list() {
        return aR.findAll();
    }

    @Override
    public void insert(Auditoria auditoria) {
        aR.save(auditoria);
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public void update(Auditoria auditoria) {
        aR.save(auditoria);
    }

}
