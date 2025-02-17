package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.usuarioDTO.UsuarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // CRUD Usuario
    @GetMapping
    public List<Usuario> obtenerLista(@RequestParam(required = false) Long id){
        if(id==null){
            return  usuarioService.getAll();
        }else{
            TipoUsuario  tu = new TipoUsuario();
            tu.setTipo_usuario_id(id);
            return usuarioService.getByTipoUsuarioID(tu);
        }
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id){
        return usuarioService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody Usuario usuarioActualizar){
        if (usuarioActualizar.getUsuario_id().equals(id)) {
            return ResponseEntity.ok(usuarioService.setItem(usuarioActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del usuario.");
        }
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuarioGuardar){
        return  usuarioService.setItem(usuarioGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        usuarioService.deleteByID(id);
    }


    //Conversor Lista
    public static List<UsuarioDTO> conversorListaUsuarioDTO(List<Usuario> l){
        return l.stream().map(UsuarioController::conversorUsuarioDTO).toList();
    }


    //Conversor Unico DTO
    public static UsuarioDTO conversorUsuarioDTO( Usuario u){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        return  usuarioDTO;
    }
}
