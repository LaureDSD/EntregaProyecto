package ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// (Correcto)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grupos")
@Schema(description = "Entidad que representa un grupo en el sistema.")
public class Grupo {

    //ID del grupo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del grupo.", example = "1")
    private Long grupoId;

    //Imagen del; grupo
    @Column(length = 255)
    @Schema(description = "URL de la imagen del logo del grupo.", example = "https://example.com/logo.png")
    private String imagenLogo;

    //Nombre del grupo
    @Column(nullable = false, length = 100)
    @Schema(description = "Nombre del grupo.", example = "Los Valientes")
    private String nombre;

    // Descripcion del grupo
    @Column(columnDefinition = "TEXT")
    @Schema(description = "Descripción del grupo.", example = "Grupo dedicado a explorar mazmorras peligrosas.")
    private String descripcion;

    // Relación Many-to-One con TipoGrupo
    @ManyToOne()
    @JoinColumn(name = "tipo_grupo_id", nullable = false)
    @Schema(description = "Tipo de grupo al que pertenece este grupo.")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private TipoGrupo tipoGrupo;

    // Relación Many-to-One con Personaje (Líder del grupo)
    @ManyToOne()
    @JoinColumn(name = "lider_grupo_id", nullable = false)
    @Schema(description = "Personaje que es el líder del grupo.")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private Personaje lider;

    // Relación One-to-Many con Personaje (Miembros del grupo)
    @OneToMany(mappedBy = "grupo")
    @Schema(description = "Lista de personajes que son miembros del grupo.")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<Personaje> miembros;

}