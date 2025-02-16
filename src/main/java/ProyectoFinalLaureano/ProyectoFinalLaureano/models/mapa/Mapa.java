package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
@NoArgsConstructor
@Entity
@Table(name = "mapas")
@Schema(description = "Entidad que representa un mapa en el sistema")
@Getter
@Setter
public class Mapa {

    //ID del mapa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del mapa", example = "1")
    private Long mapa_id;

    //Nombre del mapa
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del mapa", example = "Mazmorra Oscura")
    private String nombre;

    //Descripciondel mapa
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del mapa", example = "Una mazmorra llena de peligros")
    private String descripcion;

    //Imagen del mapa
    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen del mapa", example = "mazmorra.jpg")
    private String imagen;

    //Relacion con tipo de mapa
    @ManyToOne
    @JoinColumn(name = "tipo_mapa_id", nullable = false)
    @Schema(description = "Tipo de mapa asociado")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private TipoMapa tipoMapa;

    // Nivel recomendado para aceder
    @Column(name = "nivel_recomendado")
    @Schema(description = "Nivel recomendado para el mapa", example = "1")
    private int nivel_recomendado;

    // Relación con MapaEfecto 1:N
    @OneToMany(mappedBy = "mapa", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Efectos asociados a este mapa")
    private List<MapaEfecto> efectos;

    // Relacion con mosntruoos 1:N
    @OneToMany(mappedBy = "mapa", cascade = CascadeType.ALL)
    @Schema(description = "Monstruos que pueden aparecer en este mapa")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<MapaMonstruo> mapaMonstruos;
}
