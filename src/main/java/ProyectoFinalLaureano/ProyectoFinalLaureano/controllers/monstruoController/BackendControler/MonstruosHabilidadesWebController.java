package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoHabilidadService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/monstruo/monstruosHabilidades")
public class MonstruosHabilidadesWebController {

    private final String rutaHTML ="/admin/monstruo/monstruosHabilidades";

    @Autowired
    private MonstruoHabilidadService monstruoHabilidadService;

    @Autowired
    private MonstruosService monstruosService;

    @Autowired
    private HabilidadService habilidadService;

    private List<Monstruo> ml;
    private List<Habilidad> hl;

    @GetMapping
    public String listar(Model model) {
        try {
            ml = monstruosService.getAll();
            hl = habilidadService.getAll();
            List<MonstruoHabilidad> monstruosHabilidades = monstruoHabilidadService.getAll();
            model.addAttribute("monstruosHabilidades", monstruosHabilidades);
            model.addAttribute("monstruoHabilidad", new MonstruoHabilidad());
            model.addAttribute("monstruoList",ml);
            model.addAttribute("habilidadList", hl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las habilidades de monstruos: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MonstruoHabilidad monstruoHabilidad = (id != null) ? monstruoHabilidadService.getByID(id) : new MonstruoHabilidad();
            model.addAttribute("monstruoHabilidad", monstruoHabilidad);
            model.addAttribute("monstruoList",ml);
            model.addAttribute("habilidadList", hl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la habilidad del monstruo para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("monstruoHabilidad") MonstruoHabilidad monstruoHabilidad, Model model) throws IOException {
        try {
            monstruoHabilidadService.setItem(monstruoHabilidad);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la habilidad del monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            monstruoHabilidadService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la habilidad del monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }
}
