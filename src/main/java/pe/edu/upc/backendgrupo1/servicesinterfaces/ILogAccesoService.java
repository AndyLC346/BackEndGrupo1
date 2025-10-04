package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.LogAcceso;

import java.time.LocalDate;
import java.util.List;

public interface ILogAccesoService {
    public List<LogAcceso> list();
    public void insert(LogAcceso logAcceso);
    public void delete(int id);
    public void update(LogAcceso logAcceso);
    public LogAcceso listId(int id);

    List<Object[]> buscarLogsPorFiltros(Integer idUsuario, LocalDate fecha, String ip);
}
