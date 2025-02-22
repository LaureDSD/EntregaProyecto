package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/personaje/personajesItems")
public class InventarioWebController {

    private final String rutaHTML = "/admin/personaje/personajesItems";

    @Autowired
    private InventarioPersonajeService inventarioService;

    @Autowired
    private PersoanjeService persoanjeService;
    private List<Personaje> pl;

    @Autowired
    private ItemService itemService;
    private List<Item> il;

    // Endpoint para mostrar la lista de inventarios de personajes
    @GetMapping
    public String listar(Model model) {
        try {
            pl = persoanjeService.getAll();
            il = itemService.getAll();
            List<InventarioPersonaje> inventarios = inventarioService.getAll();
            model.addAttribute("persoanjesItems", inventarios);
            model.addAttribute("persoanjeItem", new InventarioPersonaje());
            model.addAttribute("itemList", il);
            model.addAttribute("personajeList", pl );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los inventarios de personajes: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            InventarioPersonaje inventarioPersonaje = (id != null) ? inventarioService.getByID(id) : new InventarioPersonaje();
            model.addAttribute("inventarioPersonaje", inventarioPersonaje);
            model.addAttribute("itemList", il);
            model.addAttribute("personajeList", pl );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el inventario de personaje para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("inventarioPersonaje") InventarioPersonaje inventarioPersonaje, Model model) {
        try {
            inventarioService.setItem(inventarioPersonaje);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el inventario de personaje: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            inventarioService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el inventario de personaje: " + e.getMessage());
            return rutaHTML;
        }
    }
}
