package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GruposController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping("/")
    public List<Grupo> obtenerUsuario(){
        return  grupoService.getAll();
    }

    @GetMapping("/{id}")
    public Grupo obtener(@PathVariable Long id){
        return grupoService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Grupo actualizar(@PathVariable Long id, @RequestBody Grupo habilidadActualizar){
        habilidadActualizar.setGrupo_id(id);
        return  grupoService.setItem(habilidadActualizar);
    }

    @PostMapping
    public Grupo guardar(@RequestBody Grupo habilidadGuardar){
        return  grupoService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        grupoService.deleteByID(id);
    }
}
