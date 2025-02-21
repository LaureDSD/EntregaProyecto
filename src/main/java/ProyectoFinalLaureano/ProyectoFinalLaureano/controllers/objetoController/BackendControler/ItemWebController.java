package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/items")
public class ItemWebController {

    @Autowired
    private ItemService itemService;

    // Listado de  de Personaje
    @GetMapping
    public String listarPersonaje(Model model) {
        List<Item> o = itemService.getAll();
        model.addAttribute("items", o);
        return "admin/item";
    }

    // Formulario para crear o editar  de Personaje
    @GetMapping("/edit/{id}")
    public String editarPersonaje(@PathVariable("id") Long id, Model model) {
        Item o = (id != null) ? itemService.getByID(id) : new Item();
        model.addAttribute("item", o);
        return "admin/item";
    }

    // Guardar  de Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarPersonaje(@ModelAttribute("item") Item o) throws IOException {
        itemService.setItem(o);
        return "admin/item";
    }

    // Eliminar  de Personaje
    @GetMapping("/delete/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id) {
        try {
            itemService.deleteByID(id);
            return "redirect:/admin/item";
        }catch (Exception e){
            return "redirect:/admin/item";
        }

    }

}
