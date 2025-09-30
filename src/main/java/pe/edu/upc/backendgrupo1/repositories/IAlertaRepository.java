package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Alerta;

import java.util.List;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
    @Query(value = "SELECT id_user, COUNT(*) as alertas_pendientes\n" +
            "FROM alertas\n" +
            "WHERE :nombre = FALSE \n" +
            "GROUP BY id_user", nativeQuery = true)
    List<Alerta> buscar(@Param("nombre") String nombre);
}
