package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.EstadisticasPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.RegistroPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesonaje")
public class persoanjeController {

    @Autowired
    private PersoanjeService persoanjeService;

    @Autowired
    private RegistroPersonajeService registroPersoanjeService;

    @Autowired
    private EstadisticasPersonajeService estadisticasPersonajesService;

    @Autowired
    private InventarioPersonajeService inventarioPersonajeService;

    // CRUD PERSONAJE
    @GetMapping("/")
    public List<Personaje> obtenerUsuario(){
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
