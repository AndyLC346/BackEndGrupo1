package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.Recomendacion;
import java.util.List;

public interface IRecomendacionService {
    List<Recomendacion> list();
    void insert(Recomendacion recomendacion);
    void delete(Long id);
    Recomendacion findById(Long id);
}
