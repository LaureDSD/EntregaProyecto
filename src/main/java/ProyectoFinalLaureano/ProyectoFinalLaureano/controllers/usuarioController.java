package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class usuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/tipo")
    public List<TipoUsuario> obtenerTiposUsuario(){
        return  tipoUsuarioService.getAll();
    }

    /*
    @GetMapping("/")
    public List<Usuario> obtenerUsuario(){
        return  usuarioService.getAll();
    }*/

    //Filtrar usuario por tipo
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
    public  Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuarioActualizar){
        usuarioActualizar.setUsuario_id(id);
        return  usuarioService.setItem(usuarioActualizar);
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
