package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.LogAcceso;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILogAccesoRepository extends JpaRepository<LogAcceso, Integer> {
    @Query(value = "SELECT l.id_log_acceso, l.fecha_acceso, l.ip_acceso, l.navegador_acceso, " +
            "l.sistemaoperativo_accesso, l.id_usuario " +
            "FROM logaccesos l " +
            "WHERE (:idUsuario IS NULL OR l.id_usuario = :idUsuario) " +
            "AND (:fecha IS NULL OR l.fecha_acceso = :fecha) " +
            "AND (:ip IS NULL OR LOWER(l.ip_acceso) LIKE LOWER(CONCAT('%', :ip, '%')))",
            nativeQuery = true)
    List<Object[]> buscarLogsPorFiltros(@Param("idUsuario") Integer idUsuario,
                                        @Param("fecha") LocalDate fecha,
                                        @Param("ip") String ip);
}
