package pe.edu.upc.backendgrupo1.servicesinterfaces;

import pe.edu.upc.backendgrupo1.entities.Users;

import java.util.List;

public interface IUserService {

    public List<Users> list();
    public void insert(Users user);
    public void delete(long id);
    public void update(Users user);
    public Users listId(long id);
    public List<Object[]> TotalArchivosXUsers();
}
