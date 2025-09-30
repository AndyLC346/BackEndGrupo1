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
    @Query(value = "SELECT id_cuenta, servicio_cuenta, nombre_cuenta, estado_cuenta, fecharegistro_cuenta, id_user " +
            "FROM cuentas " +
            "WHERE estado_cuenta = 'ACTIVO' " +
            "AND id_user = :idUser " +
            "AND fecharegistro_cuenta >= :fecha",
            nativeQuery = true)
    List<Object[]> buscarCuentasPorUsuarioYFecha(@Param("idUser") int idUser,
                                                 @Param("fecha") LocalDate fecha);
}
