package ProyectoFinalLaureano.ProyectoFinalLaureano.models.item;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

// (Corrrecto)
@NoArgsConstructor
@Entity
@Table(name = "tipo_item")
@Schema(description = "Entidad que representa un tipo de ítem en el sistema")
@Getter
@Setter
public class TipoItem {

    //ID del tipo de item
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de ítem", example = "1")
    private Long tipoItemId;

    //Noombre del tipo de item
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de ítem", example = "consumible")
    private String nombre;

    //Noombre del tipo de item
    @Column(name = "imagen")
    @Schema(description = "imagen del ítem", example = "consumible.jpg")
    private String imagen;

    //Descripcion del item
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de ítem", example = "Consumibles que pueden ser usados para restaurar salud, energía, etc.")
    private String descripcion;

    // Relación Uno a Muchos con Item
    @OneToMany(mappedBy = "tipoItem", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Ítems asociados a este tipo")
    private List<Item> items;
}