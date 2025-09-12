package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "log_acceso")
public class LogAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogAcceso;

    private LocalDate fechaAcceso;

    private String ip;

    private String navegador;

    private String sistemaOperativo;

   /*
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

*/

    
}
