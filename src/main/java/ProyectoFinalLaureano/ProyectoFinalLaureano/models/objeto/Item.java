package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.InventarioPersonaje;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Schema(description = "Entidad que representa un ítem en el sistema")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del ítem", example = "1")
    private Long item_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del ítem", example = "Poción de Vida")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tipo_item", nullable = false)
    @Schema(description = "Tipo de ítem (relación con la tabla tipo_item)")
    private TipoItem tipo_item;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del ítem", example = "Restaura 50 puntos de vida")
    private String descripcion;

    @Column(name = "acumulaciones_max", nullable = false)
    @Schema(description = "Cantidad máxima de acumulaciones del ítem", example = "99")
    private int acumulaciones_max;

    @Column(name = "precio_base")
    @Schema(description = "Precio base del ítem", example = "10")
    private int precio_base;

    @Column(name = "valor_dinamico")
    @Schema(description = "Valor dinámico del ítem", example = "5")
    private int valor_dinamico;

    // Relación Uno a Muchos con InventarioPersonaje
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InventarioPersonaje> inventarios = new ArrayList<>();

    // Relación Uno a Muchos con DropsObjetos
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DropsObjetos> drops = new ArrayList<>();

}