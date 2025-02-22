package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.TipoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/grupos")
public class GrupoWebController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private TipoGrupoService tipoGrupoService;

    // Listar todos los grupos
    @GetMapping
    public String listar(Model model) {
        try {
            List<Grupo> grupos = grupoService.getAll(); // Obtener todos los grupos
            model.addAttribute("grupos", grupos);
            model.addAttribute("grupo", new Grupo()); // Crear un objeto vacío para agregar un nuevo grupo
            model.addAttribute("tiposGrupo", tipoGrupoService.getAll()); // Obtener todos los tipos de grupo
            return "admin/grupos"; // Vista de administración
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los grupos: " + e.getMessage());
            return "admin/grupos"; // En caso de error, volver a la vista
        }
    }

    // Editar un grupo existente
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Grupo grupo = (id != null) ? grupoService.getByID(id) : new Grupo(); // Buscar el grupo por ID o crear uno nuevo
            model.addAttribute("grupo", grupo); // Añadir el grupo al modelo
            model.addAttribute("tiposGrupo", tipoGrupoService.getAll()); // Añadir los tipos de grupo disponibles
            return "admin/grupos"; // Vista para editar el grupo
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el grupo para editar: " + e.getMessage());
            return "admin/grupos"; // En caso de error, volver a la vista
        }
    }

    // Guardar un grupo (crear o editar)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("grupo") Grupo grupo, Model model) {
        try {
            grupoService.setItem(grupo); // Guardar el grupo
            return "redirect:/admin/grupos"; // Redirigir al listado de grupos
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el grupo: " + e.getMessage());
            return "admin/grupos"; // En caso de error, volver a la vista
        }
    }

    // Eliminar un grupo
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            grupoService.deleteByID(id); // Eliminar el grupo por ID
            return "redirect:/admin/grupos"; // Redirigir al listado de grupos
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el grupo: " + e.getMessage());
            return "admin/grupos"; // En caso de error, volver a la vista
        }
    }
}
