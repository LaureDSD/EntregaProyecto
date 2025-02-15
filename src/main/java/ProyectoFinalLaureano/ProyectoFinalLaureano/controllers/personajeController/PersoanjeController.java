package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesonaje")
public class PersoanjeController {

    @Autowired
    private PersoanjeService persoanjeService;

    @Autowired
    private InventarioPersonajeService inventarioPersonajeService;

    @Autowired
    private HabilidadesPersonajeService habilidadesPersonajeService;

    @Autowired
    private ClasePersoanjeService clasePersoanjeService;

    @Autowired
    private LogrosPersoanjeService logrosPersoanjeService;

    @Autowired
    private PersoanjeMisionService persoanjeMisionService;




    // CRUD PERSONAJE
    @GetMapping("/")
    public List<Personaje> obtenerPersonaje(){
        return  persoanjeService.getAll();
    }

    @GetMapping("/{id}")
    public Personaje obtener(@PathVariable Long id){
        return persoanjeService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Personaje actualizar(@PathVariable Long id, @RequestBody Personaje personajeActualizar){
        personajeActualizar.setPersonaje_id(id);
        return  persoanjeService.setItem(personajeActualizar);
    }

    @PostMapping
    public Personaje guardar(@RequestBody Personaje usuarioGuardar){
        return  persoanjeService.setItem(usuarioGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        persoanjeService.deleteByID(id);
    }

}
