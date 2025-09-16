package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.backendgrupo1.entities.Role;

public interface IRolRepository extends JpaRepository<Role, Long> {
}
