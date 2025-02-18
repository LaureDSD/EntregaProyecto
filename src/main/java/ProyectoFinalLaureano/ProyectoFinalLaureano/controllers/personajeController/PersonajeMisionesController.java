package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMisionId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeMisionDTO;
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

    @GetMapping("/{personajeId}/misiones")
    public PersonajeMisionDTO obtenerListaMisionesPersonaje(@PathVariable Long personajeId) {
        return conversorPersonajeMisiondDTO(personajeMisionService.getByPersoanjeId(personajeId));
    }

    @GetMapping("{personajeId}/misiones//{misionId}")
    public PersonajeMision obtenerMisionPersonaje(@PathVariable Long personajeId, @PathVariable Long misionId) {
        return personajeMisionService.getByID(new PersonajeMisionId(personajeId, misionId));
    }

    @PutMapping("{personajeId}/misiones/{misionId}")
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

    @DeleteMapping("{personajeId}/misiones/{misionId}")
    public void borrarMisionPersonaje(@PathVariable Long personajeId, @PathVariable Long misionId) {
        personajeMisionService.deleteByID(new PersonajeMisionId(personajeId, misionId));
    }

    public static PersonajeMisionDTO conversorPersonajeMisiondDTO(List<PersonajeMision> l) {
        PersonajeMisionDTO ps = new PersonajeMisionDTO();
        ps.setPersonaje(l.get(1).getPersonaje());
        ps.setMisiones( l.stream().map(PersonajeMision::getMision).toList());
        return ps;
    }
}
