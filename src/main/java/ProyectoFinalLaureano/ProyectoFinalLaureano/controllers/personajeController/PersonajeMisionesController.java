package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMisionId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeMisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeMisionesController {

    @Autowired
    private PersoanjeMisionService personajeMisionService;

    // CRUD PERSONAJE MISIÓN

    @GetMapping("/misiones/")
    public List<PersonajeMision> obtenerListaMisionesPersonaje() {
        return personajeMisionService.getAll();
    }

    @GetMapping("/misiones/{personajeId}/{misionId}")
    public PersonajeMision obtenerMisionPersonaje(@PathVariable Long personajeId, @PathVariable Long misionId) {
        return personajeMisionService.getByID(new PersonajeMisionId(personajeId, misionId));
    }

    @PutMapping("/misiones/{personajeId}/{misionId}")
    public ResponseEntity<Object> actualizarMisionPersonaje(@PathVariable Long personajeId, @PathVariable Long misionId, @RequestBody PersonajeMision misionActualizar) {
        if (misionActualizar.getId().equals(new PersonajeMisionId(personajeId, misionId))) {
            return ResponseEntity.ok(personajeMisionService.setItem(misionActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la misión del personaje.");
        }
    }

    @PostMapping("/misiones/")
    public PersonajeMision guardarMisionPersonaje(@RequestBody PersonajeMision misionGuardar) {
        return personajeMisionService.setItem(misionGuardar);
    }

    @DeleteMapping("/misiones/{personajeId}/{misionId}")
    public void borrarMisionPersonaje(@PathVariable Long personajeId, @PathVariable Long misionId) {
        personajeMisionService.deleteByID(new PersonajeMisionId(personajeId, misionId));
    }
}
