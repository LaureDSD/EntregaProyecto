package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.itemontroller.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/itemsEfectos")
public class ItemEfectoWebController {

    @Autowired
    private ItemEfectoService itemEfectoService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private EfectoEstadoService efectoEstadoService;

    private List<Item> il;
    private List<EfectoEstado> el;

    // Endpoint para mostrar la lista de items de efectos
    @GetMapping
    public String listar(Model model) {
        try {
            try{il = itemService.getAll();}catch (Exception e ){ throw e;}
            try{el = efectoEstadoService.getAll();}catch (Exception e ){ throw e;}
            List<ItemEfecto> itemsEfectos = itemEfectoService.getAll();
            model.addAttribute("itemsEfectos", itemsEfectos);
            model.addAttribute("itemEfecto", new ItemEfecto());
            model.addAttribute("itemList", il);
            model.addAttribute("efectoList", el);
            return "admin/itemsEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los items de efectos: " + e.getMessage());
            return "admin/itemsEfectos";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            ItemEfecto itemEfecto = (id != null) ? itemEfectoService.getByID(id) : new ItemEfecto();
            model.addAttribute("itemEfecto", itemEfecto);
            model.addAttribute("itemList", il);
            model.addAttribute("efectoList", el);
            return "admin/itemsEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el item de efecto para editar: " + e.getMessage());
            return "admin/itemsEfectos";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("itemEfecto") ItemEfecto itemEfecto, Model model) {
        try {
            itemEfectoService.setItem(itemEfecto);
            return "redirect:/admin/itemsEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el item de efecto: " + e.getMessage());
            return "admin/itemsEfectos";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            itemEfectoService.deleteByID(id);
            return "redirect:/admin/itemsEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el item de efecto: " + e.getMessage());
            return "admin/itemsEfectos";
        }
    }
}
