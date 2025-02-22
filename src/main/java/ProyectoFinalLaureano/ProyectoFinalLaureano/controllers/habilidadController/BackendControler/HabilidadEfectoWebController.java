package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/habilidadesEfectos")
public class HabilidadEfectoWebController {

    @Autowired
    private HabilidadEfectoService service;

    @Autowired
    private HabilidadService habilidadService;

    @Autowired
    private EfectoEstadoService efectoEstadoService;

    private List<Habilidad> hl;
    private List<EfectoEstado> el;

    // Listar todas las habilidades y efectos
    @GetMapping
    public String listar(Model model) {
        try {
            try{ el = efectoEstadoService.getAll(); }catch (Exception e){}
            try{ hl = habilidadService.getAll(); }catch (Exception e){}
            List<HabilidadEfecto> habilidades = service.getAll();
            model.addAttribute("habilidadesEfectos", habilidades);
            model.addAttribute("habilidadEfecto", new HabilidadEfecto());
            model.addAttribute("habilidadLista", hl);
            model.addAttribute("efectoLista", el);
            return "admin/habilidadesEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las habilidades: " + e.getMessage());
            return "admin/habilidadesEfectos";
        }
    }

    // Formulario para crear o editar un efecto de habilidad
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            HabilidadEfecto habilidadEfecto = (id != null) ? service.getByID(id) : new HabilidadEfecto();
            model.addAttribute("habilidadEfecto", habilidadEfecto);
            model.addAttribute("habilidadLista",hl);
            model.addAttribute("efectoLista", el);
            return "admin/habilidadesEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el efecto para editar: " + e.getMessage());
            return "admin/habilidadesEfectos";
        }
    }

    // Guardar un efecto de habilidad (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("habilidadEfecto") HabilidadEfecto habilidadEfecto, Model model) {
        try {
            service.setItem(habilidadEfecto);
            return "redirect:/admin/habilidadesEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el efecto: " + e.getMessage());
            return "admin/habilidadesEfectos";
        }
    }

    // Eliminar un efecto de habilidad
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/habilidadesEfectos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el efecto: " + e.getMessage());
            return "admin/habilidadesEfectos";
        }
    }
}
