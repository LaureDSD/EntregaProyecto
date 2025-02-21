package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/admin/estados")
public class EfectoWebController {

    @Autowired
    private EfectoEstadoService service;

    // Listar todos los estados y mostrar el formulario
    @GetMapping
    public String listar(Model model) {
        try {
            List<EfectoEstado> estados = service.getAll();
            model.addAttribute("estados", estados);
            model.addAttribute("estado", new EfectoEstado());
            return "admin/estados";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al cargar los estados");
            return "admin/estados";
        }
    }

    // Guardar o actualizar
    @PostMapping("/save")
    public String guardar(@ModelAttribute("estado") EfectoEstado estado) {
        try {
            service.setItem(estado);
            return "redirect:/admin/estados";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/estados";
        }
    }

    // Eliminar
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/estados";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/estados";
        }
    }

    // Cargar formulario de edición
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            EfectoEstado estado = service.getByID(id);
            model.addAttribute("estado", estado);
            return "admin/estados";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/estados";
        }
    }
}
