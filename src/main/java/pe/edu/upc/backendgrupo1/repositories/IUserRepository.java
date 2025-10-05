package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.backendgrupo1.dtos.TotalArchivosXUsersDTO;
import pe.edu.upc.backendgrupo1.entities.Users;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
    Users findOneByUsername(String username);

    @Query(value="SELECT u.username, COUNT(a.id_archivos) AS total_archivos\n" +
            "FROM users u\n" +
            "LEFT JOIN archivos a ON u.id = a.id_user\n" +
            "GROUP BY u.username\n" +
            "ORDER BY total_archivos DESC", nativeQuery = true)
    public List<Object[]> TotalArchivosXUsers();


    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
