package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.ClasePersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
@Tag(name = "ClasePersonaje", description = "API para gestionar clases de personajes")
public class ClaseController {

    @Autowired
    private ClasePersonajeService clasePersonajeService;

    @GetMapping("/clase/")
    @Operation(summary = "Obtener todas las clases de personajes")
    public List<ClasePersonaje> obtenerListaClasesPersonaje() {
        return clasePersonajeService.getAll();
    }

    @GetMapping("/clase/{id}")
    @Operation(summary = "Obtener una clase de personaje por ID")
    public ClasePersonaje obtenerClasePersonaje(@PathVariable Long id) {
        return clasePersonajeService.getByID(id);
    }

    @PutMapping("/clase/{id}")
    @Operation(summary = "Actualizar una clase de personaje por ID")
    public ResponseEntity<Object> actualizarClasePersonaje(@PathVariable Long id, @RequestBody ClasePersonaje clasePersonajeActualizar) {
        if (clasePersonajeActualizar.getClase_id().equals(id)) {
            return ResponseEntity.ok(clasePersonajeService.setItem(clasePersonajeActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la clase de personaje.");
        }
    }

    @PostMapping("/clase")
    @Operation(summary = "Crear una nueva clase de personaje")
    public ClasePersonaje guardarClasePersonaje(@RequestBody ClasePersonaje clasePersonajeGuardar) {
        return clasePersonajeService.setItem(clasePersonajeGuardar);
    }

    @DeleteMapping("/clase/{id}")
    @Operation(summary = "Eliminar una clase de personaje por ID")
    public void borrarClasePersonaje(@PathVariable Long id) {
        clasePersonajeService.deleteByID(id);
    }
}