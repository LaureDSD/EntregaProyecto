package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.LiderGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.LiderGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/lideresGrupos")
public class LiderGrupoWebController {

    @Autowired
    private LiderGrupoService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<LiderGrupo> lideresGrupos = service.findAll();
            model.addAttribute("lideresGrupos", lideresGrupos);
            model.addAttribute("liderGrupo", new LiderGrupo());
            return "admin/lideresGrupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los líderes de grupos: " + e.getMessage());
            return "admin/lideresGrupos";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Object liderGrupo = (id != null) ? service.findById(id) : new LiderGrupo();
            model.addAttribute("liderGrupo", liderGrupo);
            return "admin/lideresGrupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el líder del grupo para editar: " + e.getMessage());
            return "admin/lideresGrupos";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("liderGrupo") LiderGrupo liderGrupo, Model model) throws IOException {
        try {
            service.save(liderGrupo);
            return "redirect:/admin/lideresGrupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el líder del grupo: " + e.getMessage());
            return "admin/lideresGrupos";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteById(id);
            return "redirect:/admin/lideresGrupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el líder del grupo: " + e.getMessage());
            return "admin/lideresGrupos";
        }
    }
}
