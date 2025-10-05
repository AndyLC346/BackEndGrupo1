package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Recomendacion;

import java.util.List;

@Repository
public interface IRecomendacionRepository extends JpaRepository<Recomendacion, Integer> {
    @Query(value = "SELECT \n" +
            "    u.username,\n" +
            "    r.categoria_recomendacion,\n" +
            "    COUNT(r.id_recomendacion) as cantidad\n" +
            "FROM Recomendaciones r\n" +
            "INNER JOIN users u ON r.id_usuario = u.id_user\n" +
            "WHERE r.categoria_recomendacion = :categoria \n" +
            "GROUP BY u.username, r.categoria_recomendacion\n" +
            "ORDER BY cantidad DESC;",nativeQuery = true)
    List<String[]> buscarRecomendacionesporcategoria(@Param("categoria") String categoria);
}
