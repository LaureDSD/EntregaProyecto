package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NpcService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TipoNpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/npc/npcs")
public class NpcWebController {

    private final String rutaHTML ="/admin/npc/npcs";

    @Autowired
    private NpcService npcService;

    @Autowired
    private TipoNpcService tipoNPC;

    @GetMapping
    public String listar(Model model) {
        try {
            List<Npc> npcs = npcService.getAll();
            model.addAttribute("npcs", npcs);
            model.addAttribute("npc", new Npc());
            model.addAttribute("tiposNpc", tipoNPC.getAll());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los NPCs: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Npc npc = (id != null) ? npcService.getByID(id) : new Npc();
            model.addAttribute("npc", npc);
            model.addAttribute("tiposNpc", tipoNPC.getAll());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el NPC para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("npc") Npc npc, Model model) throws IOException {
        try {
            npcService.setItem(npc);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el NPC: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            npcService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el NPC: " + e.getMessage());
            return rutaHTML;
        }
    }
}
