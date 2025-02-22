package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.HabilidadesPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin/personaje/personajesHabilidades")
public class PersonajeHabilidadesWebController {

    private final String rutaHTML = "/admin/personajes/personajesHabilidades";

    @Autowired
    private HabilidadesPersonajeService habilidadesPersonajeService;

    @Autowired
    private HabilidadService habilidadService;
    private List<Habilidad> hl;

    @Autowired
    private PersoanjeService persoanjeService;
    private List<Personaje> pl;

    @GetMapping
    public String listar(Model model) {
        try {
            pl = persoanjeService.getAll();
            hl = habilidadService.getAll();
            model.addAttribute("persoanjesHabilidades", habilidadesPersonajeService.getAll());
            model.addAttribute("persoanjeHabilidad", new MonstruoHabilidad());
            model.addAttribute("personajeList", pl );
            model.addAttribute("habilidadList", hl );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            PersonajeHabilidad personajeHabilidad = (id != null) ? habilidadesPersonajeService.getByID(id) : new PersonajeHabilidad();
            model.addAttribute("personajeHabilidad", personajeHabilidad);
            model.addAttribute("personajeList", pl );
            model.addAttribute("habilidadList", hl );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar:" + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("personajeHabilidad") PersonajeHabilidad personajeHabilidad, Model model) {
        try {
            habilidadesPersonajeService.setItem(personajeHabilidad);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar:" + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            habilidadesPersonajeService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar:" + e.getMessage());
            return rutaHTML;
        }
    }
}
