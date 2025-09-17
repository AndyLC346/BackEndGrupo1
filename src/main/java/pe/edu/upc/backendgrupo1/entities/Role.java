package pe.edu.upc.backendgrupo1.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "roles",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "rol"})}
)
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(length = 50, nullable = false)
    private String rol;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
