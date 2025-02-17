package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.PersonajeController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.grupoDTO.GrupoDTO;
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
    public List<GrupoDTO> obtenerLista(@RequestParam(required = false) Long id){
        if(id==null){
            return  conversorListaGrupoDTO(grupoService.getAll());
        }else{
            TipoGrupo tg = new TipoGrupo();
            tg.setTipoGrupoId(id);
            return conversorListaGrupoDTO(grupoService.getBytipoGrupo(tg));
        }
    }

    @GetMapping("/{id}")
    public GrupoDTO obtenerGrupo(@PathVariable Long id){
        return conversorGrupoDTO(grupoService.getByID(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> actualizarGrupo(@PathVariable Long id, @RequestBody Grupo habilidadActualizar){
        if(habilidadActualizar.getGrupoId().equals(id)) {
            return ResponseEntity.ok( conversorGrupoDTO(grupoService.setItem(habilidadActualizar)) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del grupo.");
        }
    }

    @PostMapping
    public GrupoDTO guardarGrupo(@RequestBody Grupo habilidadGuardar){
        return  conversorGrupoDTO(grupoService.setItem(habilidadGuardar));
    }

    @DeleteMapping("/{id}")
    public void borrarGrupo (@PathVariable Long id){
        grupoService.deleteByID(id);
    }


    //Conversor Lista Grupo
    public static List<GrupoDTO> conversorListaGrupoDTO (List<Grupo> le){
        return le.stream().map(GrupoController::conversorGrupoDTO).toList();
    }

    //Conversor unico Grupo
    public static GrupoDTO conversorGrupoDTO(Grupo g){
        GrupoDTO grupoDTO = new GrupoDTO();
        grupoDTO.setId(g.getGrupoId());
        grupoDTO.setImagen(g.getImagenLogo());
        grupoDTO.setNombre(g.getNombre());
        grupoDTO.setDescripcion(g.getDescripcion());
        grupoDTO.setLider(PersonajeController.conversorPersonajeDTO((g.getLider())));
        grupoDTO.setMiembros(PersonajeController.conversorListaPersonajeDTO(
                g.getMiembros().stream().filter(e -> e != g.getLider()).toList()));
        return  grupoDTO;
    }
}
