package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;



import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController.HabilidadController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidadId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersoanjeHabilidadDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.HabilidadesPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeHabilidadesController {

    @Autowired
    private HabilidadesPersonajeService habilidadesPersonajeService;

    // CRUD HABILIDADES PERSONAJE
    @GetMapping("/habilidades/")
    public PersoanjeHabilidadDTO obtenerListaHabilidadesPersonajes() {
        return conversorListaPersonajeHabilidadDTO(habilidadesPersonajeService.getAll());
    }

    @GetMapping("/{personajeId}/habilidades/")
    public PersoanjeHabilidadDTO obtenerListaHabilidadesPersonaje(@PathVariable Long personajeId) {
        return conversorListaPersonajeHabilidadDTO(habilidadesPersonajeService.getByPersonajeId(personajeId));
    }

    @GetMapping("/{personajeId}/habilidades/{habilidadId}")
    public PersonajeHabilidad obtenerHabilidadPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long habilidadId) {
        return habilidadesPersonajeService.getByID(new PersonajeHabilidadId(personajeId, habilidadId));
    }

    @PutMapping("/{personajeId}/habilidades/{habilidadId}")
    public ResponseEntity<Object> actualizarHabilidadPersonaje(@PathVariable Long personajeId, @PathVariable Long habilidadId, @RequestBody PersonajeHabilidad habilidadActualizar) {
        if (habilidadActualizar.getId().equals(new PersonajeHabilidadId(personajeId, habilidadId))) {
            return ResponseEntity.ok( habilidadesPersonajeService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad del personaje.");
        }
    }

    @PostMapping("/habilidades/")
    public PersonajeHabilidad guardarHabilidadPersonaje(@RequestBody PersonajeHabilidad habilidadGuardar) {
        return habilidadesPersonajeService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{personajeId}/habilidades/{habilidadId}")
    public void borrarHabilidadPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long habilidadId) {
        habilidadesPersonajeService.deleteByID(new PersonajeHabilidadId(personajeId, habilidadId));
    }


    public static PersoanjeHabilidadDTO conversorListaPersonajeHabilidadDTO(List<PersonajeHabilidad> l) {
        PersoanjeHabilidadDTO ps = new PersoanjeHabilidadDTO();
        ps.setPersonaje(l.get(1).getPersonaje());
        ps.setHabilidades( l.stream().map(PersonajeHabilidad::getHabilidad).toList());
        return ps;
    }

}
