package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.Auditoria;

import java.time.LocalDateTime;
import java.util.List;

public interface IAuditoriaService {
    List<Auditoria> list();
    void insert(Auditoria auditoria);
    void delete(int id);
    void update(Auditoria auditoria);
    Auditoria listId(int id);
    List<Object[]> buscarAuditoriasPorFechaYTipo(LocalDateTime fechaInicio,
                                                 LocalDateTime fechaFin,
                                                 String tipoAuditoria);
}
