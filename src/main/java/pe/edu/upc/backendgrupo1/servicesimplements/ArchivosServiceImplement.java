package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Archivos;
import pe.edu.upc.backendgrupo1.repositories.IArchivosRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IArchivosService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArchivosServiceImplement implements IArchivosService {

    @Autowired
    private IArchivosRepository aR;

    @Override
    public List<Archivos> list() {
        return aR.findAll();
    }

    @Override
    public void insert(Archivos archivo) {
        aR.save(archivo);
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public void update(Archivos archivo) {
        aR.save(archivo);
    }

    @Override
    public Archivos listId(int id) {
        return aR.findById(id).orElse(null);
    }

    @Override
    public List<String[]> listarArchivosPorFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return aR.listarArchivosPorFechas(fechaInicio, fechaFin);
    }


}
