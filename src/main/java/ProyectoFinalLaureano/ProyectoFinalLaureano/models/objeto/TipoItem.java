package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tipo_item")
@Schema(description = "Entidad que representa un tipo de ítem en el sistema")
public class TipoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de ítem", example = "1")
    private Long tipo_item_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de ítem", example = "consumible")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de ítem", example = "Consumibles que pueden ser usados para restaurar salud, energía, etc.")
    private String descripcion;

}