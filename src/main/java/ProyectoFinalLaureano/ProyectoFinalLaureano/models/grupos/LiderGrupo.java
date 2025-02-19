package ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lidergrupo")
public class LiderGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lider_grupo_id")
    private Long liderGrupoId;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false, unique = true)
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false , unique = true)
    private Personaje personaje;

    @Column(name = "fecha_nombramiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNombramiento;

}