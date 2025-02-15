package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.TipoMapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
public class MapaController {

    @Autowired
    private MapaService mapaService;

    @Autowired
    private MapaEfectoService mapaEfectoService;

    @Autowired
    private MapaMonstruoService mapaMonstruoService;

    @Autowired
    private TipoMapaService tipoMapaService;


    //CRUD TIPO MAPA






    //CRUD MAPA

    @GetMapping("/")
    public List<Mapa> obtenerListaMapas(@RequestParam(required = false) TipoTransaccion tipoTransaccion){
        if(tipoTransaccion==null){
            return  mapaService.getAll();
        }else{
            //return logTransaccionesService.getBytipoTransaccion(tipoTransaccion);
            return null;
        }
    }

    @GetMapping("/{id}")
    public Mapa obtener(@PathVariable Long id){
        return mapaService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Mapa actualizar(@PathVariable Long id, @RequestBody Mapa mapaActualizar){
        mapaActualizar.setMapa_id(id);
        return  mapaService.setItem(mapaActualizar);
    }

    @PostMapping
    public Mapa guardar(@RequestBody Mapa mapaGuardar){
        return  mapaService.setItem(mapaGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        mapaService.deleteByID(id);
    }

    //CRUD MAPA MONSTRUO



    //CRUD MAPA EFECTO

}
