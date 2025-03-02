package ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

// (Correcto)
@NoArgsConstructor
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
    @NotNull
    @Size(max = 100)
    @Column(name = "nombre_usuario_pub", nullable = false, length = 100)
    @Schema(description = "Nombre público del usuario", example = "Usuario1")
    private String nombre_usuario_pub;

    //Limite de personjaes por usuario
    @NotNull
    @Column(name = "limite_personajes", nullable = false)
    @Schema(description = "Límite de personajes que puede crear el usuario", example = "3")
    private int limite_personajes;

    //nombre privado y unico de cada usuario
    @NotNull
    @Size(max = 100)
    @Column(name = "nombre_usuario_priv", nullable = false, unique = true, length = 100)
    @Schema(description = "Nombre privado del usuario (para login)", example = "user1")
    private String nombre_usuario_priv;

    //Correo de cada usuario
    @NotNull
    @Email
    @Size(max = 100)
    @Column(name = "correo", nullable = false, unique = true, length = 100)
    @Schema(description = "Correo electrónico del usuario", example = "user1@example.com")
    private String correo;

    //Contrasena de cada usuario
    @NotNull
    @Column(name = "contraseña", nullable = false, length = 255)
    @Schema(description = "Contraseña del usuario", example = "password1")
    private String contraseña;

    //Ultima conexion
    @NotNull
    @DateTimeFormat
    @Column(name = "ultima_conexion")
    @Schema(description = "Fecha y hora de la última conexión del usuario", example = "2023-10-01T12:00:00")
    private Date ultima_conexion;

    //Fecha en la que se crea el usuario
    @NotNull
    @DateTimeFormat
    @Column(name = "fecha_creacion", nullable = false)
    @Schema(description = "Fecha y hora de creación del usuario", example = "2023-10-01T12:00:00")
    private Date fecha_creacion = new Date();

    //Estado de la cuenta sin ser borrada, activa o inactiva
    @NotNull
    @Column(name = "estado_cuenta", nullable = false)
    @Schema(description = "Estado de la cuenta del usuario (activa/inactiva)", example = "true")
    private boolean estado_cuenta;


    @NotNull
    @ManyToOne
    @Schema(description = "Tipo de usuario asociado")
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;


    // Relación con Personaje 1:N
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de personajes asociados al usuario")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<Personaje> personajes;

}