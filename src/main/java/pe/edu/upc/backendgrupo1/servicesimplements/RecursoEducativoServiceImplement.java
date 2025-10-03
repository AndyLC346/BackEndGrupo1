package pe.edu.upc.backendgrupo1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Recurso;
import pe.edu.upc.backendgrupo1.repositories.IRecursoEducativoRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRecursoEducativoService;
import java.util.List;

@Service
public class RecursoEducativoServiceImplement implements IRecursoEducativoService {
    //
    @Autowired
    private IRecursoEducativoRepository rR;

    @Override
    public List<Recurso> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Recurso recurso) {
        rR.save(recurso);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Recurso recurso) {
        rR.save(recurso);
    }

    @Override
    public Recurso listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public List<Recurso> buscarRecursoxTipoynivel(String tipo, String nivel) {return rR.buscarRecursoxTipoynivel(tipo,nivel);}
}
