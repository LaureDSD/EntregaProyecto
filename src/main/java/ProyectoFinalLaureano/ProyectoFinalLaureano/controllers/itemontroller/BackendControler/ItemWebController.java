package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.itemontroller.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.TipoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/item/items")
public class ItemWebController {

    private final String rutaHTML = "/admin/item/items";

    @Autowired
    private ItemService itemService;

    @Autowired
    private TipoItemService tipoItemService;

    private List<TipoItem> til;

    // Endpoint para mostrar la lista de items
    @GetMapping
    public String listarItem(Model model) {
        try {
            til = tipoItemService.getAll();
            List<Item> items = itemService.getAll();
            model.addAttribute("items", items);
            model.addAttribute("item", new Item());
            model.addAttribute("tiposItem", til );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los items: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para editar un item
    @GetMapping("/edit/{id}")
    public String editarItem(@PathVariable("id") Long id, Model model) {
        try {
            Item item = (id != null) ? itemService.getByID(id) : new Item();
            model.addAttribute("item", item);
            model.addAttribute("tiposItem", til );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el item para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para guardar un item (crear o actualizar)
    @PostMapping("/save")
    public String guardarItem(@ModelAttribute("item") Item item, Model model) {
        try {
            itemService.setItem(item);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el item: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para eliminar un item
    @GetMapping("/delete/{id}")
    public String eliminarItem(@PathVariable("id") Long id, Model model) {
        try {
            itemService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el item: " + e.getMessage());
            return rutaHTML;
        }
    }
}
