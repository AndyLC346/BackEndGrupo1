package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.LogAcceso;
import java.util.List;

public interface ILogAccesoService {
    public List<LogAcceso> list();
    public void insert(LogAcceso la);
    public void update(LogAcceso la);
    public void delete(Long id);
    public LogAcceso searchId(Long id);
}
