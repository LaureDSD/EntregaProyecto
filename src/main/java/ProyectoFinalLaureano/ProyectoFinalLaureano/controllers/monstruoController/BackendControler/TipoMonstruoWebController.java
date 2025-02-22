package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.TipoMonstruoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/tipoMonstruo")
public class TipoMonstruoWebController {

    @Autowired
    private TipoMonstruoService tipoMonstruoService;

    // Listado de Tipos de Monstruo
    @GetMapping
    public String listar(Model model) {
        try {
            List<TipoMonstruo> tipoMonstruos = tipoMonstruoService.getAll();
            model.addAttribute("tipoMonstruos", tipoMonstruos);
            model.addAttribute("tipoMonstruo", new TipoMonstruo());
            return "admin/tipoMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los tipos de monstruo: " + e.getMessage());
            return "admin/tipoMonstruo";
        }
    }

    // Formulario para crear o editar Tipo de Monstruo
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            TipoMonstruo tipoMonstruo = (id != null) ? tipoMonstruoService.getByID(id) : new TipoMonstruo();
            model.addAttribute("tipoMonstruo", tipoMonstruo);
            return "admin/tipoMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el tipo de monstruo para editar: " + e.getMessage());
            return "admin/tipoMonstruo";
        }
    }

    // Guardar Tipo de Monstruo (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("tipoMonstruo") TipoMonstruo tipoMonstruo, Model model) throws IOException {
        try {
            tipoMonstruoService.setItem(tipoMonstruo);
            return "redirect:/admin/tipoMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el tipo de monstruo: " + e.getMessage());
            return "admin/tipoMonstruo";
        }
    }

    // Eliminar Tipo de Monstruo
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            tipoMonstruoService.deleteByID(id);
            return "redirect:/admin/tipoMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el tipo de monstruo: " + e.getMessage());
            return "admin/tipoMonstruo";
        }
    }
}
