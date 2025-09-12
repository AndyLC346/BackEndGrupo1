package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.LogAcceso;
import java.util.List;

public interface ILogAccesoService {
    List<LogAcceso> list();
    void insert(LogAcceso la);
    void update(LogAcceso la);
    void delete(Long id);
    LogAcceso searchId(Long id);
}
