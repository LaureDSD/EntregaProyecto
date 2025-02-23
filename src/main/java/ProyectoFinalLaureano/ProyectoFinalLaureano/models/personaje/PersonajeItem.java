package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "inventario_personaje")
@Schema(description = "Entidad que representa el inventario de un personaje")
@Getter
@Setter
public class PersonajeItem {

    //Clase que relaciona las dos claves de la tabla persoanje_id e item_id
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personaje_inventario_id;

    //Relacion de persoanje con item N:1
    @ManyToOne
    //@MapsId("personaje_id")
    @JoinColumn(name = "personaje_id", nullable = false)
    //@JsonIgnore
    @Schema(description = "Personaje asociado al inventario")
    private Personaje personaje;

    //Relacion de item con persoanje N:1
    @ManyToOne
    //@MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem en el inventario")
    private Item item;

    //Cantidad especifica en el inventario
    @Column(name = "cantidad", nullable = false)
    @Schema(description = "Cantidad del ítem en el inventario", example = "1")
    private int cantidad;

    //Si es equipables , indica si esta o no equipado mediante booleano
    @Column(name = "equipado", nullable = false)
    @Schema(description = "Indica si el ítem está equipado", example = "false")
    private boolean equipado;

    //Fecha de obtencion del item (Por si pongo caducidad/degradacion)
    @DateTimeFormat
    @Column(name = "fecha_obtencion", nullable = false)
    @Schema(description = "Fecha y hora de obtención del ítem", example = "2023-10-01T12:00:00")
    private Date fecha_obtencion;


}
