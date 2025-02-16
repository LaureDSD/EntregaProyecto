package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;



import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidadId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.HabilidadesPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeHabilidadesController {

    @Autowired
    private HabilidadesPersonajeService habilidadesPersonajeService;

    // CRUD HABILIDADES PERSONAJE

    @GetMapping("/habilidades/")
    public List<PersonajeHabilidad> obtenerListaHabilidadesPersonaje() {
        return habilidadesPersonajeService.getAll();
    }

    @GetMapping("/habilidades/{personajeId}/{habilidadId}")
    public PersonajeHabilidad obtenerHabilidadPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long habilidadId) {
        return habilidadesPersonajeService.getByID(new PersonajeHabilidadId(personajeId, habilidadId));
    }

    @PutMapping("/habilidades/{personajeId}/{habilidadId}")
    public ResponseEntity<Object> actualizarHabilidadPersonaje(@PathVariable Long personajeId, @PathVariable Long habilidadId, @RequestBody PersonajeHabilidad habilidadActualizar) {
        if (habilidadActualizar.getId().equals(new PersonajeHabilidadId(personajeId, habilidadId))) {
            return ResponseEntity.ok(habilidadesPersonajeService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad del personaje.");
        }
    }

    @PostMapping("/habilidades/")
    public PersonajeHabilidad guardarHabilidadPersonaje(@RequestBody PersonajeHabilidad habilidadGuardar) {
        return habilidadesPersonajeService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/habilidades/{personajeId}/{habilidadId}")
    public void borrarHabilidadPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long habilidadId) {
        habilidadesPersonajeService.deleteByID(new PersonajeHabilidadId(personajeId, habilidadId));
    }
}
