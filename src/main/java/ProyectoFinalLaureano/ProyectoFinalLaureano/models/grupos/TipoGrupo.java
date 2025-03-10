package ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos;

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
@Table(name = "tipo_grupo")
@Schema(description = "Entidad que representa un tipo de grupo en el sistema.")
public class TipoGrupo {

    //Id del tipo de grupo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de grupo.", example = "1")
    private Long tipo_grupo_id;

    //Nombre del tippo de grupo
    @Column(nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de grupo.", example = "Equipo de Aventureros")
    private String nombre;

    //Limite de intehgrantes del grupo
    @Column(nullable = false)
    @Schema(description = "Número máximo de integrantes permitidos en el grupo.", example = "5")
    private Integer numeroIntegrantesMax;

    //Configuraciones de grupo
    @Column(nullable = false)
    @Schema(description = "Indica si los miembros del grupo comparten experiencia y drops.", example = "true")
    private Boolean compartenExpDrops;

    //Descripcion del tipo de grupo
    @Column(columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de grupo.", example = "Grupo para misiones de alto nivel.")
    private String descripcion;

    // Relación con Grupo
    @OneToMany(mappedBy = "tipoGrupo", cascade = CascadeType.ALL)
    @Schema(description = "Lista de grupos asociados a este tipo de grupo.")
    @JsonIgnore
    private List<Grupo> grupos;

}