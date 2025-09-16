package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.Cuenta;

import java.util.List;

public interface ICuentaService {
    List<Cuenta> list();
    void insert(Cuenta cuenta);
    void delete(int id);
    void update(Cuenta cuenta);
    Cuenta listId(int id);
}
