package ProyectoFinalLaureano.ProyectoFinalLaureano.models.log;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


// (Correcto)

@NoArgsConstructor
@Entity
@Table(name = "registro_jugador_monstruo")
@Schema(description = "Entidad que representa los registros de logros del personaje")
@Getter
@Setter
public class LogPersonajeMonstruo {

    //ID  del registro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_id")
    private Long registro_id;

    //Persoanojae registrado
    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false)
    //@Column(name = "personaje_id", nullable = false)
    private Personaje personaje;

    //Monstruo registrado
    @ManyToOne
    @JoinColumn(name = "monstruo_id", nullable = false)
    //@Column(name = "monstruo_id", nullable = false)
    private Monstruo monstruo;

    //Fecha de caza
    @Column(name = "fecha", nullable = false)
    private Date fechaCaza = new Date();

    //Almas recividas
    @Column(name = "almas_obtenidas", nullable = false)
    private Integer almasObtenidas;

    //Dano realizado maximo
    @Column(name = "dano_realizado", nullable = false)
    private Integer danoRealizado;

    //Dano max recivido
    @Column(name = "dano_recibido", nullable = false)
    private Integer danoRecivido;

    //Experiencia recivida
    @Column(name = "experiencia_obtenida", nullable = false)
    private Integer experienciaObtenida;
}
