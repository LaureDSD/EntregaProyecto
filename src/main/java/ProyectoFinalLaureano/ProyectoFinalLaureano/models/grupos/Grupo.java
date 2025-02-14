package ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "grupos")
@Schema(description = "Entidad que representa un grupo")
@Getter
@Setter
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de grupo", example = "1")
    private Long grupo_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del grupo", example = "Sacred")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del grupo", example = "Grupo de caza")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_Grupo", nullable = false)
    @Schema(description = "Tipo de grupo y limitador de integrantes", example = "enemigo")
    private TipoGrupo grupo;

    //Grupo
    @OneToOne
    @JoinColumn(name = "lider_grupo")
    @Schema(description = "Lider del grupo")
    private Personaje lider;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Personajes asociados a este grupo")
    private List<Personaje> persoanjes;

}