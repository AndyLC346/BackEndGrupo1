package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.User;

import java.util.List;

public interface IUserService {
    //validar merge
    public List<User> list();
    public void insert(User user);
    public void delete(int id);
    public void update(User user);
    public User listId(int id);
}
