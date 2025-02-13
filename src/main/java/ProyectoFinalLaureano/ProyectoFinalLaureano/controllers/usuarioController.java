package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/")
    public List<Usuario> obtenerUsuario(){
        return  usuarioService.getAll();
    }


     /*
    @Autowired
    private FacturaService facturaService;


    @GetMapping
    public List<Factura> obtenerTodos(){
        return  facturaService.getAll();


    //Get DTO V1
    @GetMapping
    public List<FacturaDTO> obtenerLista(@RequestParam(required = false) Long id){
        if(id==null){
            return  facturaService.getAll();
        }else{
            var c = new Cliente();
            c.setId(id);
            return facturaService.getByCliente(c);
        }

    }

    //GET SIN DTO
    @GetMapping("/{id}")
    public FacturaV3DTO obtener(@PathVariable Long id){
        return facturaService.getByID(id);
    }


    @PutMapping("/{id}")
    public  Factura actualizar(@PathVariable Long id, @RequestBody Factura f){
        f.setId(id);
        return  facturaService.setItem(f);
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura f){
        return  facturaService.setItem(f);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        facturaService.deleteByID(id);
    }


*/

}
