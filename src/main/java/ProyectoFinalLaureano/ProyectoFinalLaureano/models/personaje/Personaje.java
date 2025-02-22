package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.LiderGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Date;
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
    private Date fecha_creacion;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadistica_id")
    private EstadisticasGenerales estadisticas;

    // Relación Muchos a Uno con Usuario
    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    @Schema(description = "Usuario al que pertenece el personaje")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private Usuario usuario;

    //Logros del persoanje
    @OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL)
    @Schema(description = "Logros del persoanje")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private LogrosPersonaje logros;

    //Clase
    @ManyToOne
    @JoinColumn(name = "clase_id", nullable = false)
    @Schema(description = "Clase del persoanje asociado")
    private ClasePersonaje clase_personaje;

    //Grupo
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    @Schema(description = "Grupo del persoanje asociado")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private Grupo grupo;


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

    // Union conregistro de logros
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<PersonajeMision> misiones;

    // Relacion persoanje con lider 1:1
    @OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL)
    private LiderGrupo liderGrupo;


}