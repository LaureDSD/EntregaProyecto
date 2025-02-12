package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mapas")
@Schema(description = "Entidad que representa un mapa en el sistema")
public class Mapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del mapa", example = "1")
    private Long mapa_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del mapa", example = "Mazmorra Oscura")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del mapa", example = "Una mazmorra llena de peligros")
    private String descripcion;

    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen del mapa", example = "mazmorra.jpg")
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "tipo_mapa_id", nullable = false)
    @Schema(description = "Tipo de mapa (relación con la tabla tipo_mapa)")
    private TipoMapa tipo_mapa;

    @Column(name = "nivel_recomendado")
    @Schema(description = "Nivel recomendado para el mapa", example = "1")
    private int nivel_recomendado;

    // Relación Muchos a Muchos con Monstruo
    @ManyToMany(mappedBy = "mapas")
    private List<Monstruo> monstruos = new ArrayList<>();

    // Relación Muchos a Uno con EfectoEstado
    @ManyToOne
    @JoinColumn(name = "efecto_id")
    private EfectoEstado efecto;

}
