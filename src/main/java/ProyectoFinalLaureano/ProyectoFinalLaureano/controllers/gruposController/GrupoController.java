package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.PersonajeController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    //CRUD basico de Grupos
    @GetMapping("/")
    public List<Grupo> obtenerLista(@RequestParam(required = false) Long id){
        if(id==null){
            return  grupoService.getAll();
        }else{
            TipoGrupo tg = new TipoGrupo();
            tg.setTipoGrupoId(id);
            return grupoService.getBytipoGrupo(tg);
        }
    }

    @GetMapping("/{id}")
    public Grupo obtenerGrupo(@PathVariable Long id){
        return grupoService.getByID(id);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> actualizarGrupo(@PathVariable Long id, @RequestBody Grupo habilidadActualizar){
        if(habilidadActualizar.getGrupoId().equals(id)) {
            return ResponseEntity.ok( grupoService.setItem(habilidadActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del grupo.");
        }
    }

    @PostMapping
    public Grupo guardarGrupo(@RequestBody Grupo habilidadGuardar){
        return  grupoService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarGrupo (@PathVariable Long id){
        grupoService.deleteByID(id);
    }


}
