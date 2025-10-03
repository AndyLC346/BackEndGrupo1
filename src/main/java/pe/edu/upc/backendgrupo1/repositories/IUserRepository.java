package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
    Users findOneByUsername(String username);


}
