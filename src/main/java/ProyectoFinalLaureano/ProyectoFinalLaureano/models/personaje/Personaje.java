package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "personajes")
@Schema(description = "Entidad que representa un personaje en el sistema")
@Getter
@Setter
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del personaje", example = "1")
    private Long personaje_id;

    @Column(name = "imagen_modelo", length = 255)
    @Schema(description = "URL de la imagen del modelo del personaje", example = "model1.jpg")
    private String imagen_modelo;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del personaje", example = "Guerrero1")
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    @Schema(description = "Fecha y hora de creación del personaje", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_creacion;

    // Relación Muchos a Uno con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @Schema(description = "Usuario al que pertenece el personaje")
    private Usuario usuario;

    // Relación Uno a Uno con EstadisticasPersonaje
    @OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Estadísticas asociadas al personaje")
    private EstadisticasPersonaje estadisticas;

    // Relación Uno a Muchos con RegistroPersonaje
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Registros de actividades del personaje")
    private List<RegistroPersonaje> registros;

    // Relación Muchos a Muchos con Habilidad
    @ManyToMany
    @JoinTable(
            name = "personaje_habilidad",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "habilidad_id")
    )
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Habilidades aprendidas por el personaje")
    private List<Habilidad> habilidades;

    // Relación Uno a Muchos con InventarioPersonaje
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Ítems en el inventario del personaje")
    private List<InventarioPersonaje> inventario;
}