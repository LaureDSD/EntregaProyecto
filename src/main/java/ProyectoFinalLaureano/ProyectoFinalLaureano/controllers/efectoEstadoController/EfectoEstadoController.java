package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/efectos")
@Tag(name = "EfectoEstado", description = "API para gestionar efectos de estado")
public class EfectoEstadoController {

    @Autowired
    private EfectoEstadoService efectoEstadoService;

    @GetMapping("/")
    @Operation(summary = "Obtener todos los efectos de estado")
    public List<EfectoEstado> obtenerUsuario(){
        return  efectoEstadoService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un efecto de estado por ID")
    public EfectoEstado obtener(@PathVariable Long id){
        return efectoEstadoService.getByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un efecto de estado por ID")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody EfectoEstado efectoEstadoActualizar){
        if(efectoEstadoActualizar.getEfecto_id().equals(id)) {
            return ResponseEntity.ok(efectoEstadoService.setItem(efectoEstadoActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo efecto de estado")
    public EfectoEstado guardar(@RequestBody EfectoEstado EfectoEstadoGuardar){
        return  efectoEstadoService.setItem(EfectoEstadoGuardar);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un efecto de estado por ID")
    public void borrar (@PathVariable Long id){
        efectoEstadoService.deleteByID(id);
    }
}
