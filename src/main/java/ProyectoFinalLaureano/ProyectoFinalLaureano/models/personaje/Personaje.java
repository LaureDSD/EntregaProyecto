package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

// (Correcto)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "personajes")
@Schema(description = "Entidad que representa un personaje en el sistema")
public class Personaje {

    //Id de cada personaje
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del personaje", example = "1")
    private Long personaje_id;

    //Imagen/modelo de cada persoanje
    @Column(name = "imagen_modelo", length = 255)
    @Schema(description = "URL de la imagen del modelo del personaje", example = "model1.jpg")
    private String imagen_modelo;

    //Nombre de cada persoanje
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del personaje", example = "Guerrero1")
    private String nombre;

    //Fecha de creacion
    @Column(name = "fecha_creacion", nullable = false)
    @Schema(description = "Fecha y hora de creación del personaje", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_creacion;

    //Nivel del persoanje
    @Column(name = "nivel", nullable = false)
    @Schema(description = "Nivel del personaje", example = "1")
    private int nivel;

    //EXP del persoanje
    @Column(name = "xp_acumulada", nullable = false)
    @Schema(description = "Experiencia acumulada del personaje", example = "0")
    private int xp_acumulada;

    //Almas acumuladas por el personaje
    @Column(name = "almas", nullable = false)
    @Schema(description = "Almas acumuladas por el personaje", example = "0")
    private int almas;

    //Limite de inventario del personaje
    @Column(name = "capacidad_inventario", nullable = false)
    @Schema(description = "Capacidad del inventario del personaje", example = "20")
    private int capacidad_inventario;

    //RelacionCon Estadisticas
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "estadisticas_id", referencedColumnName = "estadisticasId")
    private EstadisticasGenerales estadisticas;

    // Relación Muchos a Uno con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @Schema(description = "Usuario al que pertenece el personaje")
    private Usuario usuario;

    //Logros del persoanje
    @OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Logros del persoanje")
    private LogrosPersonaje logros;

    //Clase
    @ManyToOne
    @JoinColumn(name = "clase_id")
    @Schema(description = "Clase del persoanje asociado")
    private ClasePersonaje clase_persoanje;

    //Grupo
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    @Schema(description = "Grupo del persoanje asociado")
    private Grupo grupo;

    //Union como lider
    @OneToMany(mappedBy = "lider", cascade = CascadeType.ALL)
    @Schema(description = "Ítems en el inventario del personaje")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<Grupo> gruposLiderados;


    // Relación Uno a Muchos con InventarioPersonaje
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    @Schema(description = "Ítems en el inventario del personaje")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<InventarioPersonaje> inventario;


    //Union con habilidad
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    @Schema(description = "Habilidades asociadas a este personaje")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<PersonajeHabilidad> personajeHabilidades;

    // Union conregistro de logros
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<LogPersonajeMonstruo> logPersonaje;

}