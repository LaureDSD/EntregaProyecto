package ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;



@Entity
@Table(name = "usuarios")
@Schema(description = "Entidad que representa a un usuario en el sistema")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del usuario", example = "1")
    private Long usuario_id;

    @Column(name = "imagen_perfil", length = 255)
    @Schema(description = "URL de la imagen de perfil del usuario", example = "img1.jpg")
    private String imagen_perfil;

    @Column(name = "nombre_usuario_pub", nullable = false, length = 100)
    @Schema(description = "Nombre público del usuario", example = "Usuario1")
    private String nombre_usuario_pub;

    @Column(name = "limite_personajes", nullable = false)
    @Schema(description = "Límite de personajes que puede crear el usuario", example = "3")
    private int limite_personajes;

    @Column(name = "nombre_usuario_priv", nullable = false, unique = true, length = 100)
    @Schema(description = "Nombre privado del usuario (para login)", example = "user1")
    private String nombre_usuario_priv;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    @Schema(description = "Correo electrónico del usuario", example = "user1@example.com")
    private String correo;

    @Column(name = "contraseña", nullable = false, length = 255)
    @Schema(description = "Contraseña del usuario", example = "password1")
    private String contraseña;

    @Column(name = "ultima_conexion")
    @Schema(description = "Fecha y hora de la última conexión del usuario", example = "2023-10-01T12:00:00")
    private LocalDateTime ultima_conexion;

    @Column(name = "ip_ultima_conexion", length = 45)
    @Schema(description = "IP de la última conexión del usuario", example = "192.168.1.1")
    private String ip_ultima_conexion;

    @Column(name = "fecha_creacion", nullable = false)
    @Schema(description = "Fecha y hora de creación del usuario", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_creacion;

    @Column(name = "estado_cuenta", nullable = false)
    @Schema(description = "Estado de la cuenta del usuario (activa/inactiva)", example = "true")
    private boolean estado_cuenta;

    // Relación Muchos a Uno con TipoUsuario
    @ManyToOne
    @JoinColumn(name = "tipo_usuario", nullable = false)
    @Schema(description = "Tipo de usuario asociado")
    private TipoUsuario tipoUsuario;

    // Relación Uno a Muchos con Personaje
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de personajes asociados al usuario")
    @JsonIgnore
    private List<Personaje> personajes;


    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

}