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

    @Query(value = "SELECT * FROM RecursoEducativo \n" +
            "WHERE tipoRecurso = :tipo AND nivelRecurso = :nivel", nativeQuery = true)
    public List<Recurso> buscarRecursoxTipoynivel(@Param("tipo") String tipo, @Param("nivel") String nivel);

    @Query(value = "SELECT u.username,Count(r.id_user) as cantidad_recursos FROM recursoseducativos r inner join users u\n" +
            "   on r.id_user=u.id_user\n" +
            "   Where username = :username\n" +
            "   group by u.username",nativeQuery = true)
    public List<Recurso> buscarRecursoxTipoynivel(@Param("username") String username);



}
