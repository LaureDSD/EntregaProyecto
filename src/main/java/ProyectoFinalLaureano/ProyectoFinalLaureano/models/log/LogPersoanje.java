package ProyectoFinalLaureano.ProyectoFinalLaureano.models.log;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "registro_caza")
public class LogPersoanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_caza_id")
    private Long registroCazaId;

    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false)
    private Personaje personaje;

    @ManyToOne
    @JoinColumn(name = "monstruo_id", nullable = false)
    private Monstruo monstruo;

    @Column(name = "fecha_caza", nullable = false)
    private LocalDateTime fechaCaza = LocalDateTime.now();

    @Column(name = "almas_obtenidas", nullable = false)
    private Integer almasObtenidas;

    @Column(name = "experiencia_obtenida", nullable = false)
    private Integer experienciaObtenida;
}
