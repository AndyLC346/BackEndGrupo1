package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.backendgrupo1.entities.RespuestaSoporte;

import java.util.List;

public interface IRespuestaSoporteRepository extends JpaRepository<RespuestaSoporte,Integer> {
}
