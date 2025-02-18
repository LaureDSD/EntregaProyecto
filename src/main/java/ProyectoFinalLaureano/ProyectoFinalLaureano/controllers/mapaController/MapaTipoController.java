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
public class MapaTipoController {

    @Autowired
    private TipoMapaService tipoMapaService;

    //CRUD TIPO MAPA

    @GetMapping("/tipo/")
        public List<TipoMapa> obtenerListaTipoMapa(@RequestParam(required = false) Long id){
            return  tipoMapaService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public TipoMapa obtenerTipoMapa(@PathVariable Long id){
        return tipoMapaService.getByID(id);
    }

    @PutMapping("/tipo{id}")
    public  ResponseEntity<Object> actualizarTipoMapa(@PathVariable Long id, @RequestBody TipoMapa tipoMapaActualizar){
        if(tipoMapaActualizar.getTipoMapaId().equals(id)) {
            return ResponseEntity.ok( tipoMapaService.setItem(tipoMapaActualizar) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping("/tipo")
    public TipoMapa guardarTipoMapa(@RequestBody TipoMapa tipoMapaGuardar){
        return  tipoMapaService.setItem(tipoMapaGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrarTipoMapa(@PathVariable Long id){
        tipoMapaService.deleteByID(id);
    }

}
