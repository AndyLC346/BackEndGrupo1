package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Recomendacion;

import java.util.List;

@Repository
public interface IRecomendacionRepository extends JpaRepository<Recomendacion, Integer> {
    @Query("SELECT r FROM Recomendacion r " +
            "WHERE (:idUsuario IS NULL OR r.usuario.idUser = :idUsuario) " +
            "AND (:categoria IS NULL OR LOWER(r.categoriaRecomendacion) LIKE LOWER(CONCAT('%', :categoria, '%'))) " +
            "AND (:titulo IS NULL OR LOWER(r.tituloRecomendacion) LIKE LOWER(CONCAT('%', :titulo, '%')))")
    List<Recomendacion> buscarRecomendacionesPorFiltros(
            @Param("idUsuario") Integer idUsuario,
            @Param("categoria") String categoria,
            @Param("titulo") String titulo
    );
}
