package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/misionesItems")
public class MisionRecompensaWebController {

    @Autowired
    private MisionItemService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<MisionItem> misionesItems = service.getAll();
            model.addAttribute("misionesItems", misionesItems);
            model.addAttribute("misionItem", new MisionItem());
            return "admin/misionesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los items de misión: " + e.getMessage());
            return "admin/misionesItems";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MisionItem misionItem = (id != null) ? service.getByID(id) : new MisionItem();
            model.addAttribute("misionItem", misionItem);
            return "admin/misionesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el item de misión para editar: " + e.getMessage());
            return "admin/misionesItems";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("misionItem") MisionItem misionItem, Model model) throws IOException {
        try {
            service.setItem(misionItem);
            return "redirect:/admin/misionesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el item de misión: " + e.getMessage());
            return "admin/misionesItems";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/misionesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el item de misión: " + e.getMessage());
            return "admin/misionesItems";
        }
    }
}
