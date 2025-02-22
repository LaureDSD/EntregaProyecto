package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mision/misionesItems")
public class MisionRecompensaWebController {

    private final String rutaHTML ="/admin/mision/misionesItems";

    @Autowired
    private MisionItemService service;

    @Autowired
    private MisionService misionService;

    @Autowired
    private ItemService itemService;

    private List<Mision> ml;
    private List<Item> il;

    @GetMapping
    public String listar(Model model) {
        try {
            ml = misionService.getAll();
            il = itemService.getAll();
            List<MisionItem> misionesItems = service.getAll();
            model.addAttribute("misionesItems", misionesItems);
            model.addAttribute("misionItem", new MisionItem());
            model.addAttribute("misionList", ml);
            model.addAttribute("itemList", il);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los items de misión: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MisionItem misionItem = (id != null) ? service.getByID(id) : new MisionItem();
            model.addAttribute("misionItem", misionItem);
            model.addAttribute("misionList", ml);
            model.addAttribute("itemList", il);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el item de misión para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("misionItem") MisionItem misionItem, Model model) throws IOException {
        try {
            service.setItem(misionItem);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el item de misión: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el item de misión: " + e.getMessage());
            return rutaHTML;
        }
    }
}
