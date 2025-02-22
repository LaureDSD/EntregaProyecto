package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.InventarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeMisionDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.ClasePersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersonajeMisionService; // Corregido el nombre del servicio
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personajeMision")
@Tag(name = "Personaje Misiones Controller", description = "Operaciones CRUD para la gestión de misiones de personajes")
public class MisionesPersonajeController {


    @Autowired
    private PersonajeMisionService personajeMisionService;

    @Autowired
    private ClasePersonajeService clasePersonajeService;

    @Autowired
    private ItemService itemService;

    // CRUD PERSONAJE MISIÓN


    @GetMapping("/{personaje_mision_id}")
    @Operation(summary = "Obtener una misión específica de un personaje", description = "Retorna una misión específica asociada a un personaje")
    public PersonajeMision obtenerMisionPersonaje(
            @PathVariable Long id) {
        return personajeMisionService.getByID(id);
    }

    @PutMapping("/{personaje_mision_id}")
    @Operation(summary = "Actualizar una misión de un personaje", description = "Actualiza la información de una misión específica asociada a un personaje")
    public ResponseEntity<Object> actualizarMisionPersonaje(
            @PathVariable Long id,
            @RequestBody PersonajeMision misionActualizar) {
        if (misionActualizar.getPersoanje_mision_id().equals(id)) {
            return ResponseEntity.ok(personajeMisionService.setItem(misionActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la misión del personaje.");
        }
    }

    @PostMapping("")
    @Operation(summary = "Crear una nueva misión para un personaje", description = "Crea una nueva misión asociada a un personaje")
    public PersonajeMision guardarMisionPersonaje(@RequestBody PersonajeMision misionGuardar) {
        return personajeMisionService.setItem(misionGuardar);
    }

    @DeleteMapping("/{personaje_mision_id}")
    @Operation(summary = "Eliminar una misión de un personaje", description = "Elimina una misión específica asociada a un personaje")
    public void borrarMisionPersonaje(
            @PathVariable Long id) {
        personajeMisionService.deleteByID(id);
    }

    // Conversor de lista de PersonajeMision a PersonajeMisionDTO
    public  PersonajeMisionDTO conversorPersonajeMisionDTO(List<PersonajeMision> listaMisiones) {
        PersonajeMisionDTO dto = new PersonajeMisionDTO();
        if (!listaMisiones.isEmpty()) {
            dto.setPersonaje( conversorPersonajeDTO(listaMisiones.get(0).getPersonaje()));
            dto.setMisiones(listaMisiones.stream()
                    .map(PersonajeMision::getMision)
                    .toList());
        }
        return dto;
    }
    // Conversor de Personaje a PersonajeDTO
    public PersonajeDTO conversorPersonajeDTO(Personaje personaje) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(personaje.getPersonaje_id());
        personajeDTO.setImagen(personaje.getImagen_modelo());
        personajeDTO.setNombre(personaje.getNombre());
        personajeDTO.setCreacion(personaje.getFecha_creacion());
        personajeDTO.setClase( personaje.getClase_personaje());
        personajeDTO.setNivel(personaje.getNivel());
        personajeDTO.setXp_acumulada(personaje.getXp_acumulada());
        personajeDTO.setAlmas(personaje.getAlmas());
        personajeDTO.setLogros(personaje.getLogros());
        personajeDTO.setCapacidad_inventario(personaje.getCapacidad_inventario());
        personajeDTO.setInventario( inventarioDTO(personaje.getInventario()));
        personajeDTO.setEstadisticas(personaje.getEstadisticas());
        return personajeDTO;
    }

    public List<InventarioDTO> inventarioDTO(List<InventarioPersonaje> ip){
        List<InventarioDTO> lsdto  = new ArrayList<>();
        InventarioDTO i = new InventarioDTO();
        ip.forEach( e -> {
                    i.setItem( itemService.getByID(e.getItem().getItem_id()));
                    i.setCantidad(e.getCantidad());
                    i.setCantidad(e.getCantidad());
                    i.setEquipado(e.isEquipado());
                    lsdto.add(i);
                }
        );
        return lsdto;
    }


}