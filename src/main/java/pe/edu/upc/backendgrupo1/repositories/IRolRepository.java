package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.backendgrupo1.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol, Long> {
}
