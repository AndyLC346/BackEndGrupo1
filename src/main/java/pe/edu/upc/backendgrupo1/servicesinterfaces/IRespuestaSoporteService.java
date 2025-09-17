package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.RespuestaSoporte;

import java.util.Collection;
import java.util.List;

public interface IRespuestaSoporteService {
    List<RespuestaSoporte> list();
    void insert(RespuestaSoporte a);
    RespuestaSoporte listId(int id);
    void delete(int id);
    void update(RespuestaSoporte rs);
}
