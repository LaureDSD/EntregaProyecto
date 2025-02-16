package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.TipoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoTipoController {

    @Autowired
    private TipoGrupoService tipoGrupoService;

    //CRUD basico de Tipos
    @GetMapping("/tipo/")
    public List<TipoGrupo> obtener(){
        return  tipoGrupoService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public TipoGrupo obtener(@PathVariable Long id){
        return tipoGrupoService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody TipoGrupo habilidadActualizar){
        if(habilidadActualizar.getTipoGrupoId().equals(id)) {
            return ResponseEntity.ok( tipoGrupoService.setItem(habilidadActualizar) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping("/tipo")
    public TipoGrupo guardar(@RequestBody TipoGrupo habilidadGuardar){
        return  tipoGrupoService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrar (@PathVariable Long id){
        tipoGrupoService.deleteByID(id);
    }

}
