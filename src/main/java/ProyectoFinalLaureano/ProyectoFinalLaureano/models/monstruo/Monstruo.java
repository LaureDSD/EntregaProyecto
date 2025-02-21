package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "monstruos")
@Schema(description = "Entidad que representa un monstruo en el sistema")
@Getter
@Setter
public class Monstruo {

    //ID del monstruo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del monstruo", example = "1")
    private Long monstruo_id;

    //Nombre del monstruo
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del monstruo", example = "Goblin")
    private String nombre;

    //Tipo de omonstruo
    //@ManyToOne
    //@JoinColumn(name = "tipo_monstruo_id", nullable = false)
    //@JsonIgnore // Excluir esta relación en la serialización JSON
    @Column(name = "tipo _monstruo_id")
    @Schema(description = "Tipo del monstruo", example = "1")
    private Long tipo_monstruo;

    //Nivel del mosntruo
    @Column(name = "nivel")
    @Schema(description = "Nivel del monstruo", example = "1")
    private int nivel;

    //Descripcion del monstruo
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del monstruo", example = "Un pequeño monstruo verde")
    private String descripcion;

    //Imgaen del monstruo
    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen del monstruo", example = "goblin.jpg")
    private String imagen;

    //RelacionCon Estadisticas
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadistica_id", referencedColumnName = "estadistica_id")
    @JsonIgnore // Excluir esta relación en la serialización JSON
   // @Column(name = "estadistica_id", length = 255)
    @Schema(description = "Id de las estadisticas del mosntruo", example = "2")
    private EstadisticasGenerales estadisticas;

    //Almas que otorga
    @Column(name = "almas_otorgadas", nullable = false)
    @Schema(description = "Almas que otorga el monstruo al ser derrotado", example = "10")
    private int almasOtrogadas;

    //Experiencia que otroga
    @Column(name = "experiencia_otorgada")
    @Schema(description = "Experiencia que otorga el monstruo al ser derrotado", example = "5")
    private int experienciaOtorgada;

    // Relación Uno a Muchos con DropsNPC
    @OneToMany(mappedBy = "monstruo", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Drops asociados a este monstruo")
    private List<DropsObjetos> drops;

    //Nuevo
    @OneToMany(mappedBy = "monstruo", cascade = CascadeType.ALL)
    @Schema(description = "Mapas donde este monstruo puede aparecer")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<MapaMonstruo> mapaMonstruos;

    @OneToMany(mappedBy = "monstruo", cascade = CascadeType.ALL)
    @Schema(description = "Habilidades asociadas a este monstruo")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<MonstruoHabilidad> monstruoHabilidades;

}