package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.HabilidadesPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/persoanjesHabilidades")
public class PersonajeHabilidadesWebController {

    @Autowired
    private HabilidadesPersonajeService habilidadesPersonajeService;

    // Endpoint para mostrar la lista de habilidades de personaje
    @GetMapping
    public String listar(Model model) {
        try {
            List<PersonajeHabilidad> habilidades = habilidadesPersonajeService.getAll();
            model.addAttribute("persoanjesHabilidades", habilidades);
            model.addAttribute("persoanjeHabilidad", new MonstruoHabilidad());
            return "admin/persoanjesHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las habilidades de los personajes: " + e.getMessage());
            return "admin/persoanjesHabilidades";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            PersonajeHabilidad personajeHabilidad = (id != null) ? habilidadesPersonajeService.getByID(id) : new PersonajeHabilidad();
            model.addAttribute("personajeHabilidad", personajeHabilidad);
            return "admin/persoanjesHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la habilidad del personaje para editar: " + e.getMessage());
            return "admin/persoanjesHabilidades";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("personajeHabilidad") PersonajeHabilidad personajeHabilidad, Model model) {
        try {
            habilidadesPersonajeService.setItem(personajeHabilidad);
            return "redirect:/admin/persoanjesHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la habilidad del personaje: " + e.getMessage());
            return "admin/persoanjesHabilidades";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            habilidadesPersonajeService.deleteByID(id);
            return "redirect:/admin/persoanjesHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la habilidad del personaje: " + e.getMessage());
            return "admin/persoanjesHabilidades";
        }
    }
}
