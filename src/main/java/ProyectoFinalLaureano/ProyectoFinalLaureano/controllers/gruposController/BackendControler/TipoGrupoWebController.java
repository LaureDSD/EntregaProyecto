package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.TipoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/tiposGrupo")
public class TipoGrupoWebController {

    @Autowired
    private TipoGrupoService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<TipoGrupo> tiposGrupo = service.getAll();
            model.addAttribute("tiposGrupo", tiposGrupo);
            model.addAttribute("tipoGrupo", new TipoGrupo());
            return "admin/tiposGrupo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los tipos de grupos: " + e.getMessage());
            return "admin/tiposGrupo";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            TipoGrupo tipoGrupo = (id != null) ? service.getByID(id) : new TipoGrupo();
            model.addAttribute("tipoGrupo", tipoGrupo);
            return "admin/tiposGrupo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el tipo de grupo para editar: " + e.getMessage());
            return "admin/tiposGrupo";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("tipoGrupo") TipoGrupo tipoGrupo, Model model) throws IOException {
        try {
            service.setItem(tipoGrupo);
            return "redirect:/admin/tiposGrupo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el tipo de grupo: " + e.getMessage());
            return "admin/tiposGrupo";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/tiposGrupo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el tipo de grupo: " + e.getMessage());
            return "admin/tiposGrupo";
        }
    }
}
