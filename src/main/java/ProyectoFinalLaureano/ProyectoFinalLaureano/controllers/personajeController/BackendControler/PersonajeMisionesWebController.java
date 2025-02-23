package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersonajeMisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/personaje/personajesMisiones")
public class PersonajeMisionesWebController {

    private final String rutaHTML = "/admin/personaje/personajesMisiones";

    @Autowired
    private PersonajeMisionService personajeMisionService;

    @Autowired
    private MisionService misionService;
    private List<Mision> ml;

    @Autowired
    private PersoanjeService persoanjeService;
    private List<Personaje> pl;


    // Endpoint para mostrar la lista de misiones de personajes
    @GetMapping
    public String listarMisiones(Model model) {
        try {
            pl = persoanjeService.getAll();
            ml = misionService.getAll();
            List<PersonajeMision> misiones = personajeMisionService.getAll();
            model.addAttribute("personajesMisiones", misiones);
            model.addAttribute("personajeMision", new PersonajeMision());
            model.addAttribute("personajeList", pl );
            model.addAttribute("misionList", ml );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las misiones de personajes: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para mostrar el formulario de edición de una misión
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            PersonajeMision mision = (id != null) ? personajeMisionService.getByID(id) : new PersonajeMision();
            model.addAttribute("personajeMision", mision);
            model.addAttribute("personajeList", pl );
            model.addAttribute("misionList", ml );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la misión para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para guardar una misión
    @PostMapping("/save")
    public String guardar(@ModelAttribute("personajeMision") PersonajeMision mision, Model model) {
        try {

            personajeMisionService.setItem(mision);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la misión: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para eliminar una misión
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            personajeMisionService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la misión: " + e.getMessage());
            return rutaHTML;
        }
    }
}
