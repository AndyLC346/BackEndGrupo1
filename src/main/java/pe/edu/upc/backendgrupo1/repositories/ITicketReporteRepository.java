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
    @Query(value = "SELECT tr.id_soporte AS idTicket,tr.asunto_soporte AS asunto, tr.estado_soporte AS estado,u.username AS creadoPor, COUNT(rs.id_respuesta_soporte) AS totalRespuestas\n" +
            "FROM ticket_reporte tr JOIN users u ON tr.id_user = u.id\n" +
            "LEFT JOIN respuesta_soporte rs ON tr.id_soporte = rs.id_soporte\n" +
            "GROUP BY tr.id_soporte, tr.asunto_soporte, tr.estado_soporte, u.username\n" +
            "ORDER BY tr.fechacreacion_soporte DESC;",nativeQuery = true)
    List<String[]>cantidadRespuestaPorTicket();
}
