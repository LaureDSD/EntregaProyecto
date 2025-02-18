package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.TipoMapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
public class MapaEfectoController {

    @Autowired
    private MapaEfectoService mapaEfectoService;

    //CRUD MAPA EFECTO
    @GetMapping("/efecto/")
    public List<MapaEfecto> obtenerListaEfectoMapas(){
        return  mapaEfectoService.getAll();
    }

    /*
    @GetMapping("{mapaId}/efecto/")
    public List<MapaEfecto> obtenerListaEfectoMapa(@PathVariable Long id_mapa){
        return  mapaEfectoService.getByMapaId();
    }*/

    @GetMapping("{mapaId}/efecto/{monstruoId}")
    public MapaEfecto obtenerEfectoMapa(@PathVariable Long id_mapa,@PathVariable Long id_efecto){
        return mapaEfectoService.getByID(new MapaEfectoId(id_mapa,id_efecto));
    }

    @PutMapping("{mapaId}/efecto/{monstruoId}")
    public  ResponseEntity<Object> actualizarEfectoMapa(@PathVariable Long id_mapa,@PathVariable Long id_monstruo, @RequestBody MapaEfecto efectoActualizar){
        if(efectoActualizar.getId().equals(new MapaMonstruoId(id_mapa,id_monstruo))) {
            return ResponseEntity.ok( mapaEfectoService.setItem(efectoActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping("{mapaId}/efecto/")
    public MapaEfecto guardarEfectoMapa(@RequestBody MapaEfecto efectoGuardar){
        return  mapaEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("{mapaId}/efecto/{monstruoId}")
    public void borrarEfectoMapa(@PathVariable Long id_mapa,@PathVariable Long id_monstruo){
        mapaEfectoService.deleteByID(new MapaEfectoId(id_mapa,id_monstruo));
    }

}
