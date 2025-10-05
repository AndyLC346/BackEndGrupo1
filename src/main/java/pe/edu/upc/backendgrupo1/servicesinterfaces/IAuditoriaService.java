package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.Auditoria;
import pe.edu.upc.backendgrupo1.entities.Cuenta;

import java.util.List;

public interface IAuditoriaService {
    List<Auditoria> list();
    void insert(Auditoria auditoria);
    void delete(int id);
    void update(Auditoria auditoria);
    Auditoria listId(int id);
}
