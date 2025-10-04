package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Recurso;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRecursoEducativoRepository extends JpaRepository<Recurso, Integer> {
    //
    @Query(value = "SELECT * FROM RecursoEducativo \n" +
            "WHERE tipoRecurso = :tipo AND nivelRecurso = :nivel", nativeQuery = true)
    public List<Recurso> buscarRecursoxTipoynivel(@Param("tipo") String tipo, @Param("nivel") String nivel);



}
