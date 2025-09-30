package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Cuenta;
import pe.edu.upc.backendgrupo1.repositories.ICuentaRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.ICuentaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CuentaServiceImplement implements ICuentaService {

    @Autowired
    private ICuentaRepository cR;

    @Override
    public List<Cuenta> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Cuenta cuenta) {
        cR.save(cuenta);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Cuenta cuenta) {
        cR.save(cuenta);
    }

    @Override
    public Cuenta listId(int id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public List<Object[]> buscarCuentasFiltradas(int idUser, String nombre, LocalDate fecha) {
        return cR.buscarCuentasFiltradas(idUser, nombre, fecha);
    }

}
