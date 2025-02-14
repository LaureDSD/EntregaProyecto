package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "monstruos")
@Schema(description = "Entidad que representa un monstruo en el sistema")
@Getter
@Setter
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del monstruo", example = "1")
    private Long monstruo_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del monstruo", example = "Goblin")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tipo_monstruo_id", nullable = false)
    @Schema(description = "Tipo de monstruo asociado")
    private TipoMonstruo tipo_monstruo;

    @Column(name = "nivel")
    @Schema(description = "Nivel del monstruo", example = "1")
    private int nivel;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del monstruo", example = "Un pequeño monstruo verde")
    private String descripcion;

    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen del monstruo", example = "goblin.jpg")
    private String imagen;

    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base del monstruo", example = "100")
    private int vida_base;
    @Column(name = "escudo_base", nullable = false)
    @Schema(description = "Escudo base del monstruo", example = "0")
    private int escudo_base;


    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base del monstruo", example = "50")
    private int energia_base;
    @Column(name = "mana_base", nullable = false)
    @Schema(description = "Mana base del monstruo", example = "50")
    private int emana_base;


    @Column(name = "ataque_fisico_base", nullable = false)
    @Schema(description = "Ataque base del monstruo", example = "10")
    private int ataquefiscobase;
    @Column(name = "ataque_magico_base", nullable = false)
    @Schema(description = "Ataque base del persoanje", example = "10")
    private int ataqueMagicoBase;

    @Column(name = "defensa_fisica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensamagica;
    @Column(name = "defensa_magica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensafisica;

    @Column(name = "almas", nullable = false)
    @Schema(description = "Almas que otorga el monstruo al ser derrotado", example = "10")
    private int almas;

    @Column(name = "experiencia_otorgada")
    @Schema(description = "Experiencia que otorga el monstruo al ser derrotado", example = "5")
    private int experiencia_otorgada;

    // Relación Uno a Muchos con DropsNPC
    @OneToMany(mappedBy = "monstruo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Drops asociados a este monstruo")
    private List<DropsObjetos> drops;


    //Nuevo
    @OneToMany(mappedBy = "monstruo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Mapas donde este monstruo puede aparecer")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<MapaMonstruo> mapaMonstruos;

    @OneToMany(mappedBy = "monstruo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Habilidades asociadas a este monstruo")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<MonstruoHabilidad> monstruoHabilidades;

}