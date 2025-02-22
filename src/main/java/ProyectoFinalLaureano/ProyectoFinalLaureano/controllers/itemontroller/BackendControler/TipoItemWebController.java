package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.itemontroller.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.TipoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/item/tipoItem")
public class TipoItemWebController {

    private final String rutaHTML ="/admin/item/tipoItem";

    @Autowired
    private TipoItemService tipoItemService;

    // Listado de Tipos de Item
    @GetMapping
    public String listarTiposItem(Model model) {
        try {
            List<TipoItem> tiposItem = tipoItemService.getAll();
            model.addAttribute("tiposItem", tiposItem);
            model.addAttribute("tipoItem", new TipoItem());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los tipos de item: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar Tipo de Item
    @GetMapping("/edit/{id}")
    public String editarTipoItem(@PathVariable("id") Long id, Model model) {
        try {
            TipoItem tipoItem = (id != null) ? tipoItemService.getByID(id) : new TipoItem();
            model.addAttribute("tipoItem", tipoItem);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el tipo de item para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar Tipo de Item (creación o actualización)
    @PostMapping("/save")
    public String guardarTipoItem(@ModelAttribute("tipoItem") TipoItem tipoItem, Model model) throws IOException {
        try {
            tipoItemService.setItem(tipoItem);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el tipo de item: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar Tipo de Item
    @GetMapping("/delete/{id}")
    public String eliminarTipoItem(@PathVariable("id") Long id, Model model) {
        try {
            tipoItemService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el tipo de item: " + e.getMessage());
            return rutaHTML;
        }
    }
}
