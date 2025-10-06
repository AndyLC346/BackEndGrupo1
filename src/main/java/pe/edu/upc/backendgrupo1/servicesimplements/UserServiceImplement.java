package pe.edu.upc.backendgrupo1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendgrupo1.entities.Users;
import pe.edu.upc.backendgrupo1.repositories.IUserRepository;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IUserService;
import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Users user) {
        uR.save(user);
    }

    @Override
    public void delete(long id) {
        uR.deleteById(id);
    }

    @Override
    public void update(Users user) {uR.save(user);}

    @Override
    public Users listId(long id) { return uR.findById(id).orElse(null); }

    @Override
    public List<Object[]> TotalArchivosXUsers() {
        return uR.TotalArchivosXUsers();
    }
}
