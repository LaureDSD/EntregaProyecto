package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/habilidad/habilidades")
public class HabilidadWebController {

    private final String rutaHTML = "/admin/habilidad/habilidades";

    @Autowired
    private HabilidadService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<Habilidad> habilidades = service.getAll();
            model.addAttribute("habilidades", habilidades);
            model.addAttribute("habilidad", new Habilidad());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las habilidades: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Habilidad habilidad = (id != null) ? service.getByID(id) : new Habilidad();
            model.addAttribute("habilidad", habilidad);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la habilidad para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("habilidad") Habilidad habilidad, Model model) throws IOException {
        try {
            service.setItem(habilidad);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la habilidad: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la habilidad: " + e.getMessage());
            return rutaHTML;
        }
    }
}
