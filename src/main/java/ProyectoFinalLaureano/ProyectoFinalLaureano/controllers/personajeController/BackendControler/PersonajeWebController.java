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

    // Listado de  de Personaje
    @GetMapping
    public String listarPersonaje(Model model) {
        List<Personaje> personaje = personajeService.getAll();
        model.addAttribute("personaje", personaje);
        return "admin/personajes";
    }

    // Formulario para crear o editar  de Personaje
    @GetMapping("/edit/{id}")
    public String editarPersonaje(@PathVariable("id") Long id, Model model) {
        Personaje personaje = (id != null) ? personajeService.getByID(id) : new Personaje();
        model.addAttribute("personaje", personaje);
        return "admin/personajes";
    }

    // Guardar  de Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarPersonaje(@ModelAttribute("personaje") Personaje personaje) throws IOException {
        personajeService.setItem(personaje);
        return "admin/personajes";
    }

    // Eliminar  de Personaje
    @GetMapping("/delete/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id) {
        try {
            personajeService.deleteByID(id);
            return "redirect:/admin/tipoPersonajes";
        }catch (Exception e){
            return "redirect:/admin/tipoPersonajes";
        }

    }

}
