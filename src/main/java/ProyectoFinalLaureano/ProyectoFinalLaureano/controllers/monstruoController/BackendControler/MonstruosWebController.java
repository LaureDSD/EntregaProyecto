package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/monstruos")
public class MonstruosWebController {

    @Autowired
    private MonstruosService monstruosService;

    // Listado de Monstruos
    @GetMapping
    public String List(Model model) {
        List<Monstruo> monstruos = monstruosService.getAll();
        model.addAttribute("monstruos", monstruos);
        return "admin/monstruos";
    }

    // Formulario para crear o editar Monstruo
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Monstruo monstruos = (id != null) ? monstruosService.getByID(id) : new Monstruo();
        model.addAttribute("monstruos", monstruos);
        return "admin/monstruos";
    }

    // Guardar Monstruo (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("monstruos") Monstruo u) throws IOException {
        monstruosService.setItem(u);
        return "admin/monstruos";
    }

    // Eliminar Monstruo
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            monstruosService.deleteByID(id);
            return "admin/monstruos";
        } catch (Exception e) {
            return "admin/monstruos";
        }
    }
}
