package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/grupos")
public class GrupoWebController {

    @Autowired
    private GrupoService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<Grupo> grupos = service.getAll();
            model.addAttribute("grupos", grupos);
            model.addAttribute("grupo", new Grupo());
            return "admin/grupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los grupos: " + e.getMessage());
            return "admin/grupos";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Grupo grupo = (id != null) ? service.getByID(id) : new Grupo();
            model.addAttribute("grupo", grupo);
            return "admin/grupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el grupo para editar: " + e.getMessage());
            return "admin/grupos";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("grupo") Grupo grupo, Model model) throws IOException {
        try {
            service.setItem(grupo);
            return "redirect:/admin/grupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el grupo: " + e.getMessage());
            return "admin/grupos";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/grupos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el grupo: " + e.getMessage());
            return "admin/grupos";
        }
    }
}
