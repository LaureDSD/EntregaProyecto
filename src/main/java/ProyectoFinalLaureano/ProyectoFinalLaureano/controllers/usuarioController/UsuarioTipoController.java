package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioTipoController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    // CRUD Tipo Usuario
    @GetMapping("/tipo")
    public List<TipoUsuario> obtenerTiposUsuario(){
        return  tipoUsuarioService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public TipoUsuario obtenerTipoUsuario(@PathVariable Long id){
        return tipoUsuarioService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    public  ResponseEntity<Object> actualizarTipoUusario(@PathVariable Long id, @RequestBody TipoUsuario usuarioActualizar){
        if (usuarioActualizar.getTipo_usuario_id().equals(id)) {
            return ResponseEntity.ok(tipoUsuarioService.setItem(usuarioActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de ítem.");
        }
    }

    @PostMapping("/tipo")
    public TipoUsuario guardarTipoUsuario(@RequestBody TipoUsuario usuarioGuardar){
        return  tipoUsuarioService.setItem(usuarioGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrarTipoUsuario (@PathVariable Long id){
        tipoUsuarioService.deleteByID(id);
    }

}
