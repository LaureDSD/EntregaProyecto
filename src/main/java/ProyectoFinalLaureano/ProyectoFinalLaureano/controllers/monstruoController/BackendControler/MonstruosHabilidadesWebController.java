package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoHabilidadService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/monstruosHabilidades")
public class MonstruosHabilidadesWebController {

    @Autowired
    private MonstruoHabilidadService monstruoHabilidadService;

    @Autowired
    private MonstruosService monstruosService;

    @Autowired
    private HabilidadService habilidadService;

    private List<Monstruo> ml;
    private List<Habilidad> hl;

    @GetMapping
    public String listar(Model model) {
        try {
            try{ml = monstruosService.getAll();}catch (Exception e){throw e;}
            try{hl = habilidadService.getAll();}catch (Exception e){throw e;}
            List<MonstruoHabilidad> monstruosHabilidades = monstruoHabilidadService.getAll();
            model.addAttribute("monstruosHabilidades", monstruosHabilidades);
            model.addAttribute("monstruoHabilidad", new MonstruoHabilidad());
            model.addAttribute("monstruoList",ml);
            model.addAttribute("habilidadList", hl);
            return "admin/monstruosHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las habilidades de monstruos: " + e.getMessage());
            return "admin/monstruosHabilidades";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MonstruoHabilidad monstruoHabilidad = (id != null) ? monstruoHabilidadService.getByID(id) : new MonstruoHabilidad();
            model.addAttribute("monstruoHabilidad", monstruoHabilidad);
            model.addAttribute("monstruoList",ml);
            model.addAttribute("habilidadList", hl);
            return "admin/monstruosHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la habilidad del monstruo para editar: " + e.getMessage());
            return "admin/monstruosHabilidades";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("monstruoHabilidad") MonstruoHabilidad monstruoHabilidad, Model model) throws IOException {
        try {
            monstruoHabilidadService.setItem(monstruoHabilidad);
            return "redirect:/admin/monstruosHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la habilidad del monstruo: " + e.getMessage());
            return "admin/monstruosHabilidades";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            monstruoHabilidadService.deleteByID(id);
            return "redirect:/admin/monstruosHabilidades";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la habilidad del monstruo: " + e.getMessage());
            return "admin/monstruosHabilidades";
        }
    }
}
