package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.LogAcceso;
import pe.edu.upc.backendgrupo1.repositories.ILogAccesoRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.ILogAccesoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class LogAccesoServiceImplement implements ILogAccesoService {

    @Autowired
    private ILogAccesoRepository loR;

    @Override
    public List<LogAcceso> list() {
        return loR.findAll();
    }

    @Override
    public void insert(LogAcceso logAcceso) {
        loR.save(logAcceso);
    }

    @Override
    public void delete(int id) {
        loR.deleteById(id);
    }

    @Override
    public void update(LogAcceso logAcceso) {
        loR.save(logAcceso);
    }

    @Override
    public LogAcceso listId(int id) {
        return loR.findById(id).orElse(null) ;
    }


    @Override
    public List<LogAcceso> buscarLogsPorusuarioyrangofechas(int idusuario, LocalDate fechainicial, LocalDate fechafinal) {
        return loR.buscarLogsPorusuarioyrangofechas(idusuario, fechainicial, fechafinal);
    }

}
