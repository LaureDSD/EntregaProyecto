package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.usuarioDTO.UsuarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.security.ControladorSeguridad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuario Controller", description = "Operaciones CRUD para la gestión de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // CRUD Usuario

    @GetMapping
    @Operation(summary = "Obtener lista de usuarios", description = "Retorna una lista de usuarios. Si se proporciona un ID de tipo de usuario, filtra por ese tipo.")
    public List<UsuarioDTO> obtenerListaUsuarios(@RequestParam(required = false) Long id) {
        if (id == null) {
            return conversorListaUsuarioDTO(usuarioService.getAll());
        } else {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setTipoUsuarioId(id);
            return conversorListaUsuarioDTO(usuarioService.getByTipoUsuarioID(tipoUsuario));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Retorna un usuario específico basado en su ID")
    public UsuarioDTO obtenerUsuario(@PathVariable Long id) {
        return conversorUsuarioDTO(usuarioService.getByID(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario", description = "Actualiza la información de un usuario existente")
    public ResponseEntity<Object> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuarioActualizar) {
        if (usuarioActualizar.getUsuarioId().equals(id)) {
            return ResponseEntity.ok(conversorUsuarioDTO(usuarioService.setItem(usuarioActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del usuario.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario con la información proporcionada")
    public UsuarioDTO guardarUsuario(@RequestBody Usuario usuarioGuardar) {
        return conversorUsuarioDTO(usuarioService.setItem(usuarioGuardar));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario basado en su ID")
    public void borrarUsuario(@PathVariable Long id) {
        usuarioService.deleteByID(id);
    }

    // Conversor de lista de Usuario a lista de UsuarioDTO
    public static List<UsuarioDTO> conversorListaUsuarioDTO(List<Usuario> listaUsuarios) {
        return listaUsuarios.stream()
                .map(UsuarioController::conversorUsuarioDTO)
                .collect(Collectors.toList());
    }

    // Conversor de Usuario a UsuarioDTO
    public static UsuarioDTO conversorUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getUsuarioId());
        usuarioDTO.setImagen(usuario.getImagen_perfil());
        usuarioDTO.setNombrePublico(usuario.getNombre_usuario_pub());
        usuarioDTO.setNombrePrivado(ControladorSeguridad.ocultarNumero(usuario.getNombre_usuario_priv(), 2));
        usuarioDTO.setCorreo(ControladorSeguridad.ocultarEmail(usuario.getCorreo(), 3));
        usuarioDTO.setContrasena(ControladorSeguridad.ocultarNumero(usuario.getContraseña(), 1));
        usuarioDTO.setLimitePersoanjes(usuario.getLimite_personajes());
        usuarioDTO.setConexion(usuario.getUltima_conexion());
        usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());
        usuarioDTO.setFecha_creacion(usuario.getFecha_creacion());
        usuarioDTO.setEstado(usuario.isEstado_cuenta());
        return usuarioDTO;
    }
}