package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Archivos;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IArchivosRepository extends JpaRepository<Archivos, Integer> {

    @Query(value="SELECT a.nombre_archivo, a.tipo_archivo, a.fecha_archivo, u.username \n" +
            "            FROM archivos a \n" +
            "            JOIN users u ON a.user_id = u.id \n" +
            "            WHERE a.fecha_archivo BETWEEN :fechaInicio AND :fechaFin \n" +
            "            ORDER BY a.fecha_archivo ASC", nativeQuery = true)
    List<String[]> listarArchivosPorFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

}
