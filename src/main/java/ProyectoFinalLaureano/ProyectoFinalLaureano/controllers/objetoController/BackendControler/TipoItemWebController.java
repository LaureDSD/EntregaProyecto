package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController.BackendControler;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.TipoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/tipoItem")
public class TipoItemWebController {

    @Autowired
    private TipoItemService tipoItemService;

    // Listado de Clases de Personaje
    @GetMapping
    public String listarClasesPersonaje(Model model) {
        List<TipoItem> o = tipoItemService.getAll();
        model.addAttribute("tiposItem", o);
        return "admin/tipoItem";
    }

    // Formulario para crear o editar Clase de Personaje
    @GetMapping("/edit/{id}")
    public String editarClasePersonaje(@PathVariable("id") Long id, Model model) {
        TipoItem o = (id != null) ? tipoItemService.getByID(id) : new TipoItem();
        model.addAttribute("tipoItem", o);
        return "admin/tipoItem";
    }

    // Guardar Clase de Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarClasePersonaje(@ModelAttribute("tipoItem") TipoItem o) throws IOException {
        tipoItemService.setItem(o);
        return "redirect:/admin/tipoItem";
    }

    // Eliminar Clase de Personaje
    @GetMapping("/delete/{id}")
    public String eliminarClasePersonaje(@PathVariable("id") Long id) {
        try {
            tipoItemService.deleteByID(id);
            return "redirect:/admin/tipoItem";
        }catch (Exception e){
            return "redirect:/admin/tipoItem";
        }

    }
}
