package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersonajeMisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/personajesMisiones")
public class PersonajeMisionesWebController {

    @Autowired
    private PersonajeMisionService personajeMisionService;

    // Endpoint para mostrar la lista de misiones de personajes
    @GetMapping
    public String listarMisiones(Model model) {
        try {
            try{}catch (Exception e){throw  e;}
            try{}catch (Exception e){throw  e;}
            List<PersonajeMision> misiones = personajeMisionService.getAll();
            model.addAttribute("personajesMisiones", misiones);
            model.addAttribute("personajeMisione", new Mision());
            return "admin/personajesMisiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las misiones de personajes: " + e.getMessage());
            return "admin/personajesMisiones";
        }
    }

    // Endpoint para mostrar el formulario de edición de una misión
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            PersonajeMision mision = (id != null) ? personajeMisionService.getByID(id) : new PersonajeMision();
            model.addAttribute("personajeMision", mision);
            return "admin/personajesMisiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la misión para editar: " + e.getMessage());
            return "admin/personajesMisiones";
        }
    }

    // Endpoint para guardar una misión
    @PostMapping("/save")
    public String guardar(@ModelAttribute("personajeMision") PersonajeMision mision, Model model) {
        try {
            personajeMisionService.setItem(mision);
            return "redirect:/admin/personajesMisiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la misión: " + e.getMessage());
            return "admin/personajesMisiones";
        }
    }

    // Endpoint para eliminar una misión
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            personajeMisionService.deleteByID(id);
            return "redirect:/admin/personajesMisiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la misión: " + e.getMessage());
            return "admin/personajesMisiones";
        }
    }
}
