package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.backendgrupo1.entities.TicketReporte;

public interface ITicketReporteRepository extends JpaRepository <TicketReporte, Integer> {
}
