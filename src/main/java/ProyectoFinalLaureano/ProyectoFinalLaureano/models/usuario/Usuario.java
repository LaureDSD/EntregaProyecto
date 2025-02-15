package ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


// (Correcto)

@Getter
@Setter
@Entity
@Table(name = "usuarios")
@Schema(description = "Entidad que representa a un usuario en el sistema")
public class Usuario {

    //ID unico de cada usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del usuario", example = "1")
    private Long usuario_id;

    //Imagen de perfil de cada usuario
    @Column(name = "imagen_perfil", length = 255)
    @Schema(description = "URL de la imagen de perfil del usuario", example = "img1.jpg")
    private String imagen_perfil;

    //Nombre publico de cada usuario
    @Column(name = "nombre_usuario_pub", nullable = false, length = 100)
    @Schema(description = "Nombre público del usuario", example = "Usuario1")
    private String nombre_usuario_pub;

    //Limite de personjaes por usuario
    @Column(name = "limite_personajes", nullable = false)
    @Schema(description = "Límite de personajes que puede crear el usuario", example = "3")
    private int limite_personajes;

    //nombre privado y unico de cada usuario
    @Column(name = "nombre_usuario_priv", nullable = false, unique = true, length = 100)
    @Schema(description = "Nombre privado del usuario (para login)", example = "user1")
    private String nombre_usuario_priv;

    //Correo de cada usuario
    @Column(name = "correo", nullable = false, unique = true, length = 100)
    @Schema(description = "Correo electrónico del usuario", example = "user1@example.com")
    private String correo;

    //Contrasena de cada usuario
    @Column(name = "contraseña", nullable = false, length = 255)
    @Schema(description = "Contraseña del usuario", example = "password1")
    private String contraseña;

    //Ultima conexion
    @Column(name = "ultima_conexion")
    @Schema(description = "Fecha y hora de la última conexión del usuario", example = "2023-10-01T12:00:00")
    private LocalDateTime ultima_conexion;

    //Ultima ip de conexion (Fumada)
    @Column(name = "ip_ultima_conexion", length = 45)
    @Schema(description = "IP de la última conexión del usuario", example = "192.168.1.1")
    private String ip_ultima_conexion;

    //Token de seguridad del usuario
    @Column(name = "token_conexion")
    @Schema(description = "Token de seguridad", example = "wy55gby34ynytwrrtgt4")
    private String token_conexion;

    //Fecha en la que se crea el usuario
    @Column(name = "fecha_creacion", nullable = false)
    @Schema(description = "Fecha y hora de creación del usuario", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_creacion;

    //Estado de la cuenta sin ser borrada, activa o inactiva
    @Column(name = "estado_cuenta", nullable = false)
    @Schema(description = "Estado de la cuenta del usuario (activa/inactiva)", example = "true")
    private boolean estado_cuenta;

    // Relación con TipoUsuario N:1
    @ManyToOne
    @JoinColumn(name = "tipo_usuario", nullable = false)
    @Schema(description = "Tipo de usuario asociado")
    private TipoUsuario tipoUsuario;

    // Relación con Personaje 1:N
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de personajes asociados al usuario")
    @JsonIgnore
    private List<Personaje> personajes;

}