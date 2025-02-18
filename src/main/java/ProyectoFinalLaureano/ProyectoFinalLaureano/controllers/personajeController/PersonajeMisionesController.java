package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMisionId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeMisionDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersonajeMisionService; // Corregido el nombre del servicio
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
@Tag(name = "Personaje Misiones Controller", description = "Operaciones CRUD para la gestión de misiones de personajes")
public class PersonajeMisionesController {

    @Autowired
    private PersonajeMisionService personajeMisionService;

    // CRUD PERSONAJE MISIÓN

    @GetMapping("/{personajeId}/misiones")
    @Operation(summary = "Obtener misiones de un personaje", description = "Retorna las misiones asociadas a un personaje específico")
    public PersonajeMisionDTO obtenerListaMisionesPersonaje(@PathVariable Long personajeId) {
        return conversorPersonajeMisionDTO(personajeMisionService.getByPersonajeId(personajeId)); // Corregido el nombre del método
    }

    @GetMapping("/{personajeId}/misiones/{misionId}")
    @Operation(summary = "Obtener una misión específica de un personaje", description = "Retorna una misión específica asociada a un personaje")
    public PersonajeMision obtenerMisionPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long misionId) {
        return personajeMisionService.getByID(new PersonajeMisionId(personajeId, misionId));
    }

    @PutMapping("/{personajeId}/misiones/{misionId}")
    @Operation(summary = "Actualizar una misión de un personaje", description = "Actualiza la información de una misión específica asociada a un personaje")
    public ResponseEntity<Object> actualizarMisionPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long misionId,
            @RequestBody PersonajeMision misionActualizar) {
        if (misionActualizar.getId().equals(new PersonajeMisionId(personajeId, misionId))) {
            return ResponseEntity.ok(personajeMisionService.setItem(misionActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la misión del personaje.");
        }
    }

    @PostMapping("/misiones/")
    @Operation(summary = "Crear una nueva misión para un personaje", description = "Crea una nueva misión asociada a un personaje")
    public PersonajeMision guardarMisionPersonaje(@RequestBody PersonajeMision misionGuardar) {
        return personajeMisionService.setItem(misionGuardar);
    }

    @DeleteMapping("/{personajeId}/misiones/{misionId}")
    @Operation(summary = "Eliminar una misión de un personaje", description = "Elimina una misión específica asociada a un personaje")
    public void borrarMisionPersonaje(
            @PathVariable Long personajeId,
            @PathVariable Long misionId) {
        personajeMisionService.deleteByID(new PersonajeMisionId(personajeId, misionId));
    }

    // Conversor de lista de PersonajeMision a PersonajeMisionDTO
    public static PersonajeMisionDTO conversorPersonajeMisionDTO(List<PersonajeMision> listaMisiones) {
        PersonajeMisionDTO dto = new PersonajeMisionDTO();
        if (!listaMisiones.isEmpty()) {
            dto.setPersonaje(PersonajeController.conversorPersonajeDTO(listaMisiones.get(0).getPersonaje()));
            dto.setMisiones(listaMisiones.stream()
                    .map(PersonajeMision::getMision)
                    .toList());
        }
        return dto;
    }
}