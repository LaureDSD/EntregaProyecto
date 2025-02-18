package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidadId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeHabilidadDTO; // Corregido el nombre de la clase
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.HabilidadesPersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
@Tag(name = "Personaje Habilidades Controller", description = "Operaciones CRUD para la gestión de habilidades de personajes")
public class PersonajeHabilidadesController {

    @Autowired
    private HabilidadesPersonajeService habilidadesPersonajeService;

    // CRUD HABILIDADES PERSONAJE

    @GetMapping("/habilidades/")
    @Operation(summary = "Obtener todas las habilidades de los personajes", description = "Retorna una lista de todas las habilidades asociadas a los personajes")
    public PersonajeHabilidadDTO obtenerListaHabilidadesPersonajes() {
        return conversorListaPersonajeHabilidadDTO(habilidadesPersonajeService.getAll());
    }

    @GetMapping("/{personajeId}/habilidades/")
    @Operation(summary = "Obtener habilidades de un personaje específico", description = "Retorna las habilidades asociadas a un personaje específico")
    public PersonajeHabilidadDTO obtenerListaHabilidadesPersonaje(@PathVariable Long personajeId) {
        return conversorListaPersonajeHabilidadDTO(habilidadesPersonajeService.getByPersonajeId(personajeId));
    }

    @GetMapping("/{personajeId}/habilidades/{habilidadId}")
    @Operation(summary = "Obtener una habilidad específica de un personaje", description = "Retorna una habilidad específica asociada a un personaje")
    public PersonajeHabilidad obtenerHabilidadPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long habilidadId) {
        return habilidadesPersonajeService.getByID(new PersonajeHabilidadId(personajeId, habilidadId));
    }

    @PutMapping("/{personajeId}/habilidades/{habilidadId}")
    @Operation(summary = "Actualizar una habilidad de un personaje", description = "Actualiza la información de una habilidad específica asociada a un personaje")
    public ResponseEntity<Object> actualizarHabilidadPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long habilidadId,
            @RequestBody PersonajeHabilidad habilidadActualizar) {
        if (habilidadActualizar.getId().equals(new PersonajeHabilidadId(personajeId, habilidadId))) {
            return ResponseEntity.ok(habilidadesPersonajeService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad del personaje.");
        }
    }

    @PostMapping("/habilidades/")
    @Operation(summary = "Crear una nueva habilidad para un personaje", description = "Crea una nueva habilidad asociada a un personaje")
    public PersonajeHabilidad guardarHabilidadPersonaje(@RequestBody PersonajeHabilidad habilidadGuardar) {
        return habilidadesPersonajeService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{personajeId}/habilidades/{habilidadId}")
    @Operation(summary = "Eliminar una habilidad de un personaje", description = "Elimina una habilidad específica asociada a un personaje")
    public void borrarHabilidadPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long habilidadId) {
        habilidadesPersonajeService.deleteByID(new PersonajeHabilidadId(personajeId, habilidadId));
    }

    // Conversor de lista de PersonajeHabilidad a PersonajeHabilidadDTO
    public static PersonajeHabilidadDTO conversorListaPersonajeHabilidadDTO(List<PersonajeHabilidad> listaHabilidades) {
        PersonajeHabilidadDTO dto = new PersonajeHabilidadDTO();
        if (!listaHabilidades.isEmpty()) {
            dto.setPersonaje(PersonajeController.conversorPersonajeDTO(listaHabilidades.get(0).getPersonaje()));
            dto.setHabilidades(listaHabilidades.stream()
                    .map(PersonajeHabilidad::getHabilidad)
                    .toList());
        }
        return dto;
    }
}