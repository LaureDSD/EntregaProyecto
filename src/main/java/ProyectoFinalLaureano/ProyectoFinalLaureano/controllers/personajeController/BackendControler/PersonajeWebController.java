package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/personajes")
public class PersonajeWebController {

    @Autowired
    private PersoanjeService personajeService;

    // Listado de Personajes
    @GetMapping
    public String listarPersonaje(Model model) {
        try {
            try{}catch (Exception e){throw  e;}
            List<Personaje> personaje = personajeService.getAll();
            model.addAttribute("personajes", personaje);
            model.addAttribute("personaje", personaje);
            return "admin/personajes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los personajes: " + e.getMessage());
            return "admin/personajes";
        }
    }

    // Formulario para crear o editar Personaje
    @GetMapping("/edit/{id}")
    public String editarPersonaje(@PathVariable("id") Long id, Model model) {
        try {
            Personaje personaje = (id != null) ? personajeService.getByID(id) : new Personaje();
            model.addAttribute("personaje", personaje);
            return "admin/personajes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los datos del personaje: " + e.getMessage());
            return "admin/personajes";
        }
    }

    // Guardar Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarPersonaje(@ModelAttribute("personaje") Personaje personaje, Model model) throws IOException {
        try {
            personajeService.setItem(personaje);
            return "redirect:/admin/personajes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el personaje: " + e.getMessage());
            return "admin/personajes";
        }
    }

    // Eliminar Personaje
    @GetMapping("/delete/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id) {
        try {
            personajeService.deleteByID(id);
            return "redirect:/admin/personajes";
        } catch (Exception e) {
            return "redirect:/admin/personajes";
        }
    }
}
