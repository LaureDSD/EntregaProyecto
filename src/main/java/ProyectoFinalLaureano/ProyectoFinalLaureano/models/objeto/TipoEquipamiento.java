package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto;


import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tipo_equipamiento")
@Schema(description = "Entidad que representa un tipo de equipamiento en el sistema")
public class TipoEquipamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de equipamiento", example = "1")
    private Long tipo_equipamiento_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de equipamiento", example = "Arma Principal")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de equipamiento", example = "Arma principal del personaje, como espadas, hachas o bastones")
    private String descripcion;

}