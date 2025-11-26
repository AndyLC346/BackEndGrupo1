package pe.edu.upc.backendgrupo1.servicesinterfaces;


import pe.edu.upc.backendgrupo1.entities.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> list();
    public void insert(Role r);
    public Role listId(long id);
    public void delete(long id);
    public void update(Role r);
}
