package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.estadisticasService.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/estadisticas")
public class EstadisticasWebController {

    @Autowired
    private EstadisticasService service;

    // Listado de Estadísticas
    @GetMapping
    public String listar(Model model) {
        try {
            List<EstadisticasGenerales> estadisticas = service.getAll();
            model.addAttribute("estadisticas", estadisticas);
            model.addAttribute("estadistica", new EstadisticasGenerales());
            return "admin/estadisticas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las estadísticas: " + e.getMessage());
            return "admin/estadisticas";
        }
    }

    // Formulario de edición
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            EstadisticasGenerales estadistica = (id != null) ? service.getByID(id) : new EstadisticasGenerales();
            model.addAttribute("estadistica", estadistica);
            return "admin/estadisticas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la estadística para editar: " + e.getMessage());
            return "admin/estadisticas";
        }
    }

    // Guardar o actualizar una estadística
    @PostMapping("/save")
    public String guardar(@ModelAttribute("estadistica") EstadisticasGenerales estadistica, Model model) throws IOException {
        try {
            service.setItem(estadistica);
            return "redirect:/admin/estadisticas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la estadística: " + e.getMessage());
            return "admin/estadisticas";
        }
    }

    // Eliminar una estadística
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/estadisticas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la estadística: " + e.getMessage());
            return "admin/estadisticas";
        }
    }
}
