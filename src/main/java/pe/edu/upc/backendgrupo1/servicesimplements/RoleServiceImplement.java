package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Role;
import pe.edu.upc.backendgrupo1.repositories.IRoleRepository;
import pe.edu.upc.backendgrupo1.repositories.IUserRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public List<Role> list(){return rR.findAll();}

    @Override
    public void insert(Role r){rR.save(r);}

    @Override
    public Role listId(long id) {return rR.findById(id).orElse(null);}

    @Override
    public void delete(long id) {rR.deleteById(id);}

    @Override
    public void update(Role r) {rR.save(r);}
}
