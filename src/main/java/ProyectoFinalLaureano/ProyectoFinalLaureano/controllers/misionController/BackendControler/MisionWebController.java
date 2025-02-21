package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/misiones")
public class MisionWebController {

    @Autowired
    private MisionService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<Mision> misiones = service.getAll();
            model.addAttribute("misiones", misiones);
            return "admin/misiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las misiones: " + e.getMessage());
            return "admin/misiones";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Mision mision = (id != null) ? service.getByID(id) : new Mision();
            model.addAttribute("mision", mision);
            return "admin/misiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la misión para editar: " + e.getMessage());
            return "admin/misiones";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("mision") Mision mision, Model model) throws IOException {
        try {
            service.setItem(mision);
            return "redirect:/admin/misiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la misión: " + e.getMessage());
            return "admin/misiones";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/misiones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la misión: " + e.getMessage());
            return "admin/misiones";
        }
    }
}
