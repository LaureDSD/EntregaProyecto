package ProyectoFinalLaureano.ProyectoFinalLaureano.models.log;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoLog;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


// (Correcto)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "logs")
@Schema(description = "Entidad que representa los registros de logs del sistema")
public class LogUsuario {

    //ID del log
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del log", example = "1")
    private Long log_id;

    // Usuario relacionado
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    //@Column(name = "usuario_id", nullable = false)
    @Schema(description = "Usuario relacionado con el log", example = "123")
    private Usuario usuario;

    //Tipo de log
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_log", nullable = false)
    @Schema(description = "Tipo de log", example = "informacion")
    private TipoLog tipoLog;

    //Mensaje descriptivo
    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    @Schema(description = "Mensaje del log", example = "Error al guardar los datos")
    private String mensaje;

    //Fecha de emision
    @DateTimeFormat
    @Column(name = "fecha_log", nullable = false)
    @Schema(description = "Fecha y hora del log", example = "2023-10-01T12:00:00")
    private Date fechaLog = new Date();
}

