package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.usuarioDTO.UsuarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.securityController.CensorController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
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

    /*
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    // CRUD Usuario

    @GetMapping
    @Operation(summary = "Obtener lista de usuarios", description = "Retorna una lista de usuarios. Si se proporciona un ID de tipo de usuario, filtra por ese tipo.")
    public ResponseEntity<Object> obtenerListaUsuarios(@RequestParam(required = false) Long id) {
        try {
            if (id == null) {
                return ResponseEntity.ok( conversorListaUsuarioDTO(usuarioService.getAll()) ) ;
            } else {
                TipoUsuario tu = new TipoUsuario();
                tu.setTipo_usuario_id(id);
                return ResponseEntity.ok( conversorListaUsuarioDTO(usuarioService.getByTipoUsuarioID(tu)));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ups algo salio mal.");
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Retorna un usuario específico basado en su ID")
    public ResponseEntity<Object> obtenerUsuario(@PathVariable Long id) {
        try{
            return ResponseEntity.ok( conversorUsuarioDTO(usuarioService.getByID(id)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ups algo salio mal.");
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario", description = "Actualiza la información de un usuario existente")
    public ResponseEntity<Object> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuarioActualizar) {
        if (usuarioActualizar.getUsuario_id().equals(id)) {
            try {
                return ResponseEntity.ok(conversorUsuarioDTO(usuarioService.setItem(usuarioActualizar)));
            }catch (Exception e){
                return ResponseEntity.badRequest().body("No es posible actualizar revise campos.");
            }

        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del usuario.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario con la información proporcionada")
    public ResponseEntity<Object> guardarUsuario(@RequestBody Usuario usuarioGuardar) {
        try {
            return ResponseEntity.ok( usuarioService.setItem(usuarioGuardar) );
        }catch (Exception e){
            return ResponseEntity.badRequest().body("No es posible actualizar revise campos.");
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario basado en su ID")
    public ResponseEntity<Object> borrarUsuario(@PathVariable Long id) {
        try{
            usuarioService.deleteByID(id);
            return ResponseEntity.ok( "Borardo corerctamente");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("No es posible borrar si tiene campos enlazados.");
        }
    }

    // Conversor de lista de Usuario a lista de UsuarioDTO
    public  List<UsuarioDTO> conversorListaUsuarioDTO(List<Usuario> listaUsuarios) {
        return listaUsuarios.stream()
                .map(this::conversorUsuarioDTO)
                .collect(Collectors.toList());
    }

    // Conversor de Usuario a UsuarioDTO
    public  UsuarioDTO conversorUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getUsuario_id());
        usuarioDTO.setImagen(usuario.getImagen_perfil());
        usuarioDTO.setNombrePublico(usuario.getNombre_usuario_pub());
        usuarioDTO.setNombrePrivado(CensorController.ocultarNumero(usuario.getNombre_usuario_priv(), 2));
        usuarioDTO.setCorreo(CensorController.ocultarEmail(usuario.getCorreo(), 3));
        usuarioDTO.setContrasena(CensorController.ocultarNumero(usuario.getContraseña(), 1));
        usuarioDTO.setLimitePersoanjes(usuario.getLimite_personajes());
        usuarioDTO.setConexion(usuario.getUltima_conexion());
        usuarioDTO.setTipoUsuario( usuario.getTipoUsuario() );
        usuarioDTO.setFecha_creacion(usuario.getFecha_creacion());
        usuarioDTO.setEstado(usuario.isEstado_cuenta());
        return usuarioDTO;
    }

    */

}