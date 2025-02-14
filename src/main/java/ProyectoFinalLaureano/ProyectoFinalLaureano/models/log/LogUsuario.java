package ProyectoFinalLaureano.ProyectoFinalLaureano.models.log;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
@Schema(description = "Entidad que representa los registros de logs del sistema")
@Getter
@Setter
public class LogUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del log", example = "1")
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Schema(description = "Usuario relacionado con el log", example = "123")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_log", nullable = false)
    @Schema(description = "Tipo de log", example = "informacion")
    private TipoLog tipoLog;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    @Schema(description = "Mensaje del log", example = "Error al guardar los datos")
    private String mensaje;

    @Column(name = "fecha_log", nullable = false)
    @Schema(description = "Fecha y hora del log", example = "2023-10-01T12:00:00")
    private LocalDateTime fechaLog;
}

