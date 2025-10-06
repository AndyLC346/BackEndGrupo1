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
    @Query(value = "SELECT * FROM logaccesos \n" +
            "WHERE id_user = :idusuario AND fecha_acceso BETWEEN :fechainicial AND :fechafinal",nativeQuery = true)
    List<LogAcceso> buscarLogsPorusuarioyrangofechas(@Param("idusuario") int idusuario, @Param("fechainicial") LocalDate fechainicial, @Param("fechafinal") LocalDate fechafinal);
}
