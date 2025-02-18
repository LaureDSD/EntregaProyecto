package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/efectos")
public class EfectoEstadoController {

    @Autowired
    private EfectoEstadoService efectoEstadoService;

    @GetMapping("/")
    public List<EfectoEstado> obtenerUsuario(){
        return  efectoEstadoService.getAll();
    }

    @GetMapping("/{id}")
    public EfectoEstado obtener(@PathVariable Long id){
        return efectoEstadoService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody EfectoEstado efectoEstadoActualizar){
        if(efectoEstadoActualizar.getEfecto_id().equals(id)) {
            return ResponseEntity.ok( efectoEstadoService.setItem(efectoEstadoActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping
    public EfectoEstado guardar(@RequestBody EfectoEstado EfectoEstadoGuardar){
        return  efectoEstadoService.setItem(EfectoEstadoGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        efectoEstadoService.deleteByID(id);
    }

}
