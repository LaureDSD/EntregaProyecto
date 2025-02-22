package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/npcs")
public class NpcWebController {

    @Autowired
    private NpcService npcService;

    @GetMapping
    public String listar(Model model) {
        try {
            List<Npc> npcs = npcService.getAll();
            model.addAttribute("npcs", npcs);
            model.addAttribute("npc", new Npc());
            return "admin/npcs";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los NPCs: " + e.getMessage());
            return "admin/npcs";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Npc npc = (id != null) ? npcService.getByID(id) : new Npc();
            model.addAttribute("npc", npc);
            return "admin/npcs";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el NPC para editar: " + e.getMessage());
            return "admin/npcs";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("npc") Npc npc, Model model) throws IOException {
        try {
            npcService.setItem(npc);
            return "redirect:/admin/npcs";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el NPC: " + e.getMessage());
            return "admin/npcs";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            npcService.deleteByID(id);
            return "redirect:/admin/npcs";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el NPC: " + e.getMessage());
            return "admin/npcs";
        }
    }
}
