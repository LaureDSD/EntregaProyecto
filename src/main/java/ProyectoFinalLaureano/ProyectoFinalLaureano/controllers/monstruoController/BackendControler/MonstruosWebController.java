package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.TipoMonstruoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/monstruo/monstruos")
public class MonstruosWebController {

    private final String rutaHTML = "/admin/monstruo/monstruos";

    @Autowired
    private MonstruosService monstruosService;

    @Autowired
    private TipoMonstruoService tipoMonstruoService;

    private List<TipoMonstruo> tml;

    // Listado de Monstruos
    @GetMapping
    public String List(Model model) {
        try {
            tml = tipoMonstruoService.getAll();
            List<Monstruo> monstruos = monstruosService.getAll();
            model.addAttribute("monstruos", monstruos);
            model.addAttribute("monstruo", new Monstruo());
            model.addAttribute("tipoMonstruoList", tml);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los monstruos: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar Monstruo
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Monstruo monstruo= (id != null) ? monstruosService.getByID(id) : new Monstruo();
            model.addAttribute("monstruo", monstruo);
            model.addAttribute("tipoMonstruoList", tml);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el monstruo para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar Monstruo (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("monstruo") Monstruo u, Model model) throws IOException {
        try {
            monstruosService.setItem(u);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar Monstruo
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        try {
            monstruosService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }
}
