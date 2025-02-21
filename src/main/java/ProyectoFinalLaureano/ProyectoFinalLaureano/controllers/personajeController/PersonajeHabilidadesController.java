package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeHabilidadDTO; // Corregido el nombre de la clase
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.HabilidadesPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajeHabilidad")
@Tag(name = "Personaje Habilidades Controller", description = "Operaciones CRUD para la gestión de habilidades de personajes")
public class PersonajeHabilidadesController {

    private PersonajeController personajeController;

    @Autowired
    private HabilidadesPersonajeService habilidadesPersonajeService;

    @Autowired
    private PersoanjeService persoanjeService;

    @Autowired
    private HabilidadService habilidadService;

    // CRUD HABILIDADES PERSONAJE

    @GetMapping("")
    @Operation(summary = "Obtener todas las habilidades de los personajes", description = "Retorna una lista de todas las habilidades asociadas a los personajes")
    public PersonajeHabilidadDTO obtenerListaHabilidadesPersonajes() {
        return conversorListaPersonajeHabilidadDTO(habilidadesPersonajeService.getAll());
    }


    @GetMapping("/{personaje_habilidad_id}")
    @Operation(summary = "Obtener una habilidad específica de un personaje", description = "Retorna una habilidad específica asociada a un personaje")
    public PersonajeHabilidad obtenerHabilidadPersonaje(@PathVariable Long h_p_id) {
        return habilidadesPersonajeService.getByID(h_p_id);
    }

    @PutMapping("/{personaje_habilidad_id}")
    @Operation(summary = "Actualizar una habilidad de un personaje", description = "Actualiza la información de una habilidad específica asociada a un personaje")
    public ResponseEntity<Object> actualizarHabilidadPersonaje(
            @PathVariable Long p_s_id,
            @RequestBody PersonajeHabilidad habilidadActualizar) {
        if (habilidadActualizar.getPersonaje_habilidad_id().equals(p_s_id)) {
            return ResponseEntity.ok(habilidadesPersonajeService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad del personaje.");
        }
    }

    @PostMapping("")
    @Operation(summary = "Crear una nueva habilidad para un personaje", description = "Crea una nueva habilidad asociada a un personaje")
    public PersonajeHabilidad guardarHabilidadPersonaje(@RequestBody PersonajeHabilidad habilidadGuardar) {
        return habilidadesPersonajeService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{personaje_habilidad_id}")
    @Operation(summary = "Eliminar una habilidad de un personaje", description = "Elimina una habilidad específica asociada a un personaje")
    public void borrarHabilidadPersonaje(
            @PathVariable Long p_h_id) {
        habilidadesPersonajeService.deleteByID(p_h_id);
    }

    // Conversor de lista de PersonajeHabilidad a PersonajeHabilidadDTO
    public  PersonajeHabilidadDTO conversorListaPersonajeHabilidadDTO(List<PersonajeHabilidad> listaHabilidades) {
        PersonajeHabilidadDTO dto = new PersonajeHabilidadDTO();
        if (!listaHabilidades.isEmpty()) {

            dto.setPersonaje( personajeController.conversorPersonajeDTO( persoanjeService.getByID(listaHabilidades.get(0).getPersonaje())));
            dto.setHabilidades( listaHabilidades.stream().map( e -> habilidadService.getByID(e.getHabilidad())).toList());
        }
        return dto;
    }
}