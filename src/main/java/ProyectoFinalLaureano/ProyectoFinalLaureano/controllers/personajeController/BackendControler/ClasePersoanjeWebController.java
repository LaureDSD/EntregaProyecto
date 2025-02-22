package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.ClasePersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/personaje/tipoPersonaje")
public class ClasePersoanjeWebController {

    private final String rutaHTML = "/admin/personaje/tipoPersonaje";

    @Autowired
    private ClasePersonajeService clasePersonajeService;

    // Listado de Clases de Personaje
    @GetMapping
    public String listarClasesPersonaje(Model model) {
        try {
            List<ClasePersonaje> clasesPersonaje = clasePersonajeService.getAll();
            model.addAttribute("clasesPersonaje", clasesPersonaje);
            model.addAttribute("clasePersonaje", new ClasePersonaje());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las clases de personajes: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar Clase de Personaje
    @GetMapping("/edit/{id}")
    public String editarClasePersonaje(@PathVariable("id") Long id, Model model) {
        try {
            ClasePersonaje clasePersonaje = (id != null) ? clasePersonajeService.getByID(id) : new ClasePersonaje();
            model.addAttribute("clasePersonaje", clasePersonaje);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los datos de la clase de personaje: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar Clase de Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarClasePersonaje(@ModelAttribute("ClasePersonaje") ClasePersonaje clasePersonaje, Model model) throws IOException {
        try {
            clasePersonajeService.setItem(clasePersonaje);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la clase de personaje: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar Clase de Personaje
    @GetMapping("/delete/{id}")
    public String eliminarClasePersonaje(@PathVariable("id") Long id, Model model) {
        try {
            clasePersonajeService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la clase de personaje: " + e.getMessage());
            return rutaHTML;
        }
    }
}
