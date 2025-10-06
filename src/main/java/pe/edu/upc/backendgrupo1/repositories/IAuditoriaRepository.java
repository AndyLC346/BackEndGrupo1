package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Auditoria;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAuditoriaRepository extends JpaRepository<Auditoria, Integer> {
    @Query(value = "SELECT * From auditoria\n" +
            "WHERE fecha_auditoria BETWEEN :fechaInicio  AND :fechaFin \n" +
            "AND :tipoAuditoria\n" +
            " ORDER BY fecha_auditoria DESC", nativeQuery = true)
    List<Auditoria> buscarAuditoriasPorFechaYTipo(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("tipoAuditoria") String tipoAuditoria
    );
}
