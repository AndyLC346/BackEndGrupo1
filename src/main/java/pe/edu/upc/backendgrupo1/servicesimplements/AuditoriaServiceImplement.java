package pe.edu.upc.backendgrupo1.servicesimplements;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Auditoria;
import pe.edu.upc.backendgrupo1.repositories.IAuditoriaRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IAuditoriaService;

import java.time.LocalDate;
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

    @Override
    public Auditoria listId(int id) {
        return aR.findById(id).orElse(null) ;
    }

    @Override
    public List<Auditoria> buscarAuditoriasPorFechaYTipo(LocalDate fechaInicio, LocalDate fechaFin, String tipoAuditoria) {
        return aR.buscarAuditoriasPorFechaYTipo(fechaInicio, fechaFin, tipoAuditoria);
    }


}
