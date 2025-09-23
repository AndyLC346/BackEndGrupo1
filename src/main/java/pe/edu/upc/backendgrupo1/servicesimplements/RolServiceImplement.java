package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Rol;
import pe.edu.upc.backendgrupo1.repositories.IRolRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rl;

    @Override
    public List<Rol> list() { return rl.findAll();}

    @Override
    public void insert(Rol rol) {
        rl.save(rol);
    }

    @Override
    public void delete(int id) {
        rl.deleteById(id);
    }

    @Override
    public void update(Rol rol) {
        rl.save(rol);
    }

    @Override
    public Rol listId(int id) {
        return rl.findById(id).orElse(null);
    }
}

