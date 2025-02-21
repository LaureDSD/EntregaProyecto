package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/monstruosItems")
public class MonstruosItemsWebController {

    @Autowired
    private MonstruoItemService monstruosService;

    @GetMapping
    public String listar(Model model) {
        try {
            List<MonstruoItem> monstruosItems = monstruosService.getAll();
            model.addAttribute("monstruosItems", monstruosItems);
            return "admin/monstruosItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los items de monstruos: " + e.getMessage());
            return "admin/monstruosItems";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MonstruoItem monstruoItem = (id != null) ? monstruosService.getByID(id) : new MonstruoItem();
            model.addAttribute("monstruoItem", monstruoItem);
            return "admin/monstruosItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el item de monstruo para editar: " + e.getMessage());
            return "admin/monstruosItems";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("monstruoItem") MonstruoItem monstruoItem, Model model) throws IOException {
        try {
            monstruosService.setItem(monstruoItem);
            return "redirect:/admin/monstruosItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el item de monstruo: " + e.getMessage());
            return "admin/monstruosItems";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            monstruosService.deleteByID(id);
            return "redirect:/admin/monstruosItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el item de monstruo: " + e.getMessage());
            return "admin/monstruosItems";
        }
    }
}
