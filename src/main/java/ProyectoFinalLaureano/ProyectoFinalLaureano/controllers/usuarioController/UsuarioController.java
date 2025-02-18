package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.PersonajeController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.usuarioDTO.UsuarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.security.ControladorSeguridad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // CRUD Usuario
    @GetMapping
    public List<UsuarioDTO> obtenerLista(@RequestParam(required = false) Long id){
       if(id==null){
            return  conversorListaUsuarioDTO(usuarioService.getAll());
        }else{
            TipoUsuario  tu = new TipoUsuario();
            tu.setTipoUsuarioId(id);
            return conversorListaUsuarioDTO(usuarioService.getByTipoUsuarioID(tu));
        }
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtener(@PathVariable Long id){
        return conversorUsuarioDTO(usuarioService.getByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody Usuario usuarioActualizar){
        if (usuarioActualizar.getUsuarioId().equals(id)) {
            return ResponseEntity.ok(conversorUsuarioDTO(usuarioService.setItem(usuarioActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del usuario.");
        }
    }

    @PostMapping
    public UsuarioDTO guardar(@RequestBody Usuario usuarioGuardar){
        return  conversorUsuarioDTO(usuarioService.setItem(usuarioGuardar));
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        usuarioService.deleteByID(id);
    }


    //Conversor Lista
    public static List<UsuarioDTO> conversorListaUsuarioDTO(List<Usuario> l){
        List<UsuarioDTO> lus = new ArrayList<>();
        l.forEach( e ->  lus.add(conversorUsuarioDTO(e)));
        return lus;
    }

    //Conversor Unico DTO
    public static UsuarioDTO conversorUsuarioDTO( Usuario u){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(u.getUsuarioId());
        usuarioDTO.setImagen(u.getImagen_perfil());
        usuarioDTO.setNombrePublico(u.getNombre_usuario_pub());
        usuarioDTO.setNombrePrivado(ControladorSeguridad.ocultarNumero(u.getNombre_usuario_priv(),2));
        usuarioDTO.setCorreo(ControladorSeguridad.ocultarEmail(u.getCorreo(),3));
        usuarioDTO.setContrasena(ControladorSeguridad.ocultarNumero(u.getContraseña(),1));
        usuarioDTO.setLimitePersoanjes(u.getLimite_personajes());
        usuarioDTO.setConexion(u.getUltima_conexion());
        usuarioDTO.setTipoUsuario(u.getTipoUsuario());
        usuarioDTO.setFecha_creacion(u.getFecha_creacion());
        usuarioDTO.setTipoUsuario(u.getTipoUsuario());
        usuarioDTO.setEstado(u.isEstado_cuenta());
        return  usuarioDTO;
    }
}
