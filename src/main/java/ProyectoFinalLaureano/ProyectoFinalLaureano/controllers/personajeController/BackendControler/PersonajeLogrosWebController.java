package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.LogrosPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/personaje/personajesLogros")
public class PersonajeLogrosWebController {

    private final String rutaHTML ="/admin/personaje/personajesLogros";

    @Autowired
    private LogrosPersonajeService logrosPersonajeService;

    @Autowired
    private PersoanjeService persoanjeService;
    private List<Personaje> pl;

    // Endpoint para mostrar la lista de logros de personajes
    @GetMapping
    public String listar(Model model) {
        try {
            pl = persoanjeService.getAll();
            List<LogrosPersonaje> logros = logrosPersonajeService.getAll();
            model.addAttribute("personajesLogros", logros);
            model.addAttribute("personajeLogro", new LogrosPersonaje());
            model.addAttribute("personajeList", pl );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logros de personajes: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para mostrar el formulario de edición de un logro
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogrosPersonaje logro = (id != null) ? logrosPersonajeService.getByID(id) : new LogrosPersonaje();
            model.addAttribute("personajeLogro", logro);
            model.addAttribute("personajeList", pl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el logro para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para guardar un logro
    @PostMapping("/save")
    public String guardar(@ModelAttribute("personajeLogro") LogrosPersonaje logro, Model model) {
        try {
            logrosPersonajeService.setItem(logro);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el logro: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para eliminar un logro
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            logrosPersonajeService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el logro: " + e.getMessage());
            return rutaHTML;
        }
    }
}
