package pe.edu.upc.backendgrupo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendgrupo1.dtos.TotalTicketsUsuarioDTO;
import pe.edu.upc.backendgrupo1.entities.TicketReporte;

import java.util.List;

@Repository
public interface ITicketReporteRepository extends JpaRepository <TicketReporte, Integer> {
    @Query(value="select u.id, u.username, count(tr.id_soporte) as total_tickets\n" +
            "from users u left join ticket_reporte tr on u.id = tr.id_user\n" +
            "group by u.id, u.username\n" +
            "order by total_tickets desc;",nativeQuery=true)
    List<String[]> contarTicketsPorUsuario();
}
