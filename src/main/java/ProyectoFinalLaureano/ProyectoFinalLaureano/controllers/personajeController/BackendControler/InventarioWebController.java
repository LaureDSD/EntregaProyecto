package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/persoanjesItems")
public class InventarioWebController {

    @Autowired
    private InventarioPersonajeService inventarioService;

    // Endpoint para mostrar la lista de inventarios de personajes
    @GetMapping
    public String listar(Model model) {
        try {
            try{}catch (Exception e){throw  e;}
            try{}catch (Exception e){throw  e;}
            List<InventarioPersonaje> inventarios = inventarioService.getAll();
            model.addAttribute("persoanjesItems", inventarios);
            model.addAttribute("persoanjeItem", new InventarioPersonaje());
            return "admin/persoanjesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los inventarios de personajes: " + e.getMessage());
            return "admin/persoanjesItems";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            InventarioPersonaje inventarioPersonaje = (id != null) ? inventarioService.getByID(id) : new InventarioPersonaje();
            model.addAttribute("inventarioPersonaje", inventarioPersonaje);
            return "admin/persoanjesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el inventario de personaje para editar: " + e.getMessage());
            return "admin/persoanjesItems";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("inventarioPersonaje") InventarioPersonaje inventarioPersonaje, Model model) {
        try {
            inventarioService.setItem(inventarioPersonaje);
            return "redirect:/admin/persoanjesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el inventario de personaje: " + e.getMessage());
            return "admin/persoanjesItems";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            inventarioService.deleteByID(id);
            return "redirect:/admin/persoanjesItems";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el inventario de personaje: " + e.getMessage());
            return "admin/persoanjesItems";
        }
    }
}
