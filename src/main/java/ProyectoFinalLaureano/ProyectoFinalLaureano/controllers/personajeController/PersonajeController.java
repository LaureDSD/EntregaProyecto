package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.InventarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.ClasePersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personaje")
@Tag(name = "Personaje Controller", description = "Operaciones CRUD para la gestión de personajes")
public class PersonajeController {

    @Autowired
    private PersoanjeService personajeService;

    @Autowired
    private ClasePersonajeService clasePersonajeService;

    @Autowired
    private InventarioPersonajeService inventarioPersonajeService;

    @Autowired
    private ItemService itemService;

    // CRUD PERSONAJE

    @GetMapping("/")
    @Operation(summary = "Obtener todos los personajes", description = "Retorna una lista de todos los personajes")
    public List<PersonajeDTO> obtenerPersonajes() {
        return conversorListaPersonajeDTO(personajeService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un personaje por ID", description = "Retorna un personaje específico basado en su ID")
    public PersonajeDTO obtenerPersonaje(@PathVariable Long id) {
        return conversorPersonajeDTO(personajeService.getByID(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un personaje", description = "Actualiza la información de un personaje existente")
    public PersonajeDTO actualizarPersonaje(@PathVariable Long id, @RequestBody Personaje personajeActualizar) {
        personajeActualizar.setPersonaje_id(id);
        return conversorPersonajeDTO(personajeService.setItem(personajeActualizar));
    }

    @PostMapping("/")
    @Operation(summary = "Crear un nuevo personaje", description = "Crea un nuevo personaje con la información proporcionada")
    public PersonajeDTO guardarPersonaje(@RequestBody Personaje personajeGuardar) {
        return conversorPersonajeDTO(personajeService.setItem(personajeGuardar));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un personaje", description = "Elimina un personaje basado en su ID")
    public void borrarPersonaje(@PathVariable Long id) {
        personajeService.deleteByID(id);
    }

    // Conversor de lista de Personaje a lista de PersonajeDTO
    public List<PersonajeDTO> conversorListaPersonajeDTO(List<Personaje> listaPersonajes) {
        List<PersonajeDTO> listaDTO = new ArrayList<>();
        for (Personaje personaje : listaPersonajes) {
            listaDTO.add(conversorPersonajeDTO(personaje));
        }
        return listaDTO;
    }

    // Conversor de Personaje a PersonajeDTO
    public PersonajeDTO conversorPersonajeDTO(Personaje personaje) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(personaje.getPersonaje_id());
        personajeDTO.setImagen(personaje.getImagen_modelo());
        personajeDTO.setNombre(personaje.getNombre());
        personajeDTO.setCreacion(personaje.getFecha_creacion());
        personajeDTO.setClase(clasePersonajeService.getByID(personaje.getClase_personaje()));
        personajeDTO.setNivel(personaje.getNivel());
        personajeDTO.setXp_acumulada(personaje.getXp_acumulada());
        personajeDTO.setAlmas(personaje.getAlmas());
        personajeDTO.setLogros(personaje.getLogros());
        personajeDTO.setCapacidad_inventario(personaje.getCapacidad_inventario());
        personajeDTO.setInventario(inventarioDTO(personaje.getInventario())); // Llamada al método que obtiene el inventario.
        personajeDTO.setEstadisticas(personaje.getEstadisticas());
        return personajeDTO;
    }

    public List<InventarioDTO> inventarioDTO(List<InventarioPersonaje> inventarioPersonajes) {
        List<InventarioDTO> inventariosDTO = new ArrayList<>();
        for (InventarioPersonaje inventario : inventarioPersonajes) {
            InventarioDTO inventarioDTO = new InventarioDTO();
            inventarioDTO.setItem(itemService.getByID(inventario.getItem())); // Obtener el item.
            inventarioDTO.setCantidad(inventario.getCantidad());
            inventarioDTO.setEquipado(inventario.isEquipado());
            inventariosDTO.add(inventarioDTO);
        }
        return inventariosDTO;
    }
}
