package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/efectosEstados")
public class efectoEstadoController {

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
    public  EfectoEstado actualizar(@PathVariable Long id, @RequestBody EfectoEstado efectoEstadoActualizar){
        efectoEstadoActualizar.setEfecto_id(id);
        return  efectoEstadoService.setItem(efectoEstadoActualizar);
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
