package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.Archivos;

import java.util.List;

public interface IArchivosService {
    public List<Archivos> list();
    public void insert(Archivos archivo);
    public void delete(int id);
    public void update(Archivos archivo);
    public Archivos listId(int id);
}
