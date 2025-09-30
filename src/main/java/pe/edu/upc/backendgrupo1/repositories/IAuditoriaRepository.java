package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Auditoria;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IAuditoriaRepository extends JpaRepository<Auditoria, Integer> {
    @Query(value = "SELECT id_auditoria, fecha_auditoria, tipo_auditoria, descripcion, id_user " +
            "FROM auditoria " +
            "WHERE fecha_auditoria BETWEEN :fechaInicio AND :fechaFin " +
            "AND (:tipoAuditoria IS NULL OR tipo_auditoria = :tipoAuditoria) " +
            "ORDER BY fecha_auditoria DESC", nativeQuery = true)
    List<Object[]> buscarAuditoriasPorFechaYTipo(
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin,
            @Param("tipoAuditoria") String tipoAuditoria
    );
}
