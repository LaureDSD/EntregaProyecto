package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController.EfectoEstadoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.MonstruoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
public class MapaController {

    @Autowired
    private MapaService mapaService;

    //CRUD MAPA

    @GetMapping("/")
    public List<Mapa> obtenerListaMapas(@RequestParam(required = false) Long id){
        if(id==null){
            return  mapaService.getAll();
        }else{
            TipoMapa tipoMapa = new TipoMapa();
            tipoMapa.setTipo_mapa_id(id);
            return mapaService.getBytipoMapa(tipoMapa);
        }
    }

    @GetMapping("/{id}")
    public Mapa obtenerMapa(@PathVariable Long id){
        return mapaService.getByID(id);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> actualizarMapa(@PathVariable Long id, @RequestBody Mapa mapaActualizar){
        if(mapaActualizar.getMapa_id().equals(id)) {
            return ResponseEntity.ok( mapaService.setItem(mapaActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping
    public Mapa guardarMapa(@RequestBody Mapa mapaGuardar){
        return  mapaService.setItem(mapaGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarMapa(@PathVariable Long id){
        mapaService.deleteByID(id);
    }



}
