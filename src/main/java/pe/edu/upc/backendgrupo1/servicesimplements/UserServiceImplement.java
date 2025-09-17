package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.User;
import pe.edu.upc.backendgrupo1.repositories.IUserRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {

    @Autowired
    private IUserRepository uR;

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void insert(User user) {
        uR.save(user);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public void update(User user) {
        if (uR.existsById(user.getIdUser())) {
            uR.save(user);
        } else {
            throw new RuntimeException("El usuario con el ID " + user.getIdUser() + " no existe");
        }
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(null);
    }
}
