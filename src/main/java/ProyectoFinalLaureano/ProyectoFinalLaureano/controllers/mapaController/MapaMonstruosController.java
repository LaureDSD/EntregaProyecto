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
public class MapaMonstruosController {

    @Autowired
    private MapaMonstruoService mapaMonstruoService;

    //CRUD MAPA MONSTRUO

    @GetMapping("/monstruo/")
    public List<MapaMonstruo> obtenerListaMonstruoMapas(){
        return  mapaMonstruoService.getAll();
    }

    /*
    @GetMapping("{mapaId}/monstruo/")
    public List<MapaMonstruo> obtenerListaMonstruoMapa(@PathVariable Long id_mapa){
        return  mapaMonstruoService.getByMapaId();
    }*/

    @GetMapping("{mapaId}/monstruo/{monstruoId}")
    public MapaMonstruo obtenerMonstruoMapa(@PathVariable Long id_mapa,@PathVariable Long id_monstruo){
        return mapaMonstruoService.getByID(new MapaMonstruoId(id_mapa,id_monstruo));
    }

    @PutMapping("{mapaId}/monstruo/{monstruoId}")
    public  ResponseEntity<Object> actualizarMonstruoMapa(@PathVariable Long id_mapa,@PathVariable Long id_monstruo, @RequestBody MapaMonstruo monstruoActualizar){
        if(monstruoActualizar.getId().equals(new MapaMonstruoId(id_mapa,id_monstruo))) {
            return ResponseEntity.ok( mapaMonstruoService.setItem(monstruoActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del monstruo.");
        }
    }

    @PostMapping("{mapaId}/monstruo/")
    public MapaMonstruo guardarMonstruoMapa(@RequestBody MapaMonstruo monstruoGuardar){
        return  mapaMonstruoService.setItem(monstruoGuardar);
    }

    @DeleteMapping("{mapaId}/monstruo/{monstruoId}")
    public void borrarMonstruoMapa(@PathVariable Long id_mapa,@PathVariable Long id_monstruo){
        mapaMonstruoService.deleteByID(new MapaMonstruoId(id_mapa,id_monstruo));
    }

}
