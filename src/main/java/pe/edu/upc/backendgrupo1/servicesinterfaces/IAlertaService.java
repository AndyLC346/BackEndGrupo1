package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.Alerta;

import java.util.List;

public interface IAlertaService {
    public List<Alerta> list();
    public void insert(Alerta alerta);
    public void delete(int id);
    public void update(Alerta alerta);
    public Alerta listId(int id);
}
