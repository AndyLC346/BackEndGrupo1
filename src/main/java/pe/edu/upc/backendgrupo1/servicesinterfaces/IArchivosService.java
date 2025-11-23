package pe.edu.upc.backendgrupo1.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.backendgrupo1.entities.Archivos;

import java.time.LocalDate;
import java.util.List;

public interface IArchivosService {
    public List<Archivos> list();
    public void insert(Archivos archivo);
    public void delete(int id);
    public void update(Archivos archivo);
    public Archivos listId(int id);

    //xd
    List<String[]> listarArchivosPorFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
}
