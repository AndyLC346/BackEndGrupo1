package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.entities.RespuestaSoporte;

import java.util.List;

@Repository
public interface IRespuestaSoporteRepository extends JpaRepository<RespuestaSoporte,Integer> {
}
