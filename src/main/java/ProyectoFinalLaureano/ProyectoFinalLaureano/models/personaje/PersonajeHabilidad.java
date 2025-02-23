package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "personaje_habilidad")
@Getter
@Setter
@Schema(description = "Entidad que genera que represenata la relacion entre persoanje y habilidad")
public class PersonajeHabilidad {

    //ID combinado de la relacion@Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personaje_habilidad_id;

    //Nivel de lahabilidad de la habilidad del persoanje
    @Column(name = "nivel_habilidad", nullable = false)
    @Schema(description = "Nivelde la habilidad asiganada", example = "10")
    private int nivelHabilidad;


    // Relación con la tabla personaje
    @ManyToOne()
    @JoinColumn(name = "personaje_id")
    private Personaje personaje;

    // Relación con la tabla habilidad
    @ManyToOne()
    @JoinColumn(name = "habilidad_id")
    private Habilidad habilidad;
}