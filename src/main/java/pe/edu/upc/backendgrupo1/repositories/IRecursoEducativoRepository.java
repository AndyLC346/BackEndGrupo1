package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Recurso;

@Repository
public interface IRecursoEducativoRepository extends JpaRepository<Recurso, Integer> {
}
