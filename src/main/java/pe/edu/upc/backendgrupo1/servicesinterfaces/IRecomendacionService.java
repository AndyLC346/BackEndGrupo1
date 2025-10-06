package pe.edu.upc.backendgrupo1.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.backendgrupo1.entities.Recomendacion;
import java.util.List;

public interface IRecomendacionService {
    public List<Recomendacion> list();
    public void insert(Recomendacion recomendacion);
    public void delete(int id);
    public void update(Recomendacion recomendacion);
    public Recomendacion listId(int id);

    List<String[]> buscarRecomendacionesporcategoria( String categoria);
}
