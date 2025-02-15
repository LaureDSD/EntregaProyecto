package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.TipoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GruposController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private TipoGrupoService tipoGrupoService;

    //CRUD basico de Tipos
    @GetMapping("/tipo/")
    public List<Grupo> obtenerUsuario(){
        return  grupoService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public Grupo obtener(@PathVariable Long id){
        return grupoService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    public  Grupo actualizar(@PathVariable Long id, @RequestBody Grupo habilidadActualizar){
        habilidadActualizar.setGrupoId(id);
        return  grupoService.setItem(habilidadActualizar);
    }

    @PostMapping("/tipo")
    public Grupo guardar(@RequestBody Grupo habilidadGuardar){
        return  grupoService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrar (@PathVariable Long id){
        grupoService.deleteByID(id);
    }


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
    public  Grupo actualizarGrupo(@PathVariable Long id, @RequestBody Grupo habilidadActualizar){
        habilidadActualizar.setGrupoId(id);
        return  grupoService.setItem(habilidadActualizar);
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
