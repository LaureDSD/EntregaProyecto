package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;


import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "tipo_monstruo")
@Schema(description = "Entidad que representa un tipo de monstruo en el sistema")
@Getter
@Setter
public class TipoMonstruo {

    //Id del tipo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de monstruo", example = "1")
    private Long tipo_monstruo_id;

    //Nombre del tipo
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de monstruo", example = "normal")
    private String nombre;

    //Descripcion del tipo
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de monstruo", example = "Monstruos comunes que se encuentran en cualquier zona")
    private String descripcion;

}