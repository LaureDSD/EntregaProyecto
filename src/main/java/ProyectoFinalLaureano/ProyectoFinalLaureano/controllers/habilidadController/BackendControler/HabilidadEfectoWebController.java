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
@RequestMapping("/admin/habilidad/habilidadesEfectos")
public class HabilidadEfectoWebController {


    private final String rutaHTML = "/admin/habilidad/habilidadesEfectos"
;
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
            el = efectoEstadoService.getAll();
            hl = habilidadService.getAll();
            List<HabilidadEfecto> habilidades = service.getAll();
            model.addAttribute("habilidadesEfectos", habilidades);
            model.addAttribute("habilidadEfecto", new HabilidadEfecto());
            model.addAttribute("habilidadLista", hl);
            model.addAttribute("efectoLista", el);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las habilidades: " + e.getMessage());
            return rutaHTML;
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
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el efecto para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar un efecto de habilidad (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("habilidadEfecto") HabilidadEfecto habilidadEfecto, Model model) {
        try {
            service.setItem(habilidadEfecto);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el efecto: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar un efecto de habilidad
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el efecto: " + e.getMessage());
            return rutaHTML;
        }
    }
}
