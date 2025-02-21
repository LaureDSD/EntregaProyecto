package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.LogrosPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/personajesLogros")
public class PersonajeLogrosWebController {

    @Autowired
    private LogrosPersonajeService logrosPersonajeService;

    // Endpoint para mostrar la lista de logros de personajes
    @GetMapping
    public String listar(Model model) {
        try {
            List<LogrosPersonaje> logros = logrosPersonajeService.getAll();
            model.addAttribute("personajesLogros", logros);
            return "admin/personajesLogros";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logros de personajes: " + e.getMessage());
            return "admin/personajesLogros";
        }
    }

    // Endpoint para mostrar el formulario de edición de un logro
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogrosPersonaje logro = (id != null) ? logrosPersonajeService.getByID(id) : new LogrosPersonaje();
            model.addAttribute("logroPersonaje", logro);
            return "admin/personajesLogros";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el logro para editar: " + e.getMessage());
            return "admin/personajesLogros";
        }
    }

    // Endpoint para guardar un logro
    @PostMapping("/save")
    public String guardar(@ModelAttribute("logroPersonaje") LogrosPersonaje logro, Model model) {
        try {
            logrosPersonajeService.setItem(logro);
            return "redirect:/admin/personajesLogros";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el logro: " + e.getMessage());
            return "admin/personajesLogros";
        }
    }

    // Endpoint para eliminar un logro
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            logrosPersonajeService.deleteByID(id);
            return "redirect:/admin/personajesLogros";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el logro: " + e.getMessage());
            return "admin/personajesLogros";
        }
    }
}
