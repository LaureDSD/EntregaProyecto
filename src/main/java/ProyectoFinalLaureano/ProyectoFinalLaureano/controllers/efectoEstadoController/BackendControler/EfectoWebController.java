package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/estado/estados")
public class EfectoWebController {

    private final String rutaHTML = "/admin/estado/estados";

    @Autowired
    private EfectoEstadoService service;

    // Listar todos los estados y mostrar el formulario
    @GetMapping
    public String listar(Model model) {
        try {
            List<EfectoEstado> estados = service.getAll();
            model.addAttribute("estados", estados);
            model.addAttribute("estado", new EfectoEstado());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los estados: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar o actualizar
    @PostMapping("/save")
    public String guardar(@ModelAttribute("estado") EfectoEstado estado, Model model) {
        try {
            service.setItem(estado);
            return "redirect:" + rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el estado: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:" + rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el estado: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Cargar formulario de edición
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            EfectoEstado estado = service.getByID(id);
            model.addAttribute("estado", estado);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el estado para editar: " + e.getMessage());
            return rutaHTML;
        }
    }
}
