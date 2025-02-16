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
public class UsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    private UsuarioService usuarioService;

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
}
