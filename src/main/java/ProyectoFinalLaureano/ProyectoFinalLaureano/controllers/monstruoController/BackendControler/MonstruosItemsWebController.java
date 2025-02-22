package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/monstruo/monstruosItems")
public class MonstruosItemsWebController {

    private final String rutaHTML ="/admin/monstruo/monstruosItems";

    @Autowired
    private MonstruoItemService monstruoItemService;

    @Autowired
    private MonstruosService monstruosService;

    @Autowired
    private ItemService itemService;

    private List<Monstruo> ml;
    private List<Item> il;

    @GetMapping
    public String listar(Model model) {
        try {
            ml = monstruosService.getAll();
            il = itemService.getAll();
            List<MonstruoItem> monstruosItems = monstruoItemService.getAll();
            model.addAttribute("monstruosItems", monstruosItems);
            model.addAttribute("monstruoItem", new MonstruoItem());
            model.addAttribute("monstruoList", ml);
            model.addAttribute("itemList", il);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los items de monstruos: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MonstruoItem monstruoItem = (id != null) ? monstruoItemService.getByID(id) : new MonstruoItem();
            model.addAttribute("monstruoItem", monstruoItem);
            model.addAttribute("monstruoList", ml);
            model.addAttribute("itemList", il);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el item de monstruo para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("monstruoItem") MonstruoItem monstruoItem, Model model) throws IOException {
        try {
            monstruoItemService.setItem(monstruoItem);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el item de monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            monstruoItemService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el item de monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }
}
