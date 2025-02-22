package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TipoNpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/npc/tiposNpc")
public class TipoNpcWebController {

    private final String rutaHTML = "/admin/npc/tiposNpc";

    @Autowired
    private TipoNpcService tipoNpcService;

    @GetMapping
    public String listar(Model model) {
        try {
            List<TipoNPC> tiposNpc = tipoNpcService.getAll();
            model.addAttribute("tiposNpc", tiposNpc);
            model.addAttribute("tipoNpc", new TipoNPC());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los tipos de NPC: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            TipoNPC tipoNpc = (id != null) ? tipoNpcService.getByID(id) : new TipoNPC();
            model.addAttribute("tipoNpc", tipoNpc);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el tipo de NPC para editar: " + e.getMessage());
            return rutaHTML;
        }
    }


    @PostMapping("/save")
    public String guardar(@ModelAttribute("tipoNpc") TipoNPC tipoNpc, Model model) {
        try {
            tipoNpcService.setItem(tipoNpc);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el tipo de NPC: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            tipoNpcService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el tipo de NPC: " + e.getMessage());
            return rutaHTML;
        }
    }
}
