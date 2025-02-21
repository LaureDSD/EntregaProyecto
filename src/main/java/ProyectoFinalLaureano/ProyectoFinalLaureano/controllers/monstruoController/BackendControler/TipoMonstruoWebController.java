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
        List<TipoMonstruo> o = tipoMonstruoService.getAll();
        model.addAttribute("tipoMonstruo", o);
        return "admin/tipoMonstruo";
    }

    // Formulario para crear o editar Tipo de Monstruo
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        TipoMonstruo o = (id != null) ? tipoMonstruoService.getByID(id) : new TipoMonstruo();
        model.addAttribute("tipoMonstruo", o);
        return "admin/tipoMonstruo";
    }

    // Guardar Tipo de Monstruo (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("tipoMonstruo") TipoMonstruo o) throws IOException {
        tipoMonstruoService.setItem(o);
        return "admin/tipoMonstruo";
    }

    // Eliminar Tipo de Monstruo
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        try {
            tipoMonstruoService.deleteByID(id);
            return "redirect:/admin/tipoMonstruo";
        } catch (Exception e) {
            return "redirect:/admin/tipoMonstruo";
        }
    }
}
