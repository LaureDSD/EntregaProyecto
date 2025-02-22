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
@RequestMapping("/admin/grupo/grupos")
public class GrupoWebController {

    private String rutaHTML = "/admin/grupo/grupos";

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private TipoGrupoService tipoGrupoService;

    // Listar todos los grupos
    @GetMapping
    public String listar(Model model) {
        try {
            List<Grupo> grupos = grupoService.getAll();
            model.addAttribute("grupos", grupos);
            model.addAttribute("grupo", new Grupo());
            model.addAttribute("tiposGrupo", tipoGrupoService.getAll());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los grupos: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Editar un grupo existente
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Grupo grupo = (id != null) ? grupoService.getByID(id) : new Grupo();
            model.addAttribute("grupo", grupo);
            model.addAttribute("tiposGrupo", tipoGrupoService.getAll());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el grupo para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar un grupo (crear o editar)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("grupo") Grupo grupo, Model model) {
        try {
            grupoService.setItem(grupo);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el grupo: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar un grupo
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            grupoService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el grupo: " + e.getMessage());
            return rutaHTML;
        }
    }
}
