package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NpcItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NpcItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/npcsItems")
public class NpcItemWebController {

    @Autowired
    private NpcItemService npcItemService;

    @Autowired
    private NpcService npcService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String listar(Model model) {
        try {
            List<NpcItem> npcItems = npcItemService.getAll();
            model.addAttribute("npcsItems", npcItems);
            model.addAttribute("npcItem", new NpcItem());
            model.addAttribute("npcList", npcService.getAll());
            model.addAttribute("itemList", itemService.getAll());
            return "admin/npcsItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los items de NPC: " + e.getMessage());
            return "admin/npcsItems";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            NpcItem npcItem = (id != null) ? npcItemService.getByID(id) : new NpcItem();
            model.addAttribute("npcItem", npcItem);
            model.addAttribute("npcList", npcService.getAll());
            model.addAttribute("itemList", itemService.getAll());
            return "admin/npcsItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el item de NPC para editar: " + e.getMessage());
            return "admin/npcsItems";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("npcItem") NpcItem npcItem, Model model) throws IOException {
        try {
            npcItemService.setItem(npcItem);
            return "redirect:/admin/npcsItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el item de NPC: " + e.getMessage());
            return "admin/npcsItems";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            npcItemService.deleteByID(id);
            return "redirect:/admin/npcsItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el item de NPC: " + e.getMessage());
            return "admin/npcsItems";
        }
    }
}
