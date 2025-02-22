package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogTransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/logTransacciones")
public class LogTransaccionesWebController {

    @Autowired
    private LogTransaccionesService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<LogTransacciones> logTransacciones = service.getAll();
            model.addAttribute("logTransacciones", logTransacciones);
            model.addAttribute("logTransaccion", new LogTransacciones());
            return "admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logs de transacciones: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogTransacciones logTransacciones = (id != null) ? service.getByID(id) : new LogTransacciones();
            model.addAttribute("logTransacciones", logTransacciones);
            return "admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el log de transacciones para editar: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("logTransacciones") LogTransacciones logTransacciones, Model model) throws IOException {
        try {
            service.setItem(logTransacciones);
            return "redirect:/admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el log de transacciones: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el log de transacciones: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }
}
