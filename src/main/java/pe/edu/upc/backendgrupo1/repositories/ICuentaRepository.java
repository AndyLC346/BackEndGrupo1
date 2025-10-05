package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.Cuenta;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Integer> {
    @Query(value = "SELECT * " +
            "FROM cuentas " +
            "WHERE estado_cuenta = TRUE " +
            "AND id_user = :idUser " +
            "AND fecharegistro_cuenta >= :fecha",
            nativeQuery = true)
    List<Cuenta> buscarCuentasPorUsuarioYFecha(@Param("idUser") int idUser,
                                                 @Param("fecha") LocalDate fecha);
}
