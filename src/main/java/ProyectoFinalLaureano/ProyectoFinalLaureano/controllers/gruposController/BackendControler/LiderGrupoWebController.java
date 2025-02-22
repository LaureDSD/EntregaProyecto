package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.LiderGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.LiderGrupoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/grupo/lideresGrupos")
public class LiderGrupoWebController {

    private String rutaHTML = "/admin/grupo/lideresGrupos";

    @Autowired
    private LiderGrupoService service;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private PersoanjeService personajeService;

    private List<Grupo> gl;
    private List<Personaje> pl;

    // Listar todos los líderes de grupo
    @GetMapping
    public String listar(Model model) {
        try {
            gl = grupoService.getAll();
            pl = personajeService.getAll();
            List<LiderGrupo> lideresGrupos = service.findAll();
            model.addAttribute("lideresGrupos", lideresGrupos);
            model.addAttribute("liderGrupo", new LiderGrupo());
            model.addAttribute("grupoList", gl);
            model.addAttribute("personajeList", pl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los líderes de grupos: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Editar un líder de grupo
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Object liderGrupo = (id != null) ? service.findById(id) : new LiderGrupo();
            model.addAttribute("liderGrupo", liderGrupo);
            model.addAttribute("grupoList", gl);
            model.addAttribute("personajeList", pl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el líder del grupo para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar un líder de grupo (Crear o Editar)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("liderGrupo") LiderGrupo liderGrupo, Model model) throws IOException {
        try {
            liderGrupo.setFechaNombramiento( new Date());
            service.save(liderGrupo);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el líder del grupo: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar un líder de grupo
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteById(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el líder del grupo: " + e.getMessage());
            return rutaHTML;
        }
    }
}
