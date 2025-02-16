package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
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
public class MapaController {

    @Autowired
    private TipoMapaService tipoMapaService;

    @Autowired
    private MapaService mapaService;

    @Autowired
    private MapaEfectoService mapaEfectoService;

    @Autowired
    private MapaMonstruoService mapaMonstruoService;




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
        if(tipoMapaActualizar.getTipo_mapa_id().equals(id)) {
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

    //CRUD MAPA MONSTRUO

    @GetMapping("{mapaId}/monstruo/")
    public List<MapaMonstruo> obtenerListaMonstruoMapas(Long id){
        return  mapaMonstruoService.getAll();
    }

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


    //CRUD MAPA EFECTO
    @GetMapping("{mapaId}/efecto/")
    public List<MapaEfecto> obtenerListaEfectoMapas(Long id){
        return  mapaEfectoService.getAll();
    }

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
