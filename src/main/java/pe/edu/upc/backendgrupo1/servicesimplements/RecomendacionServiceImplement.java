package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Recomendacion;
import pe.edu.upc.backendgrupo1.repositories.IRecomendacionRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRecomendacionService;

import java.util.List;

@Service
public class RecomendacionServiceImplement implements IRecomendacionService {
    @Autowired
    private IRecomendacionRepository reR;

    @Override
    public List<Recomendacion> list() {
        return reR.findAll();
    }

    @Override
    public void insert(Recomendacion recomendacion) {
        reR.save(recomendacion);
    }

    @Override
    public void delete(int id) {
        reR.deleteById(id);
    }

    @Override
    public void update(Recomendacion recomendacion) {
        reR.save(recomendacion);
    }

    @Override
    public Recomendacion listId(int id) {
        return reR.findById(id).orElse(null);
    }

    @Override
    public List<Recomendacion> buscarRecomendacionesPorFiltros(Integer idUsuario, String categoria, String titulo) {
        return reR.buscarRecomendacionesPorFiltros(idUsuario, categoria, titulo);
    }
}
