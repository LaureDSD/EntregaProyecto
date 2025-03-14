package ProyectoFinalLaureano.ProyectoFinalLaureano.models.item;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NpcItem;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
@NoArgsConstructor
@Entity
@Table(name = "items")
@Schema(description = "Entidad que representa un ítem en el sistema")
@Getter
@Setter
public class Item {

    //ID  de los Items
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del ítem", example = "1")
    private Long item_id;

    //Nombre de los items
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del ítem", example = "Poción de Vida")
    private String nombre;

    //Nombre de los items
    @Column(name = "imagen", nullable = false)
    @Schema(description = "Imagen del ítem", example = "Poción_de_Vida.jpg")
    private String imagen;

    //Tipo del item (Material,Consumible,TipoEquipamiento(Pechera,Casco,Botas,Guantes,Pantalones,Zapatos,Accesorio1,Accesorio2))
    @ManyToOne
    @JoinColumn(name = "tipoItemId", nullable = false)
    @Schema(description = "Tipo de ítem asociado")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private TipoItem tipoItem;

    //Descripcion del item
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del ítem", example = "Restaura 50 puntos de vida")
    private String descripcion;

    //Restriccion item
    @Column(name = "equipable", columnDefinition = "TEXT")
    @Schema(description = "Indica si es equipable del ítem", example = "True")
    private boolean equipable;

    //Acumulaciones maximas o staks
    @Column(name = "acumulaciones_max", nullable = false)
    @Schema(description = "Cantidad máxima de acumulaciones del ítem", example = "99")
    private int acumulaciones_max;

    /*
    // Relación Uno a Muchos con ItemEfecto
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Efectos asociados al ítem")
    private List<ItemEfecto> efectos;*/

    //RelacionCon Estadisticas
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadistica_id", referencedColumnName = "estadistica_id")
    private EstadisticasGenerales estadisticas;

    // Relación Uno a Muchos con DropsObjetos
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Lista de drops asociadas al ítem")
    private List<MonstruoItem> drops;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @Schema(description = "NPCs que venden o compran este item")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<NpcItem> npcProductos;

}