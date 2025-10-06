package pe.edu.upc.backendgrupo1.servicesinterfaces;


import pe.edu.upc.backendgrupo1.entities.Recurso;

import java.util.List;

public interface IRecursoEducativoService {

    public List<Recurso> list();
    public void insert(Recurso recurso);
    public void delete(int id);
    public void update(Recurso recurso);
    public Recurso listId(int id);
    public List<Recurso> buscarRecursoxTipoynivel( String tipo,String nivel);
    public List<String[]> cantidadRecursoxusername( String username);
}
